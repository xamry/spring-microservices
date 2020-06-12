package com.xamry.springboot.restful.springbootrestfulws.hello;

public class HelloWorldBean {
	
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}
	
	

	public String getMessage() {
		return message;
	}



	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}	

}
