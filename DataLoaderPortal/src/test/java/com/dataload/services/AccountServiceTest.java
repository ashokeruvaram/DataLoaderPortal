//package com.dataload.services;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.SpringBootConfiguration;
//
//import com.dataload.constants.ResponseConstants;
//import com.dataload.models.BaseResponse;
//import com.dataload.models.LoginDetails;
//import com.dataload.repository.AccountDao;
//import com.dataload.utils.LoadExceptionHandler;
//
////@SpringBootTest
//@SpringBootConfiguration
//@ExtendWith(MockitoExtension.class)
//public class AccountServiceTest {
//
//	@InjectMocks
//	private AccountService service;
//
//	@Mock
//	private AccountDao dao;
//
//	@Test
//	public void myTest() {
//		assertNotNull(service);
//		assertNotNull(dao);
//	}
//
//	@Test
//	public void login() throws LoadExceptionHandler {
//		Optional<LoginDetails> details = Optional.of(new LoginDetails(1, "", ""));
//		when(dao.findByUserName("")).thenReturn(details);
//		assertEquals(
//				new BaseResponse<LoginDetails>(ResponseConstants.STATUS401, ResponseConstants.USERNAME_DOESNT_EXIST)
//						.getStatusMessage(),
//				service.login(new LoginDetails(1, "", "")).getStatusMessage());
//
////		assertEquals(new LoadExceptionHandler("Exception occured during login"),
////				service.login(new LoginDetails(1, "", "")));
////		when(dao.findByUserName("")).thenThrow(new BaseResponse());
//	}
//
//}
