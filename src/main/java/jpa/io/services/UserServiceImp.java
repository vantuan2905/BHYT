package jpa.io.services;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.io.entities.User;
import jpa.io.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository userRepo;
	@Override
	public User saveUser(User u) {
		// Create an instance of the Random class
        Random random = new Random();

        // Generate a random 9-digit number
        long nineDigitNumber = 100_000_000L + random.nextInt(900_000_000);

		u.setUserId(u.getMabh());
		u.setPassword(String.valueOf(nineDigitNumber));
		return userRepo.save(u);
	}
	@Override
	public List<User> getListUser() {
		return userRepo.findAll();
	}
	
	
}
