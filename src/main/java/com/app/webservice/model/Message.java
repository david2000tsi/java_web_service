package com.app.webservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String timestamp;
	private String message;

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
