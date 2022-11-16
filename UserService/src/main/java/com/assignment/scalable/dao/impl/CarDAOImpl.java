package com.assignment.scalable.dao.impl;

import org.springframework.stereotype.Repository;

import com.assignment.scalable.collection.Car;
import com.assignment.scalable.dao.CarDAO;
import com.assignment.scalable.db.dao.impl.GenericMongoDaoImpl;

@Repository
public class CarDAOImpl extends GenericMongoDaoImpl<Car> implements CarDAO {
	
}
