package org.khshrd.app.service;

import java.util.List;

import org.khshrd.app.model.User;

public interface UserService {
	List<User>getAllUser();
	boolean add(User user);
}
