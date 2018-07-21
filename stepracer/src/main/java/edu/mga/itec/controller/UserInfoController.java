package edu.mga.itec.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mga.itec.exception.InfoNotFoundException;
import edu.mga.itec.exception.UserNotFoundException;
import edu.mga.itec.model.UserInfo;
import edu.mga.itec.repository.InfoRepository;
import edu.mga.itec.repository.UserRepository;

@RestController
@RequestMapping("/userinfo/{userId}")
public class UserInfoController {
	
	private final InfoRepository infoRepository;
	private final UserRepository  userRepository;
	
	@Autowired
	public UserInfoController(InfoRepository infoRepository,
			UserRepository userRepository) {
		
		this.infoRepository = infoRepository;
		this.userRepository = userRepository;
	}
	
	@GetMapping
	Collection<UserInfo> readInfo(@PathVariable String userId){
		this.validateUser(userId);
		
		return this.infoRepository.findByUserEmail(userId);
	}
	
	@PostMapping
	ResponseEntity<?> add(@PathVariable String userId, @RequestBody UserInfo input){
		this.validateUser(userId);
		
		return this.userRepository
				.findByEmail(userId)
				.map(user -> {
					UserInfo result = this.infoRepository.save(new UserInfo(user,
							input.getUsername(), input.getDailySteps()));
					
				})			
				.orElse(ResponseEntity.noContent().build());
	}
	
	@GetMapping("/infoId")
	UserInfo readInfo(@PathVariable String userId, @PathVariable Long infoId) {	
		this.validateUser(userId);
		
		return this.infoRepository
				.findById(infoId)
				.orElseThrow(() -> new InfoNotFoundException(infoId));
				
	}
	
	private void validateUser(String userId) {
		this.userRepository
			.findByEmail(userId)
			.orElseThrow(() -> new UserNotFoundException(userId));
	}
	

}
