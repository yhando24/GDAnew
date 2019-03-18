package com.GDA.model.dao.user;

import java.util.List;

import com.GDA.bean.QuestionUser;
import com.GDA.bean.User;

public interface IUserDAO {

	User findUserByEmailAndByPassword(String email, String password);

	User findUserByEmail(String email);

	User findUserById(int id);

	boolean isUserExist(String email, String password);

	List<User> findUserByIdDepartement(int id);

	QuestionUser findQuestionUserByMail(String email);

	QuestionUser findQuestionUserByIdUser(int id);

	void ChangePasswordToUser(int id, String password);

}
