package hotelCom;
 


import java.time.LocalDate;

public class CurrentCustomer extends Customer {

	private LocalDate reservationDate;
	private int inDay;
	private int customerRoomNum;

	public CurrentCustomer(String name, String phoneNum, int inDay,int customerRoomNum, String reservDate) {
		super(name, phoneNum, 0);
		this.inDay = inDay;
		this.customerRoomNum = customerRoomNum;
		reservationDate = LocalDate.parse(reservDate);
	}
	
	public CurrentCustomer() {
		super("","",0);
		this.inDay = 0;
		this.customerRoomNum = 0;
		reservationDate = LocalDate.parse("0000-01-01");
	}

	public int getcustomerRoomNum() {
		return customerRoomNum;
	}

	public void setcustomerRoomNum(int roomNum) {
		this.customerRoomNum = roomNum;
	}

	public int getInDay() {
		return inDay;
	}

	public void setInDay(int inDay) {
		this.inDay = inDay;
	}
	@Override
	public String getName() {
		return super.getName();
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public String toString() {
		return	" 성함 :"+getName()+" \n전화번호 : "+getPhoneNum();
	}
	

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

}
