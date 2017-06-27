package org.khshrd.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.khshrd.app.model.User;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepos {
	@Select("SELECT uid,username,pass,gender,email,phone,address,hashcode from tbUser where status ='t'")
	public List<User>getAllUser();
	@Insert("INSERT INTO tbuser ("
			+ "	username, "
			+ "	pass, "
			+ "	gender, "
			+ "	email, "
			+ "	phone,"
			+ " address,"
			+ " hashcode,"
			+ " status"
			+ "	) VALUES ("
			+ "	#{user.username},"
			+ "	#{user.pass},"
			+ "	#{user.gender},"
			+ "	#{user.email},"
			+ "	#{user.phone}, "
			+ " #{user.address},"
			+ " #{user.hashcode},"
			+ "'t'"
			+ ")")
	     public boolean save(@Param("user") User user);
	@Update("UPDATE tbuser SET username=#{user.username}, pass=#{user.pass}, gender=#{user.gender},email=#{user.email}, phone=#{user.phone}, address=#{user.address} WHERE hashcode=#{user.hashcode}")
	public boolean update(@Param("user") User user);
	
	@Select("SELECT uid, username,pass, gender, email,phone,address, hashcode FROM tbuser WHERE hashcode=#{hashcode}")
	User findOne(@Param("hashcode") String hashcode);
	
	@Delete("UPDATE tbuser SET status='0' WHERE hashcode=#{hashcode}")
	public boolean delete(@Param("hashcode") String hashcode);
}
