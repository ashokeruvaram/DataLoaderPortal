package com.dataload.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataload.models.LoginDetails;

@Repository
public interface AccountDao extends JpaRepository<LoginDetails, Integer> {

//	@Query(value = "SELECT * FROM " + DataBaseConstants.DATABASE_NAME + "." + DataBaseConstants.LOGIN_DETAILS
//			+ " where user_name=:userName", nativeQuery = true)
	Optional<LoginDetails> findByUserName(String userName);

}
