package jpa.io.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
	 	@Id
	    @Column(name = "ID")
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int userId;
	 	@Column(name = "USERNAME")
		private String username;
	 	@Column(name = "PASSWORD")
		private String password;
	    @Column(name = "Ten")
	    private String ten;
	    @Column(name = "Mabh")
	    private int mabh;
	    @Column(name = "CCCD")
	    private String cccd;
	    @Column(name = "Email")
	    private String email;
	    @Column(name = "SDT")
	    private String sdt;
	    @Column(name = "DiaChi")
	    private String diaChi;
	    @Column(name="role")
	    private int role;
	   
	    
}
