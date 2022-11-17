package com.assignment.scalable.db.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.assignment.scalable.db.annotations.Collection;
import com.assignment.scalable.db.dao.GenericMongoDao;
import com.assignment.scalable.db.exception.MongoConnectorException;
import com.assignment.scalable.db.utils.MongoConstants;
import com.assignment.scalable.db.utils.MongoUtil;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.result.DeleteResult;

@Repository
public abstract class GenericMongoDaoImpl<T> implements GenericMongoDao<T> {
	private Class<T> persistentClass;

	@Autowired
	@Qualifier(MongoConstants.CUSTOMERDATABASE)
	protected MongoDatabase customerDB;

	@Autowired
	@Qualifier(MongoConstants.CARSERVICEDATABASE)
	protected MongoDatabase carServiceDB;

	protected MongoDatabase database;

	private MongoCollection<Document> mongoCollection;

	@SuppressWarnings("unchecked")
	public GenericMongoDaoImpl() {
		if (this.persistentClass == null) {
			ParameterizedType parameterizedType = (ParameterizedType) (this.getClass().getGenericSuperclass());

			while (parameterizedType == null) {
				parameterizedType = (ParameterizedType) (this.getClass().getGenericSuperclass());
			}

			this.persistentClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		}
	}

	@PostConstruct
	public void prepareConnection() throws MongoConnectorException {
		if (this.persistentClass.isAnnotationPresent(com.assignment.scalable.db.annotations.Collection.class)) {
			Collection collection = this.persistentClass.getAnnotation(Collection.class);

			this.database = this.getDatabase(collection.database());
			this.mongoCollection = database.getCollection(collection.name());
		} else {
			throw new MongoConnectorException("This is not a collection");
		}
	}

	private MongoDatabase getDatabase(String databaseName) throws MongoConnectorException {
		MongoDatabase database = null;

		if (MongoConstants.CUSTOMERDATABASE.equals(databaseName)) {
			database = customerDB;
		} else if (MongoConstants.CARSERVICEDATABASE.equals(databaseName)) {
			database = carServiceDB;
		} else {
			throw new MongoConnectorException("Database name not found");
		}

		return database;
	}

	/**
	 * Inserts one document into the database
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public ObjectId insert(T t) {
		Map<String, Object> map = MongoUtil.convertToMap(t);
		Document entityDocument = new Document(map);
		this.mongoCollection.insertOne(entityDocument);
		ObjectId insertId = (ObjectId) entityDocument.get(MongoConstants.ID);

		return insertId;
	}

	/**
	 * Inserts many document into the database
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public List<ObjectId> insert(List<T> objList) {
		List<ObjectId> objIds = new ArrayList<ObjectId>();

		if (!objList.isEmpty()) {
			List<Document> documentList = objList.stream().map(obj -> new Document(MongoUtil.convertToMap(obj)))
					.collect(Collectors.toList());
			this.mongoCollection.insertMany(documentList);

			objIds = documentList.stream().map(obj -> (ObjectId) obj.get(MongoConstants.ID))
					.collect(Collectors.toList());
		}

		return objIds;
	}

	/**
	 * Deletes the record based on the Object ID
	 * 
	 * @param id
	 * @return true if the record is successfully deleted
	 */
	@Override
	public boolean delete(ObjectId id) {
		Document doc = new Document(MongoConstants.ID, id);
		DeleteResult deleteResult = mongoCollection.deleteMany(doc);
		return deleteResult.getDeletedCount() > 0;
	}

	/**
	 * Deletes multiple records which satisfies the filter criteria
	 * 
	 * @param filter
	 * @return count of records deleted
	 */
	@Override
	public Long delete(Map<String, Object> filter) {
		DeleteResult deleteResult = mongoCollection.deleteMany(new Document(filter));
		return deleteResult.getDeletedCount();
	}

	/**
	 * Retrieves the record based on the Object ID
	 * 
	 * @param id
	 * @return if found, returns entity else null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T find(ObjectId id) {
		T entity = null;
		Document doc = new Document(MongoConstants.ID, id);
		FindIterable<Document> result = mongoCollection.find(doc);
		entity = (T) MongoUtil.convertToEntity(persistentClass, new HashMap<>(result.first()));

		return entity;
	}

	/**
	 * Retrieves all records which satisfies the filter criteria
	 * 
	 * @param filter
	 * @return List of entities
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> find(Map<String, Object> filter) {
		List<T> entityList = new ArrayList<>();
		FindIterable<Document> resultList = mongoCollection.find(new Document(filter));

		entityList = (List<T>) StreamSupport.stream(resultList.spliterator(), true)
				.map(element -> MongoUtil.convertToEntity(persistentClass, new HashMap<>(element)))
				.collect(Collectors.toList());

		return entityList;
	}

	/**
	 * Retrieves the first field based on the filter criteria sorted in the
	 * ascending order of Object ID
	 * 
	 * @param filter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T findOne(Map<String, Object> filter) {
		T entity = null;
		Bson sortField = Sorts.ascending("typeId", MongoConstants.ID);
		Document result = mongoCollection.find(new Document(filter)).sort(sortField).first();

		if (result != null) {
			entity = (T) MongoUtil.convertToEntity(persistentClass, new HashMap<>(result));
		}

		return entity;
	}

	/**
	 * Returns true, if the documents exists which satisfies the filter criteria
	 * 
	 * @param filter
	 * @return
	 */
	@Override
	public boolean exist(Map<String, Object> filter) {
		return mongoCollection.countDocuments(new Document(filter)) > 0;
	}

	/**
	 * Returns true, if the documents exists which satisfies the filter criteria
	 * 
	 * @param filter
	 * @return
	 */
	@Override
	public boolean exist(ObjectId id) {
		Document doc = new Document(MongoConstants.ID, id);
		return mongoCollection.countDocuments(doc) > 0;
	}

	/**
	 * Inserts one document into the database
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public void update(Map<String, Object> filter, T t) {
		Map<String, Object> map = MongoUtil.convertToMap(t);
		Document entityDocument = new Document(map);
		this.mongoCollection.updateOne(new Document(filter), entityDocument);
		ObjectId insertId = (ObjectId) entityDocument.get(MongoConstants.ID);
	}
}
