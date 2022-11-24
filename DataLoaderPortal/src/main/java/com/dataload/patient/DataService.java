package com.dataload.patient;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataload.constants.ResponseConstants;
import com.dataload.models.BaseResponse;
import com.dataload.models.UserDetails;
import com.dataload.utils.AsyncTaskExecutor;
import com.dataload.utils.LoadExceptionHandler;

@Service
public class DataService {

	@Autowired
	private DataDao dao;

	@Autowired
	private AsyncTaskExecutor asyncCalls;
	private static final Logger logger = LoggerFactory.getLogger(DataService.class);

	public BaseResponse<Void> loadPatientData(List<UserDetails> userDetails) throws LoadExceptionHandler {
		try {
//			asyncCalls.savePatientsDetails(userDetails);
			if (dao.saveAll(userDetails).isEmpty())
				return new BaseResponse<Void>(ResponseConstants.STATUS401, ResponseConstants.FAIL);
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured during data loading", e);
		}
		return new BaseResponse<Void>(ResponseConstants.STATUS200, ResponseConstants.UPDATE_SUCCESS);
	}

	public BaseResponse<List<UserDetails>> searchForPatient(String patientName) throws LoadExceptionHandler {
		try {
			Optional<List<UserDetails>> details = dao
					.findByPatientNameIgnoreCaseContainingOrderByPatientName(patientName);
			if (details.isPresent())
				return new BaseResponse<List<UserDetails>>(ResponseConstants.STATUS200, ResponseConstants.SUCESS,
						details.get());
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured during data loading", e);
		}
		return new BaseResponse<List<UserDetails>>(ResponseConstants.STATUS401, ResponseConstants.NODATA_FOUND);
	}

	public BaseResponse<Void> updatePatient(UserDetails userDetails) throws LoadExceptionHandler {
		try {
//			Optional<UserDetails> fromDb = dao.findById(userDetails.getPatientId());
//			UserDetails details = fromDb.get();
//			details.setPatientAddress(userDetails.getPatientAddress());
//			details.setPatientContactNumber(userDetails.getPatientContactNumber());
//			details.setPatientDateOfBirth(userDetails.getPatientDateOfBirth());
//			details.setPatientEmail(userDetails.getPatientEmail());
			if (dao.save(userDetails) == null)
				return new BaseResponse<Void>(ResponseConstants.STATUS401, ResponseConstants.FAIL);
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured during updating patient loading", e);
		}
		return new BaseResponse<Void>(ResponseConstants.STATUS200, ResponseConstants.SUCESS);
	}

	public BaseResponse<List<UserDetails>> getPatientDetails() throws LoadExceptionHandler {
		try {
			List<UserDetails> details = dao.findAll();
			if (!details.isEmpty()) {
				return new BaseResponse<List<UserDetails>>(ResponseConstants.STATUS200, ResponseConstants.SUCESS,
						details);
			}
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured getting patinet data", e);
		}
		return new BaseResponse<List<UserDetails>>(ResponseConstants.STATUS401, ResponseConstants.FAIL);
	}

	public void savePatientsDetails(List<UserDetails> userDetails) {
		try {
			// need to implement the logic of uploading the data batch wise
			dao.saveAll(userDetails);
		} catch (Exception e) {
			logger.error("Exception occured during data loading", e);
		}

	}

}
