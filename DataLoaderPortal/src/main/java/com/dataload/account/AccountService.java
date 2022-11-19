package com.dataload.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataload.constants.ResponseConstants;
import com.dataload.models.BaseResponse;
import com.dataload.models.LoginDetails;
import com.dataload.utils.LoadExceptionHandler;

@Service
public class AccountService {

	@Autowired
	private AccountDao dao;

	public BaseResponse login(LoginDetails loginDetails) throws LoadExceptionHandler {
		try {
			LoginDetails details = dao.getByUserName(loginDetails.getUserName());
			if (details != null) {
				if (!details.getPassword().equals(loginDetails.getPassword()))
					return new BaseResponse(ResponseConstants.STATUS200, ResponseConstants.WRONG_PASSWORD);
			}
			else
				return new BaseResponse(ResponseConstants.STATUS200, ResponseConstants.USERNAME_DOESNT_EXIST);
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured during login", e);
		}
		return new BaseResponse(ResponseConstants.STATUS200, ResponseConstants.LOGIN_SUCCESS);
	}

}
