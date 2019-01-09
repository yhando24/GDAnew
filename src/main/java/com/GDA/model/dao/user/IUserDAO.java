package main.java.com.GDA.model.dao.user;

import java.sql.SQLException;

import main.java.com.GDA.bean.User;

public interface IUserDAO {
	
	User findUserByEmailAndByPassword(String email,String password) throws SQLException;
	User findUserByEmail(String email) throws SQLException;
	User findUserById(int id) throws SQLException;
	boolean isUserExist(String email,String password) throws SQLException;
	
}
