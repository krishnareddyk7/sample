package com.kkcr.spring;

public class Person {
	
	private String message;
	private long id;
	
	

	public Person(String message, long id) {
		super();
		this.message = message;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
