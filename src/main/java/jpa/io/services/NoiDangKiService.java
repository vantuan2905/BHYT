package jpa.io.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.io.entities.NoiDangKy;
import jpa.io.repositories.NoiDangKiRepository;

@Service
public class NoiDangKiService {
	@Autowired
	NoiDangKiRepository r;
	public void save(NoiDangKy n) {
		r.save(n);
	}
	public NoiDangKy findBenhVien(String huyen) {
		return r.findByHuyen(huyen);
	}
	public NoiDangKy findTYT(String tinh,String huyen,String xa) {
//		return r.findByHuyen(huyen);
		return r.findByTinhAndHuyenAndXa(tinh, huyen, xa);
	}
}
