package jpa.io.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.io.entities.LoaiHinhBaoHiem;

public interface LoaiHinhBaoHiemRepository extends JpaRepository<LoaiHinhBaoHiem, String>{
	LoaiHinhBaoHiem findByTenLoai(String tenLoai);
}
