package edu.mga.itec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mga.itec.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String userId);

}
