package org.khshrd.app.service.imp;

import java.util.List;
import java.util.UUID;

import org.khshrd.app.model.User;
import org.khshrd.app.repository.UserRepos;
import org.khshrd.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImp implements UserService{
	private UserRepos userrepos;
	@Autowired
	public UserServiceImp(UserRepos userrepos){
		this.userrepos=userrepos;
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userrepos.getAllUser();
	}
	@Override
	public boolean save(User user) {
		String user_hash=UUID.randomUUID().toString();
		user.setUser_has(user_hash);
		boolean status=userrepos.save(user);
		if(status){
			System.out.println("User has been inserted");
		}
		else{
			System.out.println("User has not been inserted");
		}
		return status;
	}
	@Override
	public boolean update(User user) {
		return userrepos.update(user);	 
	}
	@Override
	public boolean delete(String hashcode) {
		return userrepos.delete(hashcode);
	}
	@Override
	public User findOne(String hashcode) {
		// TODO Auto-generated method stub
		return userrepos.findOne(hashcode);
	}
	


	

}
