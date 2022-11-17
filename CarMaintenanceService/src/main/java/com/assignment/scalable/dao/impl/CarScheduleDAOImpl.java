package com.assignment.scalable.dao.impl;

import org.springframework.stereotype.Repository;

import com.assignment.scalable.collection.CarServiceSchedule;
import com.assignment.scalable.dao.CarScheduleDAO;
import com.assignment.scalable.db.dao.impl.GenericMongoDaoImpl;

@Repository
public class CarScheduleDAOImpl extends GenericMongoDaoImpl<CarServiceSchedule> implements CarScheduleDAO {

}
