package hotelCom;


import java.time.LocalDate;

public class CurrentRoom extends Room {
	
	private RoomReserv[] roomReserv;
	private boolean condition;
	private boolean checkin;

	// 예약 true 예약 가능 false 불가능
	// 체크인 true 체크인 한 상태   false 체크 아웃.
	public CurrentRoom(int roomNum, int price) {
		super(roomNum, price);
		this.condition = true;
		this.checkin = false;
		roomReserv = new RoomReserv[10];
		for (int i = 0; i < roomReserv.length; i++) {
			roomReserv[i] = new RoomReserv();
		}
	}
	
	
	@Override
	public String toString() {
		return "[방번호:"+getRoomNum()+"방가격:"+getPrice()+"예약 상태"+printCondtion()+"체크인상태"+printcheckIn()+"]";
	}
	public String printCondtion() {
		if(condition) {
			return " 예약 가능 ";
		}
		return "예약 불가능";
	}
	
	public String printcheckIn() {
		if(checkin) {
			return " 체크인 ";
		}
		return " 체크 아웃 ";
	}

	public boolean isCondition() {
		return condition;
	}

	public boolean setCondition(boolean condition) {
		return this.condition = condition;
	}

	public boolean isCheckin() {
		return checkin;
	}
	
	

	public RoomReserv[] getRoomReserv() {
		return roomReserv;
	}
	public int arraysOfRoomReserv() {
		return roomReserv.length;
	}

	public void setRoomReserv(RoomReserv[] roomReserv) {
		this.roomReserv = roomReserv;
	}


	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}
	public LocalDate getRoomDate(int i) {
		return roomReserv[i].getRoomDate();
	}

	public void setRoomDate(LocalDate roomDate, int i) {
		roomReserv[i].setRoomDate(roomDate);
	}

	public int getInDay(int i) {
		return roomReserv[i].getInDay();
	}

	public void setInDay(int inDay, int i) {
		roomReserv[i].setInDay(inDay);
	}	
}
