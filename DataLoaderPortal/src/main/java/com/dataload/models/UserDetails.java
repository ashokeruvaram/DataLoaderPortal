package com.dataload.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_data")
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String patientName;
	private String patientAddress;
	private String patientDateOfBirth;
	private String patientEmail;
	private String patientContactNumber;
	private long patientDrugId;
	private String patientDrugName;
	private String status;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientDateOfBirth() {
		return patientDateOfBirth;
	}

	public void setPatientDateOfBirth(String patientDateOfBirth) {
		this.patientDateOfBirth = patientDateOfBirth;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientContactNumber() {
		return patientContactNumber;
	}

	public void setPatientContactNumber(String patientContactNumber) {
		this.patientContactNumber = patientContactNumber;
	}

	public long getPatientDrugId() {
		return patientDrugId;
	}

	public void setPatientDrugId(long patientDrugId) {
		this.patientDrugId = patientDrugId;
	}

	public String getPatientDrugName() {
		return patientDrugName;
	}

	public void setPatientDrugName(String patientDrugName) {
		this.patientDrugName = patientDrugName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDetails(int patientId, String patientName, String patientAddress, String patientDateOfBirth,
			String patientEmail, String patientContactNumber, long patientDrugId, String patientDrugName,
			String status) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAddress = patientAddress;
		this.patientDateOfBirth = patientDateOfBirth;
		this.patientEmail = patientEmail;
		this.patientContactNumber = patientContactNumber;
		this.patientDrugId = patientDrugId;
		this.patientDrugName = patientDrugName;
		this.status = status;
	}

	public UserDetails() {
	}

}
