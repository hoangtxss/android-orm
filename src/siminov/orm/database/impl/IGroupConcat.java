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

package siminov.orm.database.impl;

import siminov.orm.exception.DatabaseException;

/**
 * Exposes API's to get group concat that returns a string which is the concatenation of all non-NULL values of X.
 * If parameter Y is present then it is used as the separator between instances of X. A comma (",") is used as the separator if Y is omitted.
 * The order of the concatenated elements is arbitrary.
 */
public interface IGroupConcat {

	public String INTERFACE_NAME = IGroupConcat.class.getName();

	
	/**
	 * Used to specify separator if Y is omitted.
	 * @param delimiter Delimiter.
	 * @return IGroupConcat Interface.
	 */
	public IGroupConcat delimiter(String delimiter);
	
	/**
	 * Column name of which condition will be specified.
	 * @param column Name of column.
	 * @return IGroupConcatClause Interface.
	 */
	public IGroupConcatClause where(String column);
	
	/**
	 * Used to provide manually created Where clause, instead of using API's.
	 * @param whereClause Manually created where clause.
	 * @return IGroupConcat Interface.
	 */
	public IGroupConcat whereClause(String whereClause);
	
	/**
	 * Used to specify AND condition between where clause.
	 * @param column Name of column on which condition need to be specified.
	 * @return IGroupConcatClause Interface.
	 */
	public IGroupConcatClause and(String column);
	
	/**
	 * Used to specify OR condition between where clause.
	 * @param column Name of column on which condition need to be specified.
	 * @return IGroupConcatClause Interface.
	 */
	public IGroupConcatClause or(String column);

	/**
	 * Used to specify GROUP BY statement in conjunction with the aggregate functions to group the result-set by one or more columns.
	 * @param columns Name of columns.
	 * @return IGroupConcat Interface.
	 */
	public IGroupConcat groupBy(String...columns);
	
	/**
	 * Used to specify HAVING clause to SQL because the WHERE keyword could not be used with aggregate functions.
	 * @param column Name of column on which condition need to be applied.
	 * @return IGroupConcatClause Interface.
	 */
	public IGroupConcatClause having(String column);

	/**
	 * Used to provide manually created Where clause, instead of using API's.
	 * @param havingClause Where clause.
	 * @return IGroupConcat Interface.
	 */
	public IGroupConcat havingClause(String havingClause);
	
	/**
	 * Used to provide name of column for which average will be calculated.
	 * @param column Name of column.
	 * @return IGroupConcat Interface.
	 */
	public IGroupConcat column(String column);
	
	/**
	 * Used to get average, this method should be called in last to calculate group concat.
	 * @return Return group concat.
	 * @throws DatabaseException Throws exception if any error occur while calculating group concat. 
	 */
	public Object execute() throws DatabaseException;

}
