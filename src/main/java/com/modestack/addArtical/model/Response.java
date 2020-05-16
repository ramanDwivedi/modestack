package com.modestack.addArtical.model;

import java.util.Collection;

import org.springframework.http.HttpStatus;

import com.modestack.addArtical.dto.ResponseDTO;


public class Response<T>  implements ResponseDTO<T>{

	private int code;
	private Collection message;
	private T data;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Collection getMessage() {
		return message;
	}
	public void setMessage(Collection message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
