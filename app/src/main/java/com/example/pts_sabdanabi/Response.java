package com.example.pts_sabdanabi;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("data")
	private NewsData data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private Object message;

	public void setData(NewsData data){
		this.data = data;
	}

	public NewsData getData(){
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