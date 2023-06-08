package com.example.pts_sabdanabi;

import com.google.gson.annotations.SerializedName;

public class PostsItem{

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("link")
	private String link;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("pubDate")
	private String pubDate;

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPubDate(String pubDate){
		this.pubDate = pubDate;
	}

	public String getPubDate(){
		return pubDate;
	}
}