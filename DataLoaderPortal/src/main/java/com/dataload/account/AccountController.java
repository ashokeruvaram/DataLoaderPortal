package com.dataload.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dataload.models.BaseResponse;
import com.dataload.models.LoginDetails;

@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService service;

	@PostMapping(value = "/login", headers = "Accept=application/json")
	public BaseResponse login(@RequestBody LoginDetails loginDetails) {
		try {
			return service.login(loginDetails);
		} catch (Exception e) {
			System.out.print("Exception occured while login using password the user controller");
		}
		return new BaseResponse(500, "Internal server error");
	}

}
