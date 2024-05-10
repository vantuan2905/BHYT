package jpa.io.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "HoaDon")
public class HoaDon {
	@Id
	@Column(name = "ID")
	
    private int MaHoaDon;
	
	@Column(name = "NgayTao")
    private String NgayTao;
	
	@Column(name = "TongHoTro")
    private long HoTro;
	
	@Column(name = "TongTien")
    private long TongTien;
	
	@Column(name = "TienNop")
    private long TienNop;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "MaBaoHiem")
	 private BaoHiem baoHiem;

}
