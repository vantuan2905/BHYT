package jpa.io.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
	 	@Id
	    @Column(name = "ID")
	    private String userId;
	 	 @Column(name = "PASSWORD")
		    private String password;
	    @Column(name = "Ten")
	    private String ten;
	    @Column(name = "Mabh")
	    private String mabh;
	    @Column(name = "CCCD")
	    private String cccd;
	    @Column(name = "Email")
	    private String email;
	    @Column(name = "SDT")
	    private String sdt;
	    @Column(name = "DiaChi")
	    private String diaChi;
	    
}
