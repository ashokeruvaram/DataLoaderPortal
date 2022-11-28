//package com.dataload.services;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.when;
//
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import org.apache.tomcat.jni.Library;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.SpringBootConfiguration;
//
//import com.dataload.constants.ResponseConstants;
//import com.dataload.models.BaseResponse;
//import com.dataload.models.UserDetails;
//import com.dataload.repository.DataDao;
//import com.dataload.utils.LoadExceptionHandler;
//
//@SpringBootConfiguration
//@ExtendWith(MockitoExtension.class)
//public class DataServiceTest {
//	@InjectMocks
//	private DataService service;
//
//	@Mock
//	private DataDao dao;
//
//	@Test
//	public void myTest() {
//		assertNotNull(service);
//		assertNotNull(dao);
//	}
//
//	@Test
//	public void loadPatientDataTest() {
//		when(dao.saveAll(new ArrayList<UserDetails>())).thenReturn(new ArrayList<UserDetails>());
//		try {
//			assertEquals(new BaseResponse<Void>(ResponseConstants.STATUS401, ResponseConstants.FAIL).getStatusMessage(),
//					service.loadPatientData(new ArrayList<UserDetails>()).getStatusMessage());
//		} catch (LoadExceptionHandler e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		when(dao.saveAll(new ArrayList<UserDetails>()))
//				.thenReturn(Stream.of(new UserDetails()).collect(Collectors.toList()));
//		try {
//			assertEquals(
//					new BaseResponse<Void>(ResponseConstants.STATUS200, ResponseConstants.UPDATE_SUCCESS)
//							.getStatusMessage(),
//					service.loadPatientData(new ArrayList<UserDetails>()).getStatusMessage());
//		} catch (LoadExceptionHandler e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//
//	@Test
//	public void additionTest() {
//		assertEquals(10, DataService.addition(5, 5));
//	}
//
//	// When ever u want to test the private method we have to call a private method
//	// inside a public method and call the that public method from test class
//	// Refer below ex.
//	@Test
//	public void additionTests() {
//		assertEquals(15, service.additionPublic(5, 5, 5));
//	}
//
////	@Test
////	public void privateMethodWithLibary() throws NoSuchMethodException, SecurityException, IllegalAccessException,
////			IllegalArgumentException, InvocationTargetException {
////		Method method = Library.class.getDeclaredMethod("privateAddition", int.class, int.class, int.class);
////		method.setAccessible(true);
////		int sum = (int) method.invoke(service, 5, 5, 5);
////		assertEquals(15, sum);
////	}
//}
