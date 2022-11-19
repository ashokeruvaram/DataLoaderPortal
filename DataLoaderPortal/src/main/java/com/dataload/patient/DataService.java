package com.dataload.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataload.constants.ResponseConstants;
import com.dataload.models.BaseResponse;
import com.dataload.models.UserDetails;
import com.dataload.utils.LoadExceptionHandler;

@Service
public class DataService {

	@Autowired
	private DataDao dao;

	public BaseResponse loadPatientData(List<UserDetails> userDetails) throws LoadExceptionHandler {
		try {
			if (dao.saveAll(userDetails) != null) {
				return new BaseResponse(ResponseConstants.STATUS200, ResponseConstants.UPDATE_SUCCESS);
			}
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured during data loading", e);
		}
		return new BaseResponse(ResponseConstants.STATUS400, ResponseConstants.FAIL);
	}

	public BaseResponse searchForPatient(String patientName) throws LoadExceptionHandler {
		try {
			List<UserDetails> details = dao.searchByName(patientName);
			if (details != null && details.size() > 0)
				return new BaseResponse(ResponseConstants.STATUS200, ResponseConstants.SUCESS, details);
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured during data loading", e);
		}
		return new BaseResponse(ResponseConstants.STATUS200, ResponseConstants.NODATA_FOUND);
	}

	public BaseResponse updatePatient(UserDetails userDetails) throws LoadExceptionHandler {
		try {
//			Optional<UserDetails> fromDb = dao.findById(userDetails.getPatientId());
//			UserDetails details = fromDb.get();
//			details.setPatientAddress(userDetails.getPatientAddress());
//			details.setPatientContactNumber(userDetails.getPatientContactNumber());
//			details.setPatientDateOfBirth(userDetails.getPatientDateOfBirth());
//			details.setPatientEmail(userDetails.getPatientEmail());
			if (dao.save(userDetails) == null)
				return new BaseResponse(ResponseConstants.STATUS200, ResponseConstants.FAIL);
		} catch (Exception e) {
			throw new LoadExceptionHandler("Exception occured during updating patient loading", e);
		}
		return new BaseResponse(ResponseConstants.STATUS200, ResponseConstants.SUCESS);
	}

}
