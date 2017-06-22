package org.khshrd.app.repository;

import java.util.List;

import org.khshrd.app.model.User;

public interface UserRepos {
	List<User>getAllUser();
	boolean add(User user);
}
