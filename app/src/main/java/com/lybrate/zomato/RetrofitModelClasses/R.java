package com.lybrate.zomato.RetrofitModelClasses;

public class R{
	private int resId;

	public void setResId(int resId){
		this.resId = resId;
	}

	public int getResId(){
		return resId;
	}

	@Override
 	public String toString(){
		return 
			"R{" + 
			"res_id = '" + resId + '\'' + 
			"}";
		}
}
