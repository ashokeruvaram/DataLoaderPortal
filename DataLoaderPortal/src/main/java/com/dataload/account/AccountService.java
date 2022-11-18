package com.dataload.account;

import org.springframework.stereotype.Service;

import com.dataload.models.BaseResponse;
import com.dataload.models.LoginDetails;

@Service
public class AccountService {

	public BaseResponse login(LoginDetails loginDetails) {
		System.out.println("hello");
		return null;
	}

}
