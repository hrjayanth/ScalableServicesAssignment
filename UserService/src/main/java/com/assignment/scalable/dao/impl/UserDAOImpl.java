package com.assignment.scalable.dao.impl;

import org.springframework.stereotype.Repository;

import com.assignment.scalable.collection.User;
import com.assignment.scalable.dao.UserDAO;
import com.assignment.scalable.db.dao.impl.GenericMongoDaoImpl;

@Repository
public class UserDAOImpl extends GenericMongoDaoImpl<User> implements UserDAO {
	
}
