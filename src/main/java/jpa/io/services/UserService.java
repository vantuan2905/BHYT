package jpa.io.services;

import java.util.List;

import jpa.io.entities.User;
import jpa.io.repositories.UserRepository;

public interface UserService{
	User saveUser(User u) ;
	List<User> getListUser();
}
