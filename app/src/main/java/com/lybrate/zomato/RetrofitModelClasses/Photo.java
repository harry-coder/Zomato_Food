package com.lybrate.zomato.RetrofitModelClasses;

public class Photo{
	private String thumbUrl;
	private String friendlyTime;
	private int resId;
	private int width;
	private String caption;
	private String id;
	private User user;
	private String url;
	private int timestamp;
	private int height;

	public void setThumbUrl(String thumbUrl){
		this.thumbUrl = thumbUrl;
	}

	public String getThumbUrl(){
		return thumbUrl;
	}

	public void setFriendlyTime(String friendlyTime){
		this.friendlyTime = friendlyTime;
	}

	public String getFriendlyTime(){
		return friendlyTime;
	}

	public void setResId(int resId){
		this.resId = resId;
	}

	public int getResId(){
		return resId;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setTimestamp(int timestamp){
		this.timestamp = timestamp;
	}

	public int getTimestamp(){
		return timestamp;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"Photo{" + 
			"thumb_url = '" + thumbUrl + '\'' + 
			",friendly_time = '" + friendlyTime + '\'' + 
			",res_id = '" + resId + '\'' + 
			",width = '" + width + '\'' + 
			",caption = '" + caption + '\'' + 
			",id = '" + id + '\'' + 
			",user = '" + user + '\'' + 
			",url = '" + url + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}
