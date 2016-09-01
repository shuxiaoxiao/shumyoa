package com.shupro.oa.vo;

import java.io.Serializable;

/**
 * 操作结果集
 * 
 * @author：shuheng
 */
public class Result implements Serializable {

	private static final long serialVersionUID = 5576237395711742681L;

	private boolean success = false;
	private int code;
	private Object data;
	private String message;

	public Result(){}
	
	public Result(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(int code, Object data, String message) {
		this.code = code;
		this.data = data;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
