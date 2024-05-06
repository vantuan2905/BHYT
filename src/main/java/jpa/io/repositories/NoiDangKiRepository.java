package jpa.io.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.io.entities.NoiDangKy;

public interface NoiDangKiRepository extends JpaRepository<NoiDangKy, String>{
	NoiDangKy findByHuyen(String huyen);
	NoiDangKy findByTinhAndHuyenAndXa(String tinh, String huyen, String xa);
	
}
