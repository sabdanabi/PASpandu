package com.example.pts_sabdanabi;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class NewsData {

	@SerializedName("image")
	private String image;

	@SerializedName("link")
	private String link;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("posts")
	private List<NewsTampilan> posts;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
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

	public void setPosts(List<NewsTampilan> posts){
		this.posts = posts;
	}

	public List<NewsTampilan> getPosts(){
		return posts;
	}
}