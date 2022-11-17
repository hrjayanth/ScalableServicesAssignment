package com.assignment.scalable.dao.impl;

import org.springframework.stereotype.Repository;

import com.assignment.scalable.collection.CarServiceHistory;
import com.assignment.scalable.dao.CarServiceHistoryDAO;
import com.assignment.scalable.db.dao.impl.GenericMongoDaoImpl;

@Repository
public class CarServiceHistoryDAOImpl extends GenericMongoDaoImpl<CarServiceHistory> implements CarServiceHistoryDAO {

}
