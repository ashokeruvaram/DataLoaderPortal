package com.dataload.account;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataload.constants.ResponseConstants;
import com.dataload.models.BaseResponse;
import com.dataload.models.LoginDetails;
import com.dataload.security.JwtUtil;
import com.dataload.security.PasswordEncDec;
import com.dataload.utils.LoadExceptionHandler;

@Service
public class AccountService {

	@Autowired
	private AccountDao dao;
	@Autowired
	private JwtUtil jwtUtil;

	public BaseResponse<LoginDetails> login(LoginDetails loginDetails) throws LoadExceptionHandler {
		try {
			Optional<LoginDetails> detailsFromDb = dao.getByUserName(loginDetails.getUserName());
			if (detailsFromDb.isPresent()) {
				LoginDetails details = detailsFromDb.get();
				return PasswordEncDec.bCrypter(loginDetails.getPassword(), details.getPassword())
						? new BaseResponse<LoginDetails>(ResponseConstants.STATUS200, ResponseConstants.LOGIN_SUCCESS,
								new LoginDetails(details.getId(), details.getUserName(),
										jwtUtil.generateToken(details.getUserName())))
						: new BaseResponse<LoginDetails>(ResponseConstants.STATUS200, ResponseConstants.WRONG_PASSWORD);
			} else
				return new BaseResponse<LoginDetails>(ResponseConstants.STATUS401,
						ResponseConstants.USERNAME_DOESNT_EXIST);
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured during login", e);
		}
	}

	public BaseResponse<Void> registerAdmin(LoginDetails loginDetails) throws LoadExceptionHandler {
		loginDetails.setPassword(PasswordEncDec.encryptingPassword(loginDetails.getPassword()));
		try {
			if (loginDetails != null) {
				Optional<LoginDetails> detailsFromDb = dao.getByUserName(loginDetails.getUserName());
				if (detailsFromDb.isPresent())
					return new BaseResponse<Void>(ResponseConstants.STATUS401, ResponseConstants.ALREADY_REGISTERED);
				dao.save(loginDetails);
			}
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured while registration");
		}
		return new BaseResponse<Void>(ResponseConstants.STATUS200, ResponseConstants.REGISTRATION_SUCCESS);
	}

}
