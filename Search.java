package hotelCom;



import java.util.Scanner;
import java.util.Arrays;

public class Search {
	Manager m;
	Scanner scan = new Scanner(System.in);

	public Search(Manager m) {
		this.m = m;
	}

	public void search() {
		searchMain();
	}
	// 서치 창 안에서의 메인창 생성(1,2,3번으로 고객검색/방 검색/ 방 현황 나타내기 세가지)
	// 1. 고객검색 (문자열 검색/ 이름검색/ 폰번호 검색/ 등급 검색(이건 추후에 추가))
	// 2. 방 검색(방 호실 검색, 예약 가능여부 검색)
	// 3. 방 현황 전체보기로 나타내기

	public void searchMain() {

		System.out.println("============= 검색 =============");
		System.out.println("-검색 기능을 선택하세요-");
		System.out.println("1. 고객 정보 검색");
		System.out.println("2. 방 정보 검색");
		System.out.println("3. 방 현황 살펴보기");
		System.out.println("4. 종료");
		System.out.println("=============================");

		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		scan.nextLine();
		boolean power = true;
		while (power) {
			switch (choice) {
			case 1:
				System.out.println("=======고객 정보 검색=======");
				searchCustomer();
				break;
			case 2:
				System.out.println("=======방 정보 검색=======");
				searchRoom();
				break;
			case 3:
				System.out.println("=======방 현황 살펴보기=======");
				searchRoomstatus();
				break;
			case 4:
				power = false;
				break;

			default:
				System.out.println("이전 화면으로 돌아갑니다.");

			}
			return;
		}
	}

	public void searchCustomer() { // 문자열 검색 기능

		Scanner scan = new Scanner(System.in);

		System.out.println("=======고객 검색 기능=======");
		System.out.println("1. 성명으로 검색");
		System.out.println("2. 휴대폰 번호로 검색");
		System.out.println("3. 나가기");
		System.out.println("======================");
		int choice = scan.nextInt();
		scan.nextLine();
		while (true) {
			switch (choice) {
			case 1:
				System.out.println("===성명으로 검색===");

				searchString();
				break;
				
				
			case 2:
				System.out.println("===휴대폰 번호로 검색===");

				searchString2();
				break;

			case 3:
				System.out.println("이전 화면으로 돌아갑니다.");
				// 이전 화면으로 돌아가기
				searchMain();
				break;

			default:
				System.out.println("잘못된 번호 입력");
				break;
			// 만약 객체 안에 정보가 같이 있을 경우 하나로 합쳐서 사용할 수 있음(지금 그냥 임시적으로 분리시켜둔거)
			}
			break;
		}
		return;
	}
	public void searchString() {// 고객 검색 기능 안에서 쓰는 문자열 검색 기능

		System.out.println("===== 검색할 내용을 입력하세요. =====");
		String line = scan.next();
		if(m.getName(line).equals(line)) {
		m.getCustomerStateOfName(line);
		}else {
		System.out.println("없는 고객님 입니다.");
		}
	}
	public void searchString2() {// 고객 검색 기능 안에서 쓰는 문자열 검색 기능

		System.out.println("===검색할 내용을 입력하세요[휴대폰 번호].===");
		String line = scan.next();
		m.getCutomerStateOfPhone(line);
	}
	public void searchRoom() {// 방 검색 기능
		System.out.println("=== 검색할 호수를 입력하세요.===");
		int roomNum = scan.nextInt();
		scan.nextLine();
		m.getRoomState(roomNum);
		System.out.println("이전 화면으로 돌아가려면 1을 눌러주세요");
		int stop = scan.nextInt();
		scan.nextLine();
		if (stop == 1) {
			searchMain();
		}
		return;
}
	public void searchRoomstatus() { // 방 현황 출력 기능(예약중/사용중/빈 방)

		// for 문으로 부울값 판별/ true면 O 출력 / false면 X 출력
		// O 일때 선택, 예약 가능
		// 2층에서 5층 사이 선택할 수 있도록 선택 옵션 넣을 것

		System.out.println("=======층수를 선택하세요 =======");
		System.out.println("1. 2층 ");
		System.out.println("2. 3층");
		System.out.println("3. 4층");
		System.out.println("4. 5층");
		System.out.println("5. 종료");
		System.out.println("==========================");

//		searchOutRoomstatus();

		return;

	}
	public void searchOutRoomstatus() { // 방 상태 출력 기능
		int floor = scan.nextInt();
		scan.nextLine();
		int caculateFloor = floor + 1;
		if (floor != 5) {
			for (int i = 0; i < m.lengthOfArrays(); i++) {
				if (((m.getRoomNum(i)) / 100) == caculateFloor) {
					m.printCondition(m.getRoomNum(i));
				}
			}
		} else {
			System.out.println("메인으로 돌아갑니다.");
			searchMain();
			return;

		}
	}
	public boolean indexRoomNum(int roomNum) {
		if (501 <= roomNum && 520 >= roomNum) {
			if (401 <= roomNum && 420 >= roomNum) {
				if (301 <= roomNum && 320 >= roomNum) {
					if (201 <= roomNum && 220 >= roomNum) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
// searchRoomAvailable() {// 방의 현황(절대값 말고 상대값을 받아오는 메소드

// a.printCondition(int roomNum)

// 방 호수 출력(201~219),(301~319)---- (501~519)


//	}
