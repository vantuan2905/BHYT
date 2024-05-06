package jpa.io.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CongTyBaoHiem")
public class CongTyBaoHiem {
	@Id
    @Column(name = "CongTyBaoHiemId")
    private String CongTyBaoHiemId;
	
	@Column(name = "TenCongTy")
	private String TenCongTy;
	
	@Column(name = "DiaChi")
	private String DiaChi;
	
	@Column(name = "SDT")
	private String sdt;
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CongTyBaoHiem", referencedColumnName = "CongTyBaoHiemId")
    List <HoaDon > DanhSachHoaDon = new ArrayList<>();
	
}
