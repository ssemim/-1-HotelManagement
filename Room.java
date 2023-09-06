package hotelCom;




public class Room {
    private int roomNum;
    private int price;
	
    
    public Room(int roomNum, int price) {
		super();
		this.roomNum = roomNum;
		this.price = price;
	}
	public int getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}


}
