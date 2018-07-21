package edu.mga.itec.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mga.itec.model.UserInfo;

public interface InfoRepository extends JpaRepository<UserInfo, Long> {

	Collection<UserInfo> findByUserEmail(String userId);


}
