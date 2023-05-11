package org.jsp.userbootapp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.userbootapp.dao.UserDao;
import org.jsp.userbootapp.dto.ResponseStructure;
import org.jsp.userbootapp.dto.User;
import org.jsp.userbootapp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User u) {
		ResponseStructure<User> structure = new ResponseStructure();
		structure.setMessage("user data saved successfully");
		structure.setBody(dao.saveUser(u));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<String>> delete(int id) {
		Optional<User> u = dao.findUserById(id);
		ResponseStructure<String> structure = new ResponseStructure();
		if (u.isPresent()) {
			structure.setBody("User Deleted");
			structure.setMessage("User Found");
			structure.setCode(HttpStatus.OK.value());
			dao.deleteUser(u.get());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		} else {
//			structure.setBody("User not found");
//			structure.setCode(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Invalid id");
//			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
			
			throw new IdNotFoundException();
		}
	}

	public ResponseEntity<ResponseStructure<String>> updateUser(User u) {
		ResponseStructure<String> structure = new ResponseStructure();
		structure.setBody("User not found");
		structure.setCode(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid id");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<User>> findUserById(int id) {
		Optional<User> u = dao.findUserById(id);
		ResponseStructure<User> structure = new ResponseStructure();
		if (u.isPresent()) {
			structure.setBody(u.get());
			structure.setMessage("User Found");
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		}
//		structure.setBody(null);
//		structure.setCode(HttpStatus.NOT_FOUND.value());
//		structure.setMessage("Invalid id");
//		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.NOT_FOUND);
		
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		ResponseStructure<List<User>> structure = new ResponseStructure();
		structure.setBody(dao.findAll());
		structure.setMessage("User Found");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.OK);
	}

}
