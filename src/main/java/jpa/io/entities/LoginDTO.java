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
@Table(name = "login")
public class LoginDTO {
	 	@Id
	    @Column(name = "MABH")
	    private String mabh;
	 	 @Column(name = "PASSWORD")
		    private String password;
	    
	    
}
