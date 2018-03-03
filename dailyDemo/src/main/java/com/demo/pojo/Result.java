package com.demo.pojo;

import java.io.Serializable;

public class Result implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private boolean success;
	private String message;
	private Object data;
	
	public Result() {
	}
	
	public Result(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	/**
	 * 输入提示信息返回成功
	 * @param message
	 * @return
	 */
	public static Result ok(String message){
		Result result=new Result(true,message);
		return result;
	}
	/**
	 * 输入提示信息返回成功
	 * @param message
	 * @return
	 */
	public static Result error(String message){
		Result result=new Result(false,message);
		return result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
