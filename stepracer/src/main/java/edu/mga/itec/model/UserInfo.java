package edu.mga.itec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserInfo {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonIgnore
    @ManyToOne
	private User user;
	
	private String username;
	
	private Long dailySteps;
	
	public UserInfo() {}

	public UserInfo(User user, String username, Long dailySteps) {
		
		this.user = user;
		this.username = username;
		this.dailySteps = dailySteps;
	}
	
	public static UserInfo from(User user, UserInfo userInfo) {
		
		return new UserInfo(user, userInfo.username, userInfo.getDailySteps());
		
	}

	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public String getUsername() {
		return username;
	}

	public Long getDailySteps() {
		return dailySteps;
	}
	
	
	
	
	
	

}
