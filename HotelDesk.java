package hotelCom;


import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelDesk {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Manager m = new Manager("a");
		m.generateCutomer();
		m.generateRoomA();

		Manager m2 = new Manager("b");
		m2.generateCutomer();
		m2.generateRoomB();

		Search search = new Search(m);
		Reservation reservation = new Reservation(m);

		SearchB searchB = new SearchB(m2);
		ReservationB reservationB = new ReservationB(m2);
		boolean flag = true;
		while (flag) {
			try {
				for (int i = 0; i < m.lengthOfArrays(); i++) {
					System.out.println("시작하려면 아무 버튼이나 눌러주세요");
					scan.nextLine();
					System.out.println("=================================");
					System.out.println("	어서오세요 자바호텔입니다.");
					System.out.println("	동을 선택해주세요.");
					System.out.println("	1.A동	2.B동");
					System.out.println("=================================");
					// Manager 의 참조 변수 변경 하는 위치.
					int ab = scan.nextInt();
					scan.nextLine();
					if (ab == 2) {
							System.out.println("===============================");
							System.out.println("	B동 정보를 확인합니다.");
							System.out.println("	1.검색   2.예약   3.종료");
							System.out.println("===============================");
	
							int user = scan.nextInt();
							scan.nextLine();
							switch (user) {
							case 1:
								searchB.searchB();
								break;
	
							case 2:
								reservationB.reservation();
								break;
							case 3:
								System.out.println("프로그램을 종료합니다.");
								flag = false;
								break;
							default:
								System.out.println("잘못 입력하셨습니다.");
								break;
							}
						}else if(ab == 1) {
						System.out.println("===============================");
						System.out.println("	A동 정보를 확인합니다.");
						System.out.println("	1.검색   2.예약   3.종료");
						System.out.println("===============================");
	
						int user = scan.nextInt();
						scan.nextLine();
						switch (user) {
						case 1:
							search.search();
							break;
	
						case 2:
							reservation.reservation();
							break;
						case 3:
							System.out.println("프로그램을 종료합니다.");
							flag = false;
							break;
						default:
							System.out.println("잘못 입력하셨습니다.");
							break;
						}
					}
				}
			}
			catch (InputMismatchException String) {
				System.out.println("잘못 입력하셨습니다");
			}
			System.out.println("감사합니다!");
		}
	}
}