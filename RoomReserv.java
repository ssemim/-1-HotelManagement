package hotelCom;

//	추가한 파일
import java.time.LocalDate;

public class RoomReserv {
	LocalDate RoomDate;
	int inDay;
	
	public RoomReserv() {
		super();
		RoomDate = LocalDate.parse("0000-01-01");
		this.inDay = 0;
	}

	public LocalDate getRoomDate() {
		return RoomDate;
	}


	public void setRoomDate(LocalDate roomDate) {
		RoomDate = roomDate;
	}

	public int getInDay() {
		return inDay;
	}

	public void setInDay(int inDay) {
		this.inDay = inDay;
	}
	
	
}
