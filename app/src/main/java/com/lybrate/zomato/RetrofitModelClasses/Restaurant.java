package com.lybrate.zomato.RetrofitModelClasses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Restaurant{
	private boolean includeBogoOffers;
	private int hasOnlineDelivery;
	private List<Object> establishmentTypes;
	private int hasTableBooking;
	private String thumb;
	@SerializedName ( "average_cost_for_two" )
	private int averageCostForTwo;
	private String menuUrl;
	private int priceRange;
	private String orderDeeplink;
	private int switchToOrderMenu;
	private List<PhotosItem> photos;
	private String orderUrl;
	private R R;
	private int allReviewsCount;
	private int isTableReservationSupported;
	private String timings;
	private String currency;
	private int opentableSupport;
	private String id;
	private AllReviews allReviews;
	@SerializedName ( "user_rating" )
	private UserRating userRating;
	private List<Object> offers;
	private String apikey;
	private int isDeliveringNow;
	private String deeplink;
	private int isZomatoBookRes;
	private List<String> establishment;
	private String featuredImage;
	private String url;
	private String cuisines;
	private String phoneNumbers;
	private int photoCount;
	private List<String> highlights;
	private String eventsUrl;
	private String name;
	private Location location;
	private String bookAgainUrl;
	private int isBookFormWebView;
	private String bookFormWebViewUrl;
	private String mezzoProvider;
	private String photosUrl;

	public void setIncludeBogoOffers(boolean includeBogoOffers){
		this.includeBogoOffers = includeBogoOffers;
	}

	public boolean isIncludeBogoOffers(){
		return includeBogoOffers;
	}

	public void setHasOnlineDelivery(int hasOnlineDelivery){
		this.hasOnlineDelivery = hasOnlineDelivery;
	}

	public int getHasOnlineDelivery(){
		return hasOnlineDelivery;
	}

	public void setEstablishmentTypes(List<Object> establishmentTypes){
		this.establishmentTypes = establishmentTypes;
	}

	public List<Object> getEstablishmentTypes(){
		return establishmentTypes;
	}

	public void setHasTableBooking(int hasTableBooking){
		this.hasTableBooking = hasTableBooking;
	}

	public int getHasTableBooking(){
		return hasTableBooking;
	}

	public void setThumb(String thumb){
		this.thumb = thumb;
	}

	public String getThumb(){
		return thumb;
	}

	public void setAverageCostForTwo(int averageCostForTwo){
		this.averageCostForTwo = averageCostForTwo;
	}

	public int getAverageCostForTwo(){
		return averageCostForTwo;
	}

	public void setMenuUrl(String menuUrl){
		this.menuUrl = menuUrl;
	}

	public String getMenuUrl(){
		return menuUrl;
	}

	public void setPriceRange(int priceRange){
		this.priceRange = priceRange;
	}

	public int getPriceRange(){
		return priceRange;
	}

	public void setOrderDeeplink(String orderDeeplink){
		this.orderDeeplink = orderDeeplink;
	}

	public String getOrderDeeplink(){
		return orderDeeplink;
	}

	public void setSwitchToOrderMenu(int switchToOrderMenu){
		this.switchToOrderMenu = switchToOrderMenu;
	}

	public int getSwitchToOrderMenu(){
		return switchToOrderMenu;
	}

	public void setPhotos(List<PhotosItem> photos){
		this.photos = photos;
	}

	public List<PhotosItem> getPhotos(){
		return photos;
	}

	public void setOrderUrl(String orderUrl){
		this.orderUrl = orderUrl;
	}

	public String getOrderUrl(){
		return orderUrl;
	}

	public void setR(R R){
		this.R = R;
	}

	public R getR(){
		return R;
	}

	public void setAllReviewsCount(int allReviewsCount){
		this.allReviewsCount = allReviewsCount;
	}

	public int getAllReviewsCount(){
		return allReviewsCount;
	}

	public void setIsTableReservationSupported(int isTableReservationSupported){
		this.isTableReservationSupported = isTableReservationSupported;
	}

	public int getIsTableReservationSupported(){
		return isTableReservationSupported;
	}

	public void setTimings(String timings){
		this.timings = timings;
	}

	public String getTimings(){
		return timings;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setOpentableSupport(int opentableSupport){
		this.opentableSupport = opentableSupport;
	}

	public int getOpentableSupport(){
		return opentableSupport;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setAllReviews(AllReviews allReviews){
		this.allReviews = allReviews;
	}

	public AllReviews getAllReviews(){
		return allReviews;
	}

	public void setUserRating(UserRating userRating){
		this.userRating = userRating;
	}

	public UserRating getUserRating(){
		return userRating;
	}

	public void setOffers(List<Object> offers){
		this.offers = offers;
	}

	public List<Object> getOffers(){
		return offers;
	}

	public void setApikey(String apikey){
		this.apikey = apikey;
	}

	public String getApikey(){
		return apikey;
	}

	public void setIsDeliveringNow(int isDeliveringNow){
		this.isDeliveringNow = isDeliveringNow;
	}

	public int getIsDeliveringNow(){
		return isDeliveringNow;
	}

	public void setDeeplink(String deeplink){
		this.deeplink = deeplink;
	}

	public String getDeeplink(){
		return deeplink;
	}

	public void setIsZomatoBookRes(int isZomatoBookRes){
		this.isZomatoBookRes = isZomatoBookRes;
	}

	public int getIsZomatoBookRes(){
		return isZomatoBookRes;
	}

	public void setEstablishment(List<String> establishment){
		this.establishment = establishment;
	}

	public List<String> getEstablishment(){
		return establishment;
	}

	public void setFeaturedImage(String featuredImage){
		this.featuredImage = featuredImage;
	}

	public String getFeaturedImage(){
		return featuredImage;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setCuisines(String cuisines){
		this.cuisines = cuisines;
	}

	public String getCuisines(){
		return cuisines;
	}

	public void setPhoneNumbers(String phoneNumbers){
		this.phoneNumbers = phoneNumbers;
	}

	public String getPhoneNumbers(){
		return phoneNumbers;
	}

	public void setPhotoCount(int photoCount){
		this.photoCount = photoCount;
	}

	public int getPhotoCount(){
		return photoCount;
	}

	public void setHighlights(List<String> highlights){
		this.highlights = highlights;
	}

	public List<String> getHighlights(){
		return highlights;
	}

	public void setEventsUrl(String eventsUrl){
		this.eventsUrl = eventsUrl;
	}

	public String getEventsUrl(){
		return eventsUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setBookAgainUrl(String bookAgainUrl){
		this.bookAgainUrl = bookAgainUrl;
	}

	public String getBookAgainUrl(){
		return bookAgainUrl;
	}

	public void setIsBookFormWebView(int isBookFormWebView){
		this.isBookFormWebView = isBookFormWebView;
	}

	public int getIsBookFormWebView(){
		return isBookFormWebView;
	}

	public void setBookFormWebViewUrl(String bookFormWebViewUrl){
		this.bookFormWebViewUrl = bookFormWebViewUrl;
	}

	public String getBookFormWebViewUrl(){
		return bookFormWebViewUrl;
	}

	public void setMezzoProvider(String mezzoProvider){
		this.mezzoProvider = mezzoProvider;
	}

	public String getMezzoProvider(){
		return mezzoProvider;
	}

	public void setPhotosUrl(String photosUrl){
		this.photosUrl = photosUrl;
	}

	public String getPhotosUrl(){
		return photosUrl;
	}

	@Override
 	public String toString(){
		return 
			"Restaurant{" + 
			"include_bogo_offers = '" + includeBogoOffers + '\'' + 
			",has_online_delivery = '" + hasOnlineDelivery + '\'' + 
			",establishment_types = '" + establishmentTypes + '\'' + 
			",has_table_booking = '" + hasTableBooking + '\'' + 
			",thumb = '" + thumb + '\'' + 
			",average_cost_for_two = '" + averageCostForTwo + '\'' + 
			",menu_url = '" + menuUrl + '\'' + 
			",price_range = '" + priceRange + '\'' + 
			",order_deeplink = '" + orderDeeplink + '\'' + 
			",switch_to_order_menu = '" + switchToOrderMenu + '\'' + 
			",photos = '" + photos + '\'' + 
			",order_url = '" + orderUrl + '\'' + 
			",R = '" + R + '\'' + 
			",all_reviews_count = '" + allReviewsCount + '\'' + 
			",is_table_reservation_supported = '" + isTableReservationSupported + '\'' + 
			",timings = '" + timings + '\'' + 
			",currency = '" + currency + '\'' + 
			",opentable_support = '" + opentableSupport + '\'' + 
			",id = '" + id + '\'' + 
			",all_reviews = '" + allReviews + '\'' + 
			",user_rating = '" + userRating + '\'' + 
			",offers = '" + offers + '\'' + 
			",apikey = '" + apikey + '\'' + 
			",is_delivering_now = '" + isDeliveringNow + '\'' + 
			",deeplink = '" + deeplink + '\'' + 
			",is_zomato_book_res = '" + isZomatoBookRes + '\'' + 
			",establishment = '" + establishment + '\'' + 
			",featured_image = '" + featuredImage + '\'' + 
			",url = '" + url + '\'' + 
			",cuisines = '" + cuisines + '\'' + 
			",phone_numbers = '" + phoneNumbers + '\'' + 
			",photo_count = '" + photoCount + '\'' + 
			",highlights = '" + highlights + '\'' + 
			",events_url = '" + eventsUrl + '\'' + 
			",name = '" + name + '\'' + 
			",location = '" + location + '\'' + 
			",book_again_url = '" + bookAgainUrl + '\'' + 
			",is_book_form_web_view = '" + isBookFormWebView + '\'' + 
			",book_form_web_view_url = '" + bookFormWebViewUrl + '\'' + 
			",mezzo_provider = '" + mezzoProvider + '\'' + 
			",photos_url = '" + photosUrl + '\'' + 
			"}";
		}
}