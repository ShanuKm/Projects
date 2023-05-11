package org.jsp.userbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.userbootapp.dto.User;
import org.jsp.userbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;
	
	public User saveUser(User u)
	{
		return repository.save(u);
	}
	
	public void deleteUser(User user) {
		repository.delete(user);
	}
	public User updateUser(User u)
	{
		return repository.save(u);
	}
	
	public Optional<User> findUserById(int id){
		return repository.findById(id);
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}

}
