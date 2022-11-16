package com.assignment.scalable.db.dao;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

public interface GenericMongoDao<T> {

	/**
	 * Inserts one document into the database
	 * 
	 * @param t
	 * @return
	 */
	public ObjectId insert(T t);

	/**
	 * Inserts many document into the database
	 * 
	 * @param t
	 * @return
	 */
	public List<ObjectId> insert(List<T> objList);

	/**
	 * Returns true, if the documents exists which satisfies the filter criteria
	 * 
	 * @param filter
	 * @return
	 */
	public boolean exist(ObjectId id);

	/**
	 * Returns true, if the documents exists which satisfies the filter criteria
	 * 
	 * @param filter
	 * @return
	 */
	public boolean exist(Map<String, Object> filter);

	/**
	 * Retrieves the first field based on the filter criteria sorted in the
	 * ascending order of Object ID
	 * 
	 * @param filter
	 * @return
	 */
	public T findOne(Map<String, Object> filter);

	/**
	 * Retrieves all records which satisfies the filter criteria
	 * 
	 * @param filter
	 * @return List of entities
	 */
	public List<T> find(Map<String, Object> filter);

	/**
	 * Retrieves the record based on the Object ID
	 * 
	 * @param id
	 * @return if found, returns entity else null
	 */
	public T find(ObjectId id);

	/**
	 * Deletes multiple records which satisfies the filter criteria
	 * 
	 * @param filter
	 * @return count of records deleted
	 */
	public Long delete(Map<String, Object> filter);

	/**
	 * Deletes the record based on the Object ID
	 * 
	 * @param id
	 * @return true if the record is successfully deleted
	 */
	public boolean delete(ObjectId id);
}
