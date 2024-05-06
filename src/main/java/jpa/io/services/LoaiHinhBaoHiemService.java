package jpa.io.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.io.entities.LoaiHinhBaoHiem;
import jpa.io.repositories.LoaiHinhBaoHiemRepository;

@Service
public class LoaiHinhBaoHiemService {
	@Autowired
	LoaiHinhBaoHiemRepository lr;
	public void save(LoaiHinhBaoHiem l) {
		lr.save( l);
	}
	public LoaiHinhBaoHiem findByTenLoai(String ten) {
		return lr.findByTenLoai(ten);
	}
}
