package com.example.pts_sabdanabi;

import com.google.gson.annotations.SerializedName;

public class ResponseNews{

	@SerializedName("data")
	private Data data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private Object message;

	public Data getData(){
		return data;
	}

	public boolean isSuccess(){
		return success;
	}

	public Object getMessage(){
		return message;
	}
}