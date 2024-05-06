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
@Table(name = "BaoHiem")
public class BaoHiem {
	@Id
	@Column(name = "MaBaoHiem")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaBaoHiem;
	
	@Column(name = "BatDau")
    private String BatDau;
	
	@Column(name = "KetThuc")
    private String KetThuc;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "UserId")
	 private User user;
}
