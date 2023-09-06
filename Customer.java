package hotelCom;


public class Customer {
    private String name;
    private String phoneNum;
    private int rating;
	public Customer(String name, String phoneNum, int rating) {
		super();
		this.name = name;
		this.phoneNum = phoneNum;
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}

}
