package com.dataload.patient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dataload.constants.ResponseConstants;
import com.dataload.models.BaseResponse;
import com.dataload.models.UserDetails;

@RestController
@RequestMapping("/patient")
public class DataController {

	@Autowired
	private DataService service;

	@PostMapping(value = "/load/patientdata", headers = "Accept=application/json")
	public BaseResponse<Void> loadPatientData(@RequestBody List<UserDetails> userDetails) {
		try {
			return service.loadPatientData(userDetails);
		} catch (Exception e) {
			System.out.print("Exception occured while loading the user data controller");
		}
		return new BaseResponse<Void>(ResponseConstants.STATUS500, ResponseConstants.SOMETHING_WRONG);
	}

	@GetMapping(value = "/getpatients", headers = "Accept=application/json")
	public BaseResponse<List<UserDetails>> getPatientDetails() {
		try {
			return service.getPatientDetails();
		} catch (Exception e) {
			System.out.print("Exception occured while fetching data controller");
		}
		return new BaseResponse<List<UserDetails>>(ResponseConstants.STATUS500, ResponseConstants.SOMETHING_WRONG);
	}

	@GetMapping("/retrive/{patientName}")
	public BaseResponse<List<UserDetails>> searchForPatient(@PathVariable String patientName) {
		try {
			return service.searchForPatient(patientName);
		} catch (Exception e) {
			System.out.print("Exception occured while searching for patient controller");
		}
		return new BaseResponse<List<UserDetails>>(ResponseConstants.STATUS500, ResponseConstants.SOMETHING_WRONG);
	}

	@PutMapping("/updatepatient")
	public BaseResponse<Void> updatePatient(@RequestBody UserDetails userDetails) {
		try {
			return service.updatePatient(userDetails);
		} catch (Exception e) {
			System.out.print("Exception occured while updating the patient detils controller");
		}
		return new BaseResponse<Void>(ResponseConstants.STATUS500, ResponseConstants.SOMETHING_WRONG);
	}

}
