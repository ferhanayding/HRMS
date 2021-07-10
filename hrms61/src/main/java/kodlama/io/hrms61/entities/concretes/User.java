	package kodlama.io.hrms61.entities.concretes;


import java.time.LocalDateTime;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;



@Entity

@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",insertable=false, updatable=false)
	private int id;
	
	@Column(name="email",unique = true)
	private String email;
	
	@Column(name="password")
	private String password;
	
    @Column(name="created_at",columnDefinition = "Date default CURRENT_DATE")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name="active", columnDefinition = "boolean default true")
    private boolean active;

	public User(int id, String email, String password, LocalDateTime createdAt, boolean active) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.active = active;
	}
	public User() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
