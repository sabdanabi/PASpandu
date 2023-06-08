package com.example.pts_sabdanabi;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("image")
	private String image;

	@SerializedName("link")
	private String link;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("posts")
	private List<PostsItem> posts;

	public String getImage(){
		return image;
	}

	public String getLink(){
		return link;
	}

	public String getDescription(){
		return description;
	}

	public String getTitle(){
		return title;
	}

	public List<PostsItem> getPosts(){
		return posts;
	}
}