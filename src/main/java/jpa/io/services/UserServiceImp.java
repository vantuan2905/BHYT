package jpa.io.services;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.io.entities.Users;
import jpa.io.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository userRepo;
	@Override
	public Users saveUser(Users u) {
		// Create an instance of the Random class
        Random random = new Random();

        // Generate a random 9-digit number
        long nineDigitNumber = 100_000_000L + random.nextInt(900_000_000);
        u.setUsername(u.getCccd());
		u.setPassword("12345");
		return userRepo.save(u);
	}
	@Override
	public List<Users> getListUser() {
		return userRepo.findAll();
	}
	public Users getUserById(int id) {
		return userRepo.findById(id).get();
	}
	@Override
	public Users getUserByMaBaoHiem(int ma) {
		// TODO Auto-generated method stub
		return userRepo.findByMabh(ma);
	}
	@Override
	public Users getUserByCccd(String cccd) {
		// TODO Auto-generated method stub
		return userRepo.findByCccd(cccd);
	}
	
	
}
