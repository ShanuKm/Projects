package org.jsp.userbootapp.repository;

import org.jsp.userbootapp.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{

}
