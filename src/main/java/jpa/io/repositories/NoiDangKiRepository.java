package jpa.io.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.io.entities.NoiDangKy;

public interface NoiDangKiRepository extends JpaRepository<NoiDangKy, String>{
	List<NoiDangKy> findByHuyen(String huyen);
	NoiDangKy findByTinhAndHuyenAndXa(String tinh, String huyen, String xa);
	
}
