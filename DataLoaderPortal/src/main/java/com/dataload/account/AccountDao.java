package com.dataload.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dataload.models.LoginDetails;

@Repository
public interface AccountDao extends JpaRepository<LoginDetails, Integer> {

}
