package org.danekja.edu.pia.utils;

import org.danekja.edu.pia.domain.BaseObject;

/**
 * @author Karel Zíbar
 */
public interface DatabasePersistUtil {

	/**
	 * Method do all stuffs needed for upcoming database inserts
	 */
	void beginTransaction();

	/**
	 * Method will persist data to database
	 * @param object - persisting record
	 */
	void persistData(BaseObject object);


	/**
	 * Method will commit all changes to database
	 */
	void commitChanges();


	/**
	 * Method will end all stuffs which were needed for transaction and the database connection will be end too
	 */
	void endConnection();


	/**
	 * Return object from database according to parameter id
	 * @param clazz - "table" of wanted object
	 * @param id - identifier of wanted object
	 * @return - instance of BaseObject
	 */
	BaseObject selectObjectById(Class clazz, Long id);

}
