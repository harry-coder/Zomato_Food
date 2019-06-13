package com.lybrate.zomato.RetrofitModelClasses;

import java.util.List;

public class AllReviews{
	private List<ReviewsItem> reviews;

	public void setReviews(List<ReviewsItem> reviews){
		this.reviews = reviews;
	}

	public List<ReviewsItem> getReviews(){
		return reviews;
	}

	@Override
 	public String toString(){
		return 
			"AllReviews{" + 
			"reviews = '" + reviews + '\'' + 
			"}";
		}
}