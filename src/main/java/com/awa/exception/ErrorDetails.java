package com.awa.exception;

import java.util.Date;

public class ErrorDetails {

	private Date timestamp;
	private String message;
	private String details;
	
	//public ErrorDetails() {};
	
	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimeStamp() {
		return timestamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
}
