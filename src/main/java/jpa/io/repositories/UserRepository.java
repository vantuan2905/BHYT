package jpa.io.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jpa.io.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
		Users findByMabh(int mabh);
		Users findByCccd(String cccd);
}
