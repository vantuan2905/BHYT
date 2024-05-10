package jpa.io.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.io.entities.CongTyBaoHiem;
import jpa.io.repositories.CongTyBaoHiemRepository;

@Service
public class CongTyBaoHiemService {
	@Autowired
	CongTyBaoHiemRepository r;
	public void save(CongTyBaoHiem c) {
		r.save(c);
	}
	public CongTyBaoHiem getCongTyBaoHiem(String id) {
		return r.findById(id).get();
	}
	public CongTyBaoHiem getCongTyBaoHiemByDiaChi(String tinh,String huyen,String xa) {
		return r.findByTinhAndHuyenAndXa(tinh, huyen, xa);
	}
}
