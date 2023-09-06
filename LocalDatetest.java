package hotelCom;


import java.time.LocalDate;

public class LocalDatetest {
	public static void main(String[] args) {
		int month = 5;
		int dayOfMonth = 26;
		int inDay = 5;
		
		LocalDate reservationDate = LocalDate.of(2023, month, dayOfMonth);
		LocalDate reservationDateEnd = LocalDate.of(2023, month, dayOfMonth+inDay);
	System.out.println(reservationDate);
	System.out.println(reservationDateEnd);
	}

}
