package jpa.io.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.io.entities.HoaDon;
import jpa.io.repositories.HoaDonRepository;

@Service
public class HoaDonService {
	@Autowired
	HoaDonRepository r;
	public void save(HoaDon h) {
		r.save(h);
	}
}
