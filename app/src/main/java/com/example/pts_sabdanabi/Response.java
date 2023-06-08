package com.example.pts_sabdanabi;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("data")
	private Data data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private Object message;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(Object message){
		this.message = message;
	}

	public Object getMessage(){
		return message;
	}
}