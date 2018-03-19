package owish.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import owish.core.dao.user.UserDao;
import owish.core.service.user.UserService;
import owish.model.user.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public String retrieveAll() {
		return "UserService";
	}

	@Override
	public User retrieveByUsername(String username) {
		return userDao.findByUsername(username);
	}
}
