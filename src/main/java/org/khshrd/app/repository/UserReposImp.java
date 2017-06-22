package org.khshrd.app.repository;

import java.util.ArrayList;
import java.util.List;

import org.khshrd.app.model.User;
import org.springframework.stereotype.Repository;
@Repository
public class UserReposImp implements UserRepos{
    private List<User>users;
    public UserReposImp(){
    	users=new ArrayList<User>();
    	User u1=new User();
    	u1.setId(1);u1.setUsername("Sothy");u1.setGender("Male");u1.setEmail("sothy@gmail.com");
    	u1.setPhone("01999999");u1.setAddres("TK");
    	users.add(u1);
    }
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		if (user!=null) {
			users.add(user);
			return true;
		}
		return false;
	}

}
