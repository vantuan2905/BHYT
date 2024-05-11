package jpa.io.services;

import java.util.List;

import jpa.io.entities.Users;
import jpa.io.repositories.UserRepository;

public interface UserService{
	Users saveUser(Users u) ;
	List<Users> getListUser();
	Users getUserById(int id);
	Users getUserByMaBaoHiem(int ma);
	Users getUserByCccd(String cccd);
}
