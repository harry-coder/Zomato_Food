package com.lybrate.zomato.RetrofitModelClasses;

public class ReviewsItem{
	private Review review;

	public void setReview(Review review){
		this.review = review;
	}

	public Review getReview(){
		return review;
	}

	@Override
 	public String toString(){
		return 
			"ReviewsItem{" + 
			"review = '" + review + '\'' + 
			"}";
		}
}
