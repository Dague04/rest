package edu.mga.itec.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String email;
	
	@JsonIgnore
	private String password;
	
	@OneToMany(mappedBy = "user")
	private Set<UserInfo> userInfo = new HashSet<>();
	
	public User() {}

	public User(String email, String password) {
		
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Set<UserInfo> getUserInfo() {
		return userInfo;
	}
	
	
	
	

}
