package com.dataload.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringBootConfiguration;

import com.dataload.constants.ResponseConstants;
import com.dataload.models.BaseResponse;
import com.dataload.models.UserDetails;
import com.dataload.repository.DataDao;
import com.dataload.utils.LoadExceptionHandler;

@SpringBootConfiguration
@ExtendWith(MockitoExtension.class)
public class DataServiceTest {
	@InjectMocks
	private DataService service;

	@Mock
	private DataDao dao;

	@Test
	public void myTest() {
		assertNotNull(service);
		assertNotNull(dao);
	}

	@Test
	public void loadPatientDataTest() throws LoadExceptionHandler {
		when(dao.saveAll(new ArrayList<UserDetails>())).thenReturn(new ArrayList<UserDetails>());
		assertEquals(new BaseResponse<Void>(ResponseConstants.STATUS401, ResponseConstants.FAIL).getStatusMessage(),
				service.loadPatientData(new ArrayList<UserDetails>()).getStatusMessage());

		when(dao.saveAll(new ArrayList<UserDetails>()))
				.thenReturn(Stream.of(new UserDetails()).collect(Collectors.toList()));
		assertEquals(new BaseResponse<Void>(ResponseConstants.STATUS200, ResponseConstants.UPDATE_SUCCESS)
				.getStatusMessage(), service.loadPatientData(new ArrayList<UserDetails>()).getStatusMessage());

		when(dao.saveAll(null)).thenThrow(new LoadExceptionHandler("Exception occured during data loading"));
		assertEquals(new LoadExceptionHandler("Exception occured during data loading").getMessage(),
				service.loadPatientData(null).getStatusMessage());

	}
}
