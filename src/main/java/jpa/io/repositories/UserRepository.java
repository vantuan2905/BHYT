package jpa.io.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jpa.io.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
		User findByMabh(int mabh);
}
