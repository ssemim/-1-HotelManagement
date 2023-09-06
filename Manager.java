package hotelCom;


import java.time.LocalDate;

public class Manager {
//	방 배열 생성 메서드 선언
	CurrentRoom[] currentRooms;
	CurrentCustomer[] currentCustomer;
	CurrentRoom currentRoom;
	CurrentCustomer empty = new CurrentCustomer();

// 배열 길이들 초기화	
	   public Manager(String type) {
		      if(type.equals("a")) {
		         currentCustomer = new CurrentCustomer[80];
		         currentRooms = new CurrentRoom[80];
		      }else {
		         currentCustomer = new CurrentCustomer[80];
		         currentRooms = new CurrentRoom[30];
		      }
		   }
// 방배열의 세팅
	   
	   
	public void setCurrentRoom(CurrentRoom[] currentRoom) {
		this.currentRooms = currentRoom;
	}
	
// 손님 배열 세팅
	public void setCurrentCustomer(CurrentCustomer[] currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	
//	null 값 없는 배열
	public void generateCutomer() {
		for (int i = 0; i < currentCustomer.length; i++) {
			currentCustomer[i] = new CurrentCustomer();
		}
	}

	// 방 배열 게터
	public CurrentRoom[] getCurrentRoom() {
		return currentRooms;
	}

// 손님 배열 게터
	public CurrentCustomer[] getCurrentCustomer() {
		return currentCustomer;
	}

// 이름 세팅
	public void setName(int i) {
		this.currentRooms[i].setRoomNum(i);
	}
// 이름 게터
	public String getName(int i) {
		return currentCustomer[i].getName();
	}
	// 방 배열의 해당 인덱스 번호에 방번호를 가져옴
	public int getRoomNum(int i) {
		return currentRooms[i].getRoomNum();
	}
	// 방 배열의 예약 가능 상태를 인덱스 번호로 가져옴
	public boolean isCondition(int i) {
		return currentRooms[i].isCondition();
	}
	// 폰번호 게터
	public String getPhoneNum(int i) {
		return currentCustomer[i].getPhoneNum();
	}
	//인데이 게터
	public int getInDay(int i) {
		return currentCustomer[i].getInDay();
	}
	//인데이 세터
	public void setInDay(int i ,int inDay) {
		 currentCustomer[i].setInDay(inDay);
	}
	// 로컬 데이트를 가져오는 메서드
	public LocalDate getReservationDate(int i) {
		return currentCustomer[i].getReservationDate();
	}
//	//로컬 데이트를 설정하는 메서드
//	public void setReservationDate( i,LocalDate reservationDate) {
//		 currentCustomer[i].setReservationDate(reservationDate);
//	}
	public void setReservationDate(int i,LocalDate reservationDate) {
		 currentCustomer[i].setReservationDate(reservationDate);
	}
	// 인덱스 번호를 통해 가격 정보 가져오기
	public int getPrice(int i) {
		return currentRooms[i].getPrice();
	}
	// 인덱스 번호를 통해 고객에 적혀있는 룸넘버를 반환
	public int getCustomerRoomNum(int i) {
		return currentCustomer[i].getcustomerRoomNum();
	}
	public void setCustomerRoomNum(int i,int csRoomNum) {
		currentCustomer[i].setcustomerRoomNum(csRoomNum);
	}
	// 배열 길이 반환
	public int lengthOfArrays() {
		return currentRooms.length;
	}
	
	
	// 예약기간의 배열을 봔환
	public int lengthOfRoomRev() {
		return currentRoom.arraysOfRoomReserv();
	}

	// 방 번호 싱글룸 가격 방 배열 설정
	public void generateRoomA() {

		int roomNum = 201;
		int price = 10000;
		for (int i = 0; i < currentRooms.length; i++) {
			currentRooms[i] = new CurrentRoom(roomNum, price);
			roomNum++;
			if (roomNum % 100 == 21)
				roomNum += 80;
			if (roomNum % 2 == 0)
				price = 20000;
			else
				price = 10000;
		}
	}
	// b 동 방식의 방 정보 초기화
	   public void generateRoomB() {
		      int roomNum = 101;
		      int price = 10000;
		      int maxRoomNum = 11;
		      for (int i = 0; i < currentRooms.length; i++) {
		         currentRooms[i] = new CurrentRoom(roomNum, price);
		         roomNum++;
		         if(roomNum % 100 == maxRoomNum) 
		            roomNum += (100-maxRoomNum)+1;
		         if(roomNum % 100 > 5)
		            price = 20000;
		         else
		            price = 10000;
		      }
		   }

// 방 번호를 받으면 현재 방의 상태 출력 하는 메서드
	public void getRoomState(int roomNum) {

		for (int i = 0; i < currentRooms.length; i++) {
			if (currentRooms[i].getRoomNum() == roomNum) {
				System.out.println(currentRooms[i].toString());
			}
		}

//		System.out.println("없는 호실입니다"); 유틸리티 함수로 분류가 안됨 수정 사항.
	}


//방 의 전체 상태 출력
	public void printCondition(int roomNum) {

		for (int i = 0; i < currentRooms.length; i++) {
			if (currentRooms[i].getRoomNum() == roomNum) {
				System.out.print(roomNum + "호");
				System.out.print(currentRooms[i].printCondtion() + "\n");

			}
		}
	}

// 이름 입력 받아 손님 배열에 같은 이름을 출력 
	public String getName(String name) {

		for (int i = 0; i < currentCustomer.length; i++) {
			if (currentCustomer[i].getName().equals(name)) {
				return currentCustomer[i].getName();
			}
		}
		return "없는 사람입니다";
	}

// 전화번호를 받아서 비교 하면서 손님 배열의 인덱스를 찾아서 그 인덱스의 손님 상태를 출력
	// 예외처리 필요
	public String getCutomerStateOfPhone(String phoneNum) {

		for (int i = 0; i < currentCustomer.length; i++) {
			if (currentCustomer[i].getPhoneNum().equals(phoneNum)) {
				System.out.printf("["+currentCustomer[i].toString()+"\n예약하신 방 :"+currentRooms[i].getRoomNum()+"]");
			}
		}
		return "없는 사람입니다";
	}
// 이름을 받아서 손님의 상태를 출력하는 메서드
	public void getCustomerStateOfName(String name) {
		for (int i = 0; i < currentCustomer.length; i++) {
			if (currentCustomer[i].getName().equals(name)) {
				System.out.println("["+currentCustomer[i].toString()+"\n예약하신 방 :"+currentRooms[i].getRoomNum()+"]");
			}
		}
	}

// 손님의 이름을 입력 받아 그손님이 현재 배열에 존재하면 방의 체크인 상태를 true로 설정
	public void setCheckin(String name) {
		for (int i = 0; i < currentCustomer.length; i++) {
			if (currentCustomer[i].getName().equals(name)) {
				currentRooms[i].setCheckin(true);
			}
		}
	}

// 똑같이 이름을 입력 받아  그 배열에 같은 이름의 손님의 인덱스 번호를 찾아서 
//	cancel[i] 메서드를 활용해서같은 이름의 손님의 정보를 빈 배열로 변경 후
// canReservation 메서드를 통해서 예약 상태를 가능으로 바꾼다.
	public void setCheckOut(String name) {
		for (int i = 0; i < currentCustomer.length; i++) {
			if (!(currentCustomer[i].getName().equals(name))) {
				currentRooms[i].setCheckin(false);
				cancel(i);
				canReservation(i);
			}
		}
	}
// 밖에서 손님의 정보를 입력받고 손님이 입력한 방번호와 배열의 방번호가 같은지 비교 해서 
//	인덱스 번호를 확인 그후 인덱스와  나머지 정보들을 입력 받아서 
// 손님 배열에 저장
	public void setCustomer(int i, int roomNum, String name, String phoneNum, int inDay,LocalDate reservationDate) {
		currentCustomer[i].setcustomerRoomNum(roomNum);
		currentCustomer[i].setName(name);
		currentCustomer[i].setPhoneNum(phoneNum);
		currentCustomer[i].setInDay(inDay);
		currentCustomer[i].setReservationDate(reservationDate);
	}
// 해당 인덱스 번호에 있는 손님 배열 원소를 비어있는 상태로 만들기
	public void cancel(int i) {
		currentCustomer[i] = empty;
	}
//  방 객체에 있는 예약 가능 상태를  true 로 변경
	public void canReservation(int i) {
		currentRooms[i].setCondition(true);
	}
// 방 객체에 있는 예약 가능 상태를 false 로 변경
	public void cantReservation(int i) {
		currentRooms[i].setCondition(false);
	}
	// 지내는 날짜 와 가격을 입력받음
	public int getPayment(int inDay,int price) {
		return inDay*price;
	}
	//잘못 입력했을경우 반환
	public String mistake() {
		return " 잘못 입력하셨습니다";
	}

//	public boolean indexRoomNum(int roomNum) {
//		if (501 <= roomNum && 520 >= roomNum) {
//			if (401 <= roomNum && 420 >= roomNum) {
//				if (301 <= roomNum && 320 >= roomNum) {
//					if (201 <= roomNum && 220 >= roomNum) {
//						return true;
//					}
//			}
//			}
//		}
//		return false;
//	}
}

/*
 * 예약 가능 불가능 만 확인 할 수있는 메서드 "O" "X"
 */
