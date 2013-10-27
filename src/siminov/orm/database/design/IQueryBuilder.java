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

package siminov.orm.database.design;

import java.util.Map;

import siminov.orm.Constants;

/**
 * Exposes API's to build database queries.
 */
public interface IQueryBuilder {

/*
 * Form Table Info Query	
 */
	public String FORM_TABLE_INFO_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_TABLE_INFO_QUERY_TABLE_NAME_PARAMETER;
	
	/**
	 * Build query to get table info.
	 * @param parameters Required to build query.
	 * @return Table Info Query.
	 */
	public String formTableInfoQuery(final Map<String, Object> parameters);


	
/*
 * 	Form Fetch Database Version Query
 */
	
	/**
	 * Build query to get database version.
	 * @param parameters Required to build query.
	 * @return Fetch Database Version Query.
	 */
	public String formFetchDatabaseVersionQuery(final Map<String, Object> parameters);
	
	

/*
 * Form Update Database Version Query.	
 */
	public String FORM_UPDATE_DATABASE_VERSION_QUERY_DATABASE_VERSION_PARAMETER = Constants.FORM_UPDATE_DATABASE_VERSION_QUERY_DATABASE_VERSION_PARAMETER;
	
	/**
	 * Build query to update database version.
	 * @param parameters Required to build query.
	 * @return Update Database Version Query.
	 */
	public String formUpdateDatabaseVersionQuery(final Map<String, Object> parameters);
	

	
/*
 * Form Alter Add Column Query	
 */
	public String FORM_ALTER_ADD_COLUMN_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_ALTER_ADD_COLUMN_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_ALTER_ADD_COLUMN_QUERY_COLUMN_NAME_PARAMETER = Constants.FORM_ALTER_ADD_COLUMN_QUERY_COLUMN_NAME_PARAMETER;

	/**
	 * Build query to alter add new column to table.
	 * @param parameters Required to build query. 
	 * @return Alter Add New Column Query.
	 */
	public String formAlterAddColumnQuery(final Map<String, Object> parameters);

	

/*
 * Form Table Names	
 */
	
	/**
	 * Build query to get all table names exists in database.
	 * @param parameters Required to build query.
	 * @return Table Names Query.
	 */
	public String formTableNames(final Map<String, Object> parameters);
	
	

/*
 * Form Create Table Query	
 */
	public String FORM_CREATE_TABLE_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_CREATE_TABLE_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_CREATE_TABLE_QUERY_COLUMN_NAMES_PARAMETER = Constants.FORM_CREATE_TABLE_QUERY_COLUMN_NAMES_PARAMETER;
	public String FORM_CREATE_TABLE_QUERY_COLUMN_TYPES_PARAMETER = Constants.FORM_CREATE_TABLE_QUERY_COLUMN_TYPES_PARAMETER;
	public String FORM_CREATE_TABLE_QUERY_DEFAULT_VALUES_PARAMETER = Constants.FORM_CREATE_TABLE_QUERY_DEFAULT_VALUES_PARAMETER;
	public String FORM_CREATE_TABLE_QUERY_CHECKS_PARAMETER = Constants.FORM_CREATE_TABLE_QUERY_CHECKS_PARAMETER;
	public String FORM_CREATE_TABLE_QUERY_PRIMARY_KEYS_PARAMETER = Constants.FORM_CREATE_TABLE_QUERY_PRIMARY_KEYS_PARAMETER;
	public String FORM_CREATE_TABLE_QUERY_NOT_NULLS_PARAMETER = Constants.FORM_CREATE_TABLE_QUERY_NOT_NULLS_PARAMETER;
	public String FORM_CREATE_TABLE_QUERY_UNIQUE_COLUMNS_PARAMETER = Constants.FORM_CREATE_TABLE_QUERY_UNIQUE_COLUMNS_PARAMETER;
	public String FORM_CREATE_TABLE_QUERY_FOREIGN_KEYS_PARAMETER = Constants.FORM_CREATE_TABLE_QUERY_FOREIGN_KEYS_PARAMETER;
	
	/**
	 * Build query to create table.
	 * @param parameters Required to build query.
	 * @return Create Table Query.
	 */
	public String formCreateTableQuery(final Map<String, Object> parameters);


	
/*
 * Form Create Index Query
 */
	public String FORM_CREATE_INDEX_QUERY_INDEX_NAME_PARAMETER = Constants.FORM_CREATE_INDEX_QUERY_INDEX_NAME_PARAMETER;
	public String FORM_CREATE_INDEX_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_CREATE_INDEX_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_CREATE_INDEX_QUERY_COLUMN_NAMES_PARAMETER = Constants.FORM_CREATE_INDEX_QUERY_COLUMN_NAMES_PARAMETER;
	public String FORM_CREATE_INDEX_QUERY_IS_UNIQUE_PARAMETER = Constants.FORM_CREATE_INDEX_QUERY_IS_UNIQUE_PARAMETER;
	
	/**
	 * Build query to create index.
	 * @param parameters Required to build query.
	 * @return Create Index Query.
	 */
	public String formCreateIndexQuery(final Map<String, Object> parameters);
	

	
/*
 * Form Drop Table Query
 */
	public String FORM_DROP_TABLE_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_DROP_TABLE_QUERY_TABLE_NAME_PARAMETER;
	
	/**
	 * Build query to drop table.
	 * @param parameters Required to build query.
	 * @return Drop Table Query.
	 */
	public String formDropTableQuery(final Map<String, Object> parameters);
	

/*
 * Form Drop Index Query
 */
	public String FORM_DROP_INDEX_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_DROP_INDEX_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_DROP_INDEX_QUERY_INDEX_NAME_PARAMETER = Constants.FORM_DROP_INDEX_QUERY_INDEX_NAME_PARAMETER;
	
	/**
	 * Build query to drop index from table.
	 * @param parameters Required to build query.
	 * @return Drop Index Query.
	 */
	public String formDropIndexQuery(final Map<String, Object> parameters);
	


/*
 * Form Select Query	
 */
	public String FORM_SELECT_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_SELECT_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_SELECT_QUERY_DISTINCT_PARAMETER = Constants.FORM_SELECT_QUERY_DISTINCT_PARAMETER;
	public String FORM_SELECT_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_SELECT_QUERY_WHERE_CLAUSE_PARAMETER;
	public String FORM_SELECT_QUERY_COLUMN_NAMES_PARAMETER = Constants.FORM_SELECT_QUERY_COLUMN_NAMES_PARAMETER;
	public String FORM_SELECT_QUERY_GROUP_BYS_PARAMETER = Constants.FORM_SELECT_QUERY_GROUP_BYS_PARAMETER;
	public String FORM_SELECT_QUERY_HAVING_PARAMETER = Constants.FORM_SELECT_QUERY_HAVING_PARAMETER;
	public String FORM_SELECT_QUERY_ORDER_BYS_PARAMETER = Constants.FORM_SELECT_QUERY_ORDER_BYS_PARAMETER;
	public String FORM_SELECT_QUERY_WHICH_ORDER_BY_PARAMETER = Constants.FORM_SELECT_QUERY_WHICH_ORDER_BY_PARAMETER;
	public String FORM_SELECT_QUERY_LIMIT_PARAMETER = Constants.FORM_SELECT_QUERY_LIMIT_PARAMETER;
	
	/**
	 * Build query to fetch tuples from table.
	 * @param parameters Required to build query.
	 * @return Select Query.
	 */
	public String formSelectQuery(final Map<String, Object> parameters);



/*
 * Form Save Bind Query	
 */
	public String FORM_SAVE_BIND_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_SAVE_BIND_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_SAVE_BIND_QUERY_COLUMN_NAMES_PARAMETER = Constants.FORM_SAVE_BIND_QUERY_COLUMN_NAMES_PARAMETER;
	
	/**
	 * Build query to insert data into table.
	 * @param parameters Required to build query.
	 * @return Save Query.
	 */
	public String formSaveBindQuery(final Map<String, Object> parameters);
	


/*
 * Form Update Bind Query	
 */
	public String FORM_UPDATE_BIND_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_UPDATE_BIND_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_UPDATE_BIND_QUERY_COLUMN_NAMES_PARAMETER = Constants.FORM_UPDATE_BIND_QUERY_COLUMN_NAMES_PARAMETER;
	public String FORM_UPDATE_BIND_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_UPDATE_BIND_QUERY_WHERE_CLAUSE_PARAMETER;
	
	/**
	 * Build query to update tuples.
	 * @param parameters Required to build query.
	 * @return Update Query.
	 */
	public String formUpdateBindQuery(final Map<String, Object> parameters);
	


/*
 * Form Delete Query	
 */
	public String FORM_DELETE_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_DELETE_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_DELETE_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_DELETE_QUERY_WHERE_CLAUSE_PARAMETER;
	
	/**
	 * Build query to delete tuples.
	 * @param parameters Required to build query.
	 * @return Delete Query.
	 */
	public String formDeleteQuery(final Map<String, Object> parameters);
	


/*
 * Form Count Query	
 */
	public String FORM_COUNT_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_COUNT_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_COUNT_QUERY_COLUMN_PARAMETER = Constants.FORM_COUNT_QUERY_COLUMN_PARAMETER;
	public String FORM_COUNT_QUERY_DISTINCT_PARAMETER = Constants.FORM_COUNT_QUERY_DISTINCT_PARAMETER;
	public String FORM_COUNT_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_COUNT_QUERY_WHERE_CLAUSE_PARAMETER;
	public String FORM_COUNT_QUERY_GROUP_BYS_PARAMETER = Constants.FORM_COUNT_QUERY_GROUP_BYS_PARAMETER;
	public String FORM_COUNT_QUERY_HAVING_PARAMETER = Constants.FORM_COUNT_QUERY_HAVING_PARAMETER;
	
	/**
	 * Build query to get count of tuples.
	 * @param parameters Required to build query.
	 * @return Count Query.
	 */
	public String formCountQuery(final Map<String, Object> parameters);
	
	
/*
 * Form Average Query.
 */
	public String FORM_AVG_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_AVG_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_AVG_QUERY_COLUMN_PARAMETER = Constants.FORM_AVG_QUERY_COLUMN_PARAMETER;
	public String FORM_AVG_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_AVG_QUERY_WHERE_CLAUSE_PARAMETER;
	public String FORM_AVG_QUERY_GROUP_BYS_PARAMETER = Constants.FORM_AVG_QUERY_GROUP_BYS_PARAMETER;
	public String FORM_AVG_QUERY_HAVING_PARAMETER = Constants.FORM_AVG_QUERY_HAVING_PARAMETER;
	
	/**
	 * Build query to get Average.
	 * @param parameters Required to build query.
	 * @return Average Query.
	 */
	public String formAvgQuery(final Map<String, Object> parameters);
	


/*
 * Form Sum Query.
 */
	public String FORM_SUM_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_SUM_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_SUM_QUERY_COLUMN_PARAMETER = Constants.FORM_SUM_QUERY_COLUMN_PARAMETER;
	public String FORM_SUM_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_SUM_QUERY_WHERE_CLAUSE_PARAMETER;
	public String FORM_SUM_QUERY_GROUP_BYS_PARAMETER = Constants.FORM_SUM_QUERY_GROUP_BYS_PARAMETER;
	public String FORM_SUM_QUERY_HAVING_PARAMETER = Constants.FORM_SUM_QUERY_HAVING_PARAMETER;
	
	/**
	 * Build query to get Sum.
	 * @param parameters Required to build query.
	 * @return Sum Query
	 */
	public String formSumQuery(final Map<String, Object> parameters);
	
	

/*
 * Form Total Query	
 */
	public String FORM_TOTAL_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_TOTAL_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_TOTAL_QUERY_COLUMN_PARAMETER = Constants.FORM_TOTAL_QUERY_COLUMN_PARAMETER;
	public String FORM_TOTAL_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_TOTAL_QUERY_WHERE_CLAUSE_PARAMETER;
	public String FORM_TOTAL_QUERY_GROUP_BYS_PARAMETER = Constants.FORM_TOTAL_QUERY_GROUP_BYS_PARAMETER;
	public String FORM_TOTAL_QUERY_HAVING_PARAMETER = Constants.FORM_TOTAL_QUERY_HAVING_PARAMETER;
	
	/**
	 * Build query to get total.
	 * @param parameters Required to build query.
	 * @return Total Query.
	 */
	public String formTotalQuery(final Map<String, Object> parameters);



/*
 * Form Max Query.	
 */
	public String FORM_MAX_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_MAX_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_MAX_QUERY_COLUMN_PARAMETER = Constants.FORM_MAX_QUERY_COLUMN_PARAMETER;
	public String FORM_MAX_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_MAX_QUERY_WHERE_CLAUSE_PARAMETER;
	public String FORM_MAX_QUERY_GROUP_BYS_PARAMETER = Constants.FORM_MAX_QUERY_GROUP_BYS_PARAMETER;
	public String FORM_MAX_QUERY_HAVING_PARAMETER = Constants.FORM_MAX_QUERY_HAVING_PARAMETER;
	
	/**
	 * Build query to get Max.
	 * @param parameters Required to build query.
	 * @return Max Query.
	 */
	public String formMaxQuery(final Map<String, Object> parameters);
	


/*
 * Form Minimum Query	
 */
	public String FORM_MIN_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_MIN_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_MIN_QUERY_COLUMN_PARAMETER = Constants.FORM_MIN_QUERY_COLUMN_PARAMETER;
	public String FORM_MIN_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_MIN_QUERY_WHERE_CLAUSE_PARAMETER;
	public String FORM_MIN_QUERY_GROUP_BYS_PARAMETER = Constants.FORM_MIN_QUERY_GROUP_BYS_PARAMETER;
	public String FORM_MIN_QUERY_HAVING_PARAMETER = Constants.FORM_MIN_QUERY_HAVING_PARAMETER;
	
	/**
	 * Build query to get Minimum Query.
	 * @param parameters Required to build query.
	 * @return Minimum Query.
	 */
	public String formMinQuery(final Map<String, Object> parameters);
	


/*
 * Form Group Concat Query	
 */
	public String FORM_GROUP_CONCAT_QUERY_TABLE_NAME_PARAMETER = Constants.FORM_GROUP_CONCAT_QUERY_TABLE_NAME_PARAMETER;
	public String FORM_GROUP_CONCAT_QUERY_COLUMN_PARAMETER = Constants.FORM_GROUP_CONCAT_QUERY_COLUMN_PARAMETER;
	public String FORM_GROUP_CONCAT_QUERY_WHERE_CLAUSE_PARAMETER = Constants.FORM_GROUP_CONCAT_QUERY_WHERE_CLAUSE_PARAMETER;
	public String FORM_GROUP_CONCAT_QUERY_GROUP_BYS_PARAMETER = Constants.FORM_GROUP_CONCAT_QUERY_GROUP_BYS_PARAMETER;
	public String FORM_GROUP_CONCAT_QUERY_HAVING_PARAMETER = Constants.FORM_GROUP_CONCAT_QUERY_HAVING_PARAMETER;
	public String FORM_GROUP_CONCAT_QUERY_DELIMITER_PARAMETER = Constants.FORM_GROUP_CONCAT_QUERY_DELIMITER_PARAMETER;
	
	/**
	 * Build query to get group concat.
	 * @param parameters Required to build query.
	 * @return Group Concat Query.
	 */
	public String formGroupConcatQuery(final Map<String, Object> parameters);
	

/*
 * Form Foreign Keys Query	
 */
	public String FORM_FOREIGN_KEYS_DATABASE_DESCRIPTOR_PARAMETER = Constants.FORM_FOREIGN_KEYS_DATABASE_DESCRIPTOR_PARAMETER;
	
	/**
	 * Build query to get foreign keys.
	 * @param parameters Required to build query.
	 * @return Foreign Keys.
	 */
	public String formForeignKeyQuery(final Map<String, Object> parameters);
	
}
