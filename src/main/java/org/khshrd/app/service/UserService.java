package org.khshrd.app.service;

import java.util.List;

import org.khshrd.app.model.User;

public interface UserService {
	public List<User>getAllUser();
	public boolean save(User user);
	public boolean delete(String hashcode);
	public boolean update(User user);
	public User findOne(String hashcode);
}
