package com.lybrate.zomato.RetrofitModelClasses;

public class PhotosItem{
	private Photo photo;

	public void setPhoto(Photo photo){
		this.photo = photo;
	}

	public Photo getPhoto(){
		return photo;
	}

	@Override
 	public String toString(){
		return 
			"PhotosItem{" + 
			"photo = '" + photo + '\'' + 
			"}";
		}
}
