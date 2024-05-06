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
@Table(name = "LoaiHinhBaoHiem")
public class LoaiHinhBaoHiem {
	@Id
    @Column(name = "MaLoai")
    private String MaLoai;
	
	@Column(name = "tenLoai")
    private String tenLoai;
	
	@Column(name = "MoTa")
    private String MoTa;
	
	@Column(name = "PhanTramTinhPhi")
    private float PhanTramPhi;
	
	@Column(name = "BoiThuong")
    private long BoiThuong;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "LoaiBaoHiem", referencedColumnName = "MaLoai")
    List <BaoHiem > DanhSachBaoHiem = new ArrayList<>();
}
