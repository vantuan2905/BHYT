package jpa.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.io.entities.LoginDTO;
import jpa.io.entities.User;
import jpa.io.services.UserService;

@RestController
@RequestMapping("/users")
public class Controller {
	@Autowired
	UserService userService;
	 //all user get
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
    	System.out.println("okk");
        List<User> allUser = userService.getListUser();
        return ResponseEntity.ok(allUser);
    }
    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
    //check login
    @GetMapping("/check_log")
    public Boolean check_log(@RequestBody LoginDTO login) {
    	List<User> allUser = userService.getListUser();
    	for(User i:allUser) {
    		System.out.println(i.getMabh()+"  "+i.getPassword()+"  "+login.getMabh()+ " "+login.getPassword());
    		if(i.getMabh().equals(login.getMabh())&&i.getPassword().equals(login.getPassword())) return true;
    	}
    	return false;
    }
    //khai báo
    @PutMapping("/{userId}")
    public ResponseEntity<User> khai_bao(@RequestBody User user) {
    	 User user1 = userService.saveUser(user);
         return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
}
