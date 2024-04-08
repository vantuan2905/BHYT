package jpa.io.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.io.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
		
}
