package com.dataload.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import com.dataload.models.UserDetails;
import com.dataload.patient.DataService;

@Component("asyncExecutor")
@EnableAsync
public class AsyncTaskExecutor {

	private static final Logger logger = LoggerFactory.getLogger(AsyncTaskExecutor.class);

	private DataService dataService;

	@Autowired
	public AsyncTaskExecutor(@Lazy DataService dataService) {
		this.dataService = dataService;
	}

	@Async
	public void savePatientsDetails(List<UserDetails> userDetails) {
		try {
			dataService.savePatientsDetails(userDetails);
		} catch (Exception e) {
			logger.error("Exception occurred while saving image", e);
		}

	}
}
