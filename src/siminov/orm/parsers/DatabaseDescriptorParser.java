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

package siminov.orm.parsers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import siminov.orm.Constants;
import siminov.orm.exception.DeploymentException;
import siminov.orm.log.Log;
import siminov.orm.model.DatabaseDescriptor;
import siminov.orm.resource.Resources;
import android.content.Context;


/**
 * Exposes methods to parse Database Descriptor information as per define in DatabaseDescriptor.si.xml file by application.
	<p>
		<pre>
		
Example:
	{@code

	<database-descriptor>
	
		<property name="database_name">SIMINOV-TEMPLATE</property>
		<property name="description">Siminov Template Database Config</property>
		<property name="is_locking_required">true</property>
		<property name="external_storage">false</property>
		<property name="database_implementer"></property>
		<property name="password"></property>
		
		<!-- Database Mappings -->
			<database-mappings>
				<database-mapping path="Liquor-Mappings/Liquor.core.xml" />
				<database-mapping path="Liquor-Mappings/LiquorBrand.core.xml" />
			</database-mappings>
	
			 	<!-- OR -->

			<database-mappings>
				<database-mapping path="com.core.template.model.Liquor" />
				<database-mapping path="com.core.template.model.LiquorBrand" />
			</database-mappings>
		

		<!-- Libraries -->
		<libraries>
			<library>com.core.library.template.resources</library>
		</libraries>
				
	</database-descriptor>

	}
	
		</pre>
	</p>
*/
public class DatabaseDescriptorParser extends SiminovSAXDefaultHandler implements Constants {

	private String databaseDescriptorPath = null;
	
	private DatabaseDescriptor databaseDescriptor = null;
	
	private Resources resources = Resources.getInstance();

	private StringBuilder tempValue = new StringBuilder();
	private String propertyName = null;

	public DatabaseDescriptorParser(final String databaseDescriptorPath) {
		
		if(databaseDescriptorPath == null || databaseDescriptorPath.length() <= 0) {
			Log.loge(getClass().getName(), "Constructor", "Invalid Database Descriptor path found.");
			throw new DeploymentException(getClass().getName(), "Constructor", "Invalid Database Descriptor path found.");
		}
		
		this.databaseDescriptorPath = databaseDescriptorPath;
		
		Context context = resources.getApplicationContext();
		if(context == null) {
			Log.loge(getClass().getName(), "Constructor", "Invalid Application Context found.");
			throw new DeploymentException(getClass().getName(), "Constructor", "Invalid Application Context found.");
		}

		/*
		 * Parse ApplicationDescriptor.
		 */
		InputStream databaseDescriptorStream = null;
		
		try {
			databaseDescriptorStream = context.getAssets().open(this.databaseDescriptorPath);
		} catch(IOException ioException) {
			Log.loge(getClass().getName(), "Constructor", "IOException caught while getting input stream of database descriptor, DATABASE-DESCRIPTOR-PATH: " + databaseDescriptorPath + ", " + ioException.getMessage());
			throw new DeploymentException(getClass().getName(), "Constructor", "IOException caught while getting input stream of database descriptor, DATABASE-DESCRIPTOR-PATH: " + databaseDescriptorPath + ", " + ioException.getMessage());
		}
		
		try {
			parseMessage(databaseDescriptorStream);
		} catch(Exception exception) {
			Log.loge(getClass().getName(), "Constructor", "Exception caught while parsing DATABASE-DESCRIPTOR: " + databaseDescriptorPath + ", " + exception.getMessage());
			throw new DeploymentException(getClass().getName(), "Constructor", "Exception caught while parsing DATABASE-DESCRIPTOR: " + databaseDescriptorPath + ", " + exception.getMessage());
		}
		
		doValidation();
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		tempValue = new StringBuilder();
		
		if(localName.equalsIgnoreCase(DATABASE_DESCRIPTOR)) {
			databaseDescriptor = new DatabaseDescriptor();
		} else if(localName.equalsIgnoreCase(DATABASE_DESCRIPTOR_PROPERTY)) {
			initializeProperty(attributes);
		} else if(localName.equalsIgnoreCase(DATABASE_DESCRIPTOR_DATABASE_MAPPING)) {
			databaseDescriptor.addDatabaseMappingPath(attributes.getValue(DATABASE_DESCRIPTOR_PATH));
		} 
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		String value = new String(ch,start,length);
		
		if(value == null || value.length() <= 0 || value.equalsIgnoreCase(NEW_LINE)) {
			return;
		}
		
		value = value.trim();
		tempValue.append(value);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName.equalsIgnoreCase(DATABASE_DESCRIPTOR_PROPERTY)) {
			databaseDescriptor.addProperty(propertyName, tempValue.toString());
		} else if(localName.equalsIgnoreCase(DATABASE_DESCRIPTOR_LIBRARY)) {
			databaseDescriptor.addLibraryPath(tempValue.toString());
		} 
	}
	
	private void initializeProperty(final Attributes attributes) {
		propertyName = attributes.getValue(DATABASE_DESCRIPTOR_PROPERTY_NAME);
	}
	
	private void doValidation() throws DeploymentException {
		
		/*
		 * Validate Database Name field.
		 */
		Iterator<String> databaseMappingPaths = databaseDescriptor.getDatabaseMappingPaths();
		while(databaseMappingPaths.hasNext()) {
			String databaseMappingPath = databaseMappingPaths.next();
			
			if(databaseMappingPath.endsWith(XML_FILE_EXTENSION)) {
				if(!databaseMappingPath.contains(SIMINOV_DESCRIPTOR_EXTENSION)) {
					Log.loge(getClass().getName(), "doValidation", "INVALID DATABASE MAPPING PATH FOUND, it should contain .core extension in path, PATH-DEFINED: " + databaseMappingPath);
					throw new DeploymentException(getClass().getName(), "doValidation", "INVALID DATABASE MAPPING PATH FOUND, it should contain .core extension in path, PATH-DEFINED: " + databaseMappingPath);
				}
			}
		}

	}

	/**
	 * Get database descriptor object.
	 * @return Database Descriptor Object.
	 */
	public DatabaseDescriptor getDatabaseDescriptor() {
		if(databaseDescriptor.getType() == null || databaseDescriptor.getType().length() <= 0) {
			databaseDescriptor.setType(SQLITE_DATABASE);
		}
		
		return this.databaseDescriptor;
	}

}
