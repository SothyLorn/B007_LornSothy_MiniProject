package org.khshrd.app.service;

import java.util.List;

import org.khshrd.app.model.User;
import org.khshrd.app.repository.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImp implements UserService{
	private UserRepos userrepos;
	@Autowired
	public void setUserRepos(UserRepos userrepos){
		this.userrepos=userrepos;
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userrepos.getAllUser();
	}

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return userrepos.add(user);
	}

}
