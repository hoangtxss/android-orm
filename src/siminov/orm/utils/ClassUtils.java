/** 
 * [SIMINOV FRAMEWORK]
 * Copyright [2013] [Siminov Software Solution LLP|support@siminov.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package siminov.orm.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import siminov.orm.exception.DatabaseException;
import siminov.orm.exception.SiminovCriticalException;
import siminov.orm.exception.SiminovException;
import siminov.orm.log.Log;


/**
 * Exposes class util methods to SIMINOV. 
 */
public class ClassUtils {

	/**
	 * Create a Class Object based on class name provided.
	 * @param className Name of Class
	 * @return Class Object
	 */
	public static Class<?> createClass(String className) {
		Class<?> classObject = null;
		try {
			classObject = Class.forName(className);
		} catch(Exception exception) {
			Log.loge(ClassUtils.class.getName(), "createClassObject", "Exception caught while creating class object, CLASS-NAME: " + className + ", " + exception.getMessage());
			throw new SiminovCriticalException(ClassUtils.class.getName(), "createClassObject", "Exception caught while creating class object, CLASS-NAME: " + className + ", " + exception.getMessage());
		}

		return classObject;
	}
	
	/**
	 * Creates class object based on full class name provided.
	 * @param className Name of class.
	 * @return Object of class.
	 * @throws SiminovException If any exception occur while creating class object based on class name provided.
	 */
	public static Object createClassInstance(String className) {
		
		Class<?> classObject = createClass(className);
		
		Object object = null;
		try {
			object = classObject.newInstance();
		} catch(Exception exception) {
			Log.loge(ClassUtils.class.getName(), "createClassInstance", "Exception caught while creating new instance of class, CLASS-NAME: " + className + ", " + exception.getMessage());
			throw new SiminovCriticalException(ClassUtils.class.getName(), "createClassInstance", "Exception caught while creating new instance of class, CLASS-NAME: " + className + ", " + exception.getMessage());
		}
		
		return object;
	}

	/**
	 * Create a method object.
	 * @param className Name of Class
	 * @param methodName Name of Method
	 * @param pamameterTypes Parameter Types
	 * @return Method Object
	 */
	public static Object createMethodObject(String className, String methodName, Class<?>...pamameterTypes) {
		
		Object classObject = createClassInstance(className);
		return createMethodObject(classObject, methodName, pamameterTypes);
	}

	/**
	 * Create a method object.
	 * @param classObject Class Object
	 * @param methodName Name of Method
	 * @param parameterTypes Parameter Types
	 * @return Method Object
	 */
	public static Object createMethodObject(Object classObject, String methodName, Class<?>...parameterTypes) {
		
		Method method = null;
		
		try {
			method = classObject.getClass().getMethod(methodName, parameterTypes);				
		} catch(NoSuchMethodException noSuchMethodException) {
			Log.logd(ClassUtils.class.getName(), "createMethodObject", "NoSuchMethodException caught while creating method, METHOD-NAME: " + methodName + ", " + noSuchMethodException.getMessage());
			
			/*
			 * Try For Primitive Data Type
			 */
			parameterTypes = convertToPrimitiveClasses(parameterTypes);
			try {
				method = classObject.getClass().getMethod(methodName, parameterTypes);				
			} catch(Exception exception) {
				Log.loge(ClassUtils.class.getName(), "createMethodObject", "Exception caught while creating method, METHOD-NAME: " + methodName + ", " + exception.getMessage());
				throw new SiminovCriticalException(ClassUtils.class.getName(), "createMethodObject", "Exception caught while creating method, METHOD-NAME: " + methodName + ", " + exception.getMessage());
			}
		} catch(Exception exception) {
			Log.loge(ClassUtils.class.getName(), "createMethodObject", "Exception caught while creating method, METHOD-NAME: " + methodName + ", " + exception.getMessage());
			throw new SiminovCriticalException(ClassUtils.class.getName(), "createMethodObject", "Exception caught while creating method, METHOD-NAME: " + methodName + ", " + exception.getMessage());
		}
		
		method.setAccessible(true);
		return method;
	}
	
	/**
	 * Get column values based on class object and method name provided.
	 * @param classObject Class Object.
	 * @param methodNames Name Of Methods.
	 * @return Column Values.
	 * @throws DatabaseException If any exception occur while getting column values.
	 */
	public static Iterator<Object> getValues(final Object classObject, final Iterator<String> methodNames) throws SiminovException {
		
		Collection<Object> columnValues = new ArrayList<Object>();
		while(methodNames.hasNext()) {
			String methodName = methodNames.next();
			Method method = (Method) createMethodObject(classObject.getClass().getName(), methodName);

			try {
				columnValues.add(method.invoke(classObject, new Object[] {}));	
			} catch(Exception exception) {
				Log.loge(ClassUtils.class.getName(), "getValues", "Exception caught while getting return value from method, METHOD-NAME: " + methodName + ", " + exception.getMessage());
				throw new SiminovException(ClassUtils.class.getName(), "getValues", "Exception caught while getting return value from method, METHOD-NAME: " + methodName + ", " + exception.getMessage());
			}
		}
		
		return columnValues.iterator();
	}

	/**
	 * Get column value based on class object and method name.
	 * @param classObject Class Object.
	 * @param methodName Name Of Method.
	 * @return Column Value.
	 * @throws DatabaseException If any exception occur while getting column value.
	 */
	public static Object getValue(final Object classObject, final String methodName) throws SiminovException {
		
		Method method = (Method) createMethodObject(classObject.getClass().getName(), methodName);
		try {
			return method.invoke(classObject, new Object[] {});	
		} catch(Exception exception) {
			Log.loge(ClassUtils.class.getName(), "getValue", "Exception caught while getting return value from method, METHOD-NAME: " + methodName + ", " + exception.getMessage());
			throw new SiminovException(ClassUtils.class.getName(), "getValue", "Exception caught while getting return value from method, METHOD-NAME: " + methodName + ", " + exception.getMessage());
		}
	}

	
	/**
	 * Invoke method based on class object, method name and parameter provided.
	 * @param classObject Class Object.
	 * @param methodName Name Of Method.
	 * @param parameter Parameters To Method.
	 * @throws DatabaseException If any exception occur while invoking method.
	 */
	public static Object invokeMethod(final Object classObject, final String methodName, final Class<?>[] parameterTypes,final Object[] parameters) throws SiminovException {

		Method method = (Method) createMethodObject(classObject.getClass().getName(), methodName, parameterTypes);
		return invokeMethod(classObject, method, parameters);
	}

	public static Object invokeMethod(final Object classObject, final Method method, final Object...parameters) throws SiminovException {

		try {
			return method.invoke(classObject, parameters);
		} catch(InvocationTargetException invocationTargetException) {
			Log.loge(ClassUtils.class.getName(), "invokeMethod", "InvocationTargetException caught while getting return value from method, METHOD-NAME: " + method.getName() + ", " + invocationTargetException.getMessage());

			Throwable throwable = invocationTargetException.getTargetException();
			throw new SiminovException(throwable.getClass().getName(), "", throwable.getMessage());
		} catch(Exception exception) {
			Log.loge(ClassUtils.class.getName(), "invokeMethod", "Exception caught while getting return value from method, METHOD-NAME: " + method.getName() + ", " + exception.getMessage());
			throw new SiminovException(ClassUtils.class.getName(), "invokeMethod", "Exception caught while getting return value from method, METHOD-NAME: " + method.getName() + ", " + exception.getMessage());
		}
	}
	
	/**
	 * Get new object created and filled with values provided.
	 * @param databaseMappingDescriptor Database Mapping Object.
	 * @param data Column Values.
	 * @return Class Object.
	 * @throws DatabaseException If any exception occur while create and inflating class object.
	 */
	public static Object createAndInflateObject(final String className, final Map<String, Object> data) throws SiminovException {
		
		Object object = createClassInstance(className);

		Set<String> methodNames = data.keySet();
		Iterator<String> methodNamesIterate = methodNames.iterator();
		
		while(methodNamesIterate.hasNext()) {
			String methodName = methodNamesIterate.next();
			Object methodParameter = data.get(methodName);
			
			if(methodParameter == null) {
				continue;
			}
			
			invokeMethod(object, methodName, new Class[] {methodParameter.getClass()}, new Object[] {methodParameter});
		}

		
		return object;
	}
	
	
	private static Class<?>[] convertToPrimitiveClasses(Class<?>...classes) {
		
		Collection<Class<?>> convertedClasses = new HashSet<Class<?>>();
		for(Class<?> classObject : classes) {
			
			if(classObject.getName().equalsIgnoreCase(Integer.class.getName())) {
				convertedClasses.add(int.class);
			} else if(classObject.getName().equalsIgnoreCase(Long.class.getName())) {
				convertedClasses.add(long.class);
			} else if(classObject.getName().equalsIgnoreCase(Float.class.getName())) {
				convertedClasses.add(float.class);
			} else if(classObject.getName().equalsIgnoreCase(Double.class.getName())) {
				convertedClasses.add(double.class);
			} else if(classObject.getName().equalsIgnoreCase(Boolean.class.getName())) {
				convertedClasses.add(boolean.class);
			} else if(classObject.getName().equalsIgnoreCase(Blob.class.getName())) {
				convertedClasses.add(byte.class);
			} else {
				convertedClasses.add(classObject);
			}
		}
		
		
		Class<?>[] convertedArrayClasses = new Class<?>[convertedClasses.size()];
		Iterator<Class<?>> convertedClassesItr = convertedClasses.iterator();
		
		int count = 0;
		while(convertedClassesItr.hasNext()) {
			convertedArrayClasses[count++] = convertedClassesItr.next();
		}
		
		return convertedArrayClasses;
	}
}
