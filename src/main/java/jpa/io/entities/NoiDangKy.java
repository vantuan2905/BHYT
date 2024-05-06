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
@Table(name = "NoiDangKi")
public class NoiDangKy {
	@Id
	@Column(name = "MaSoNoiDangKi")
    private String MaSoNoiDangKi;
	
	@Column(name = "ten")
    private String ten;
	
	@Column(name = "tinh")
    private String tinh;
	
	@Column(name = "huyen")
    private String huyen;
	
	@Column(name = "xa")
    private String xa;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "NoiDangKi", referencedColumnName = "MaSoNoiDangKi")
    List <BaoHiem > DanhSachBaoHiem = new ArrayList<>();
}
