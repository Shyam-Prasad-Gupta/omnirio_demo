package com.omnirio.demo.dto;

public class ResponseJson<T> {

	private String message;

	private T data;

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(final T data) {
		this.data = data;
	}

}
