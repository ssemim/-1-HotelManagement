package hotelCom;



import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reservation {
	Manager m;
	Scanner scan = new Scanner(System.in);

	public Reservation(Manager m) {
		this.m = m;
	}

//	}
	
	public void reserRoom(int roomNum, String name, String phoneNum, int inDay, LocalDate reservDate) {

//		예약가능 true상태
		int k = 0;
		

		LocalDate customerReservDate = reservDate;
		LocalDate customerPlusinDay = customerReservDate.plusDays(inDay);
		int j = 0;
		LocalDate cant = LocalDate.parse("0000-01-01");
		LocalDate roomPlusinDay;
		boolean flag = true;
		
		for (int i = 0; i < m.lengthOfArrays(); i++) {
			if(m.getRoomNum(i) == roomNum)
				j = i;
		}
		
		for (int i = 0; i < 10; i++) {
			if(!(m.currentRooms[j].getRoomDate(i).isEqual(cant))) {
				roomPlusinDay = m.currentRooms[j].getRoomDate(i).plusDays(m.currentRooms[1].getInDay(1));
				if(!(m.currentRooms[1].getRoomDate(i).isAfter(customerPlusinDay)
					&& roomPlusinDay.isBefore(customerReservDate)))
					flag = false;
			}
		}
		
		
		for (int i = 0; i < m.lengthOfArrays(); i++) {
			k++;
			if (m.getRoomNum(i) == roomNum && m.isCondition(i) == true && flag) {
				m.cantReservation(i);
				m.setCustomer(i, roomNum, name, phoneNum, inDay, reservDate);
				int price = m.getPayment(inDay, m.getPrice(i));
				System.out.println(price + "원 입니다");
				System.out.println("예약되었습니다.");
				break;
			}
		}
		if (k == 80)
			System.out.println("예약이 불가능한 방입니다.");
	}
	
	public void check2(int i) {
		System.out.println(m.getCustomerRoomNum(i));
		System.out.println(m.getName(i));
		System.out.println(m.getPhoneNum(i));
		System.out.println(m.getInDay(i));
	}
	public int dateOfStay(int date) {
		int dateOfStay = date;
		return dateOfStay;
	}
	public void ReservationCancellation(String customerName) {
		int k = 0;
		int n = 0;
		int n2 = 0;
		boolean flag = false;
		LocalDate reset = LocalDate.parse("0000-01-01");
		
		String c = customerName;
		for (int i = 0; i < m.lengthOfArrays(); i++) {
			k++;
			if (m.getName(i).equals(c)) {
				for (int j = 0; j < m.lengthOfArrays(); j++) {
					if (m.getRoomNum(j) == m.getCustomerRoomNum(i)) {
						m.cancel(i);
						m.canReservation(i);
						m.setCustomerRoomNum(j, 0);
						n = j;
						System.out.println("예약취소되었습니다.");
						k--;
						flag = true;
						break;
					}
				}
			}
		}
		if (k == 80)
			System.out.println("예약명단에 없습니다.");
		int a = 0;
		LocalDate customerDate = m.currentCustomer[a].getReservationDate();
		for(int i = 0; i < m.currentCustomer.length; i++) {
			if(m.currentCustomer[i].getName().equals(c))
				a = i;
		}
		
		
		
		if(flag) {
			for (int j = 0; j < 10 ; j++) {
				if(m.currentRooms[n].getRoomDate(j).isEqual(customerDate)) {
					m.currentRooms[n].setRoomDate(reset, j);
				}
			}
		}
	}
	
	public void checkin(String checkInName) { // 체크인
		m.setCheckin(checkInName);
		System.out.println("체크인 되었습니다.");

	}
	public void checkout(String checkOutName) { // 체크아웃
		m.setCheckOut(checkOutName);
		for (int i = 0; i < m.lengthOfArrays(); i++) {
			if (m.getName(checkOutName).equals(checkOutName)) {
				m.cancel(i);
			}
		}
		System.out.println("체크아웃 되었습니다.");
	}
	public void reservation() {
		boolean a = true;
		
		while (a) {
			System.out.println("=================================");
			System.out.println("	예약 메인창을 띄웁니다.");
			System.out.println("=================================");
			System.out.println("처음으로 돌아가시려면 1~4 외의 번호를 눌러주세요.");
			System.out.println("1.예약하기  2.예약취소  3.체크인  4.체크아웃");
			System.out.println("=================================");
			int res = scan.nextInt();
			switch (res) {
			case 1: {// 예약 메소드}
				System.out.println("=================================");
				System.out.println("예약하실 방 호수을 입력해주세요.");

				System.out.println("2-5층 / 1-20호");
				System.out.println("=================================");
				int room1 = scan.nextInt();
				System.out.println("=================================");
				System.out.println("예약하실 달 과 일자를 입력해주세요");
				System.out.println("=================================");
				int month =scan.nextInt();
				int day = scan.nextInt();
				LocalDate reservationDate =LocalDate.of(2023, month, day);
				System.out.println("=================================");
				System.out.println("예약하실 분의 이름,전화번호를 입력해주세요.");
				System.out.println("ex) 홍길동, 010-0000-0000 ");
				System.out.println("=================================");
				scan.nextLine();
				String name = scan.nextLine();
				String phoneNum = scan.nextLine();
				System.out.println("=================================");
				System.out.println("사용 기간을 입력하세요.");
				System.out.println("=================================");
				int inDay = scan.nextInt();
				reserRoom(room1, name, phoneNum,inDay,reservationDate);

				System.out.println("다른 업무를 보시겠습니까? 1.예   2.아니요");
				System.out.println("=================================");
				scan.nextLine();
				int out = scan.nextInt();
				if (out == 2) {
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				break;
			}
			case 2: {
				// 예약 취소

				System.out.println("=================================");
				System.out.println("예약취소창을 띄웁니다.");
				System.out.println("예약자 명을 입력해주세요");
				System.out.println("=================================");
				scan.nextLine();
				String customerName = scan.nextLine();
				ReservationCancellation(customerName);

				System.out.println("다른 업무를 보시겠습니까? 1.예   2.아니요");
				int out = scan.nextInt();

				if (out == 2) {
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				break;

			}
			case 3: {
				System.out.println("=================================");
				System.out.println("체크인하실 고객명을 입력해주세요");
				System.out.println("=================================");
				scan.nextLine();
				String checkInName = scan.nextLine();
				checkin(checkInName);

				System.out.println("다른 업무를 보시겠습니까? 1.예   2.아니요");
				int out = scan.nextInt();

				if (out == 2) {
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				break;
			}
			case 4: {
				System.out.println("===============================");
				System.out.println("체크아웃하실 고객명을 입력해주세요");
				System.out.println("===============================");
				String checkOutName = scan.nextLine();
				scan.nextLine();
				checkout(checkOutName);
				System.out.println("다른 업무를 보시겠습니까? 1.예   2.아니요");
				int out = scan.nextInt();

				if (out == 2) {
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				break;
			}
			default: {
				if (res > 4) {
					System.out.println("예약 프로그램을 종료합니다.");
					return;
					}
				}
			}
		}
	}
}
