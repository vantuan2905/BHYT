package jpa.io.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.io.entities.BaoHiem;
import jpa.io.repositories.BaoHiemRepository;

@Service
public class BaoHiemService {
	@Autowired
	BaoHiemRepository bh;
	public void save(BaoHiem b) {
		bh.save(b);
		
	}
	public BaoHiem findBaoHiem(int ma) {
		return bh.findById(ma).get();
		
	}
}
