package com.dataload.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class BaseResponse {

	private int statusCode;
	private String statusMessage;

	@JsonInclude(value = Include.NON_NULL)
	private List<UserDetails> userDetils;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public List<UserDetails> getUserDetils() {
		return userDetils;
	}

	public void setUserDetils(List<UserDetails> userDetils) {
		this.userDetils = userDetils;
	}

	public BaseResponse(int statusCode, String statusMessage, List<UserDetails> details) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.userDetils = details;
	}

	public BaseResponse(int statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

}
