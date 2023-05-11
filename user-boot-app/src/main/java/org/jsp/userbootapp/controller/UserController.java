package org.jsp.userbootapp.controller;

import java.util.List;
import java.util.Optional;

import org.jsp.userbootapp.dto.ResponseStructure;
import org.jsp.userbootapp.dto.User;
import org.jsp.userbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//FLOW OF PROGRAM 
// CONTROLLER--> SERVICE(Used to separate the business logic)--> DAO --> REPOSITORY --> PREDEFINED METHODS

//ResponseEntity is used to create with a status code only(200 or matching codeBody);

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User u) {
		return service.saveUser(u);
	}

	@PutMapping("/user")
	public ResponseEntity<ResponseStructure<String>> updateUser(@RequestBody User u) {
		return service.updateUser(u);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable int id) {
		return service.findUserById(id);
	}

	@DeleteMapping("user/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int id) {
		return service.delete(id);
	}

	@GetMapping("/user")
	public ResponseEntity<ResponseStructure<List<User>>> fetchALL() {
		return service.findAll();
	}
}
