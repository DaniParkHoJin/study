package com.market.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.market.bookitem.Book;
import com.market.cart.Cart;
import com.market.cart.CartItem;
import com.market.exception.CartException;
import com.market.member.Admin;
import com.market.member.Customer;
import com.market.member.User;

public class WelcomeBookMarket {
	static final int NUM_BOOK = 3; // 도서 개수
	static final int NUM_ITEM = 8; // 도서 정보의 개수
	// static CartItem[] cartItem = new CartItem[NUM_BOOK]; // 장바구니
	// static int cartCount = 0; // 장바구니 목록 개수
	static Cart cart = new Cart();
	static User user; // 사용자

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userName; // 고객 이름
		String userMobile; // 연락처
		int numberSelection; // 메뉴 번호 선택

		Book[] bookInfoList = new Book[NUM_BOOK];
		// String[][] bookInfoList = new String[NUM_BOOK][NUM_ITEM]; // 도서 정보 목록 배열
		System.out.println("Book Market 고객 정보 입력");
		System.out.print("고객의 이름을 입력하세요 : ");
		userName = input.nextLine();
		System.out.print("연락처를 입력하세요 : ");
		userMobile = input.nextLine();

		// 사용자 정보 저장
		user = new User(userName, userMobile);

		boolean quit = false; // 무한 반복

		while (!quit) {
			menuIntroduction();

			try {
				System.out.print("메뉴 번호를 선택해주세요 : ");
				numberSelection = input.nextInt();
				if (numberSelection < 1 || numberSelection > 8) {
					System.out.println("1부터 8까지의 숫자를 입력하세요.");
				} else {
					switch (numberSelection) {
					case 1:
						// System.out.println("현재 고객 정보");
						menuGuestInfo(userName, userMobile);
						break;
					case 2:
						// System.out.println("2. 장바구니 상품 목록 보기 :");
						menuCartItemList();
						break;
					case 3:
						// System.out.println("3. 장바구니 비우기");menuCartClear();
						break;
					case 4:
						// System.out.println("4. 장바구니에 항목 추가하기 : ");
						// menuCartAddItem(bookInfoList);
						menuCartAddItem(bookInfoList);
						break;
					case 5:
						// System.out.println("5. 장바구니의 항목 수량 줄이기");
						menuCartRemoveItemCount();
						break;
					case 6:
						// System.out.println("6. 장바구니의 항목 삭제하기");
						menuCartRemoveItem();
						break;
					case 7:
						// System.out.println("7. 영수증 표시하기");
						menuCartBill();
						break;
					case 8:
						// System.out.println("8. 종료");
						menuExit();
						quit = true; // 종료
						break;
					case 9:
						// 관리자 로그인 정보 확인 메서드 호출
						menuAdminLogin();
						quit = true; // 종료
						break;
					}
				}
			} catch (CartException e) {
				System.out.println(e.getMessage());
				quit = true;
			} catch (Exception e) {
				System.out.println("잘못된 메뉴 선택으로 종료합니다.");
				quit = true;
			}

		}
	}

	public static void menuIntroduction() {
		System.out.println("***************************************************");
		System.out.println("\t\t" + "Book Market Menu");
		System.out.println("***************************************************");
		System.out.println(" 1. 고객 정보 확인하기 \t4. 장바구니에 항목 추가하기");
		System.out.println(" 2. 장바구니 상품 목록 보기\t5. 장바구니의 항목 수량 줄이기");
		System.out.println(" 3. 장바구니 비우기 \t\t6. 장바구니의 항목 삭제하기");
		System.out.println(" 7. 영수증 표시하기 \t\t8. 종료");
		System.out.println(" 9. 관리자 로그인");

		System.out.println("***************************************************");
	}

	public static void menuGuestInfo(String name, String mobile) {
		System.out.println("현재 고객 정보 : ");
		// System.out.println("이름 : " + name + ", 연락처 : " + mobile);
		// Customer customer = new Customer(name, mobile);
		System.out.println("이름 : " + user.getName() + ", 연락처 : " + user.getPhone());
	}

	public static void menuCartItemList() {
//		System.out.println("장바구니 상품 목록 :");
//		System.out.println("---------------------------------------------");
//		System.out.println(" 도서ID \t| 수량 \t| 합계");
//		for (int i = 0; i < cartCount; i++) {
//			System.out.print(" " + cartItem[i].getBookID() + " \t| ");
//			System.out.print(" " + cartItem[i].getQuantity() + " \t| ");
//			System.out.print(" " + cartItem[i].getTotalPrice());
//			System.out.println(" ");
//		}
//		System.out.println("---------------------------------------------");
		if (cart.cartCount >= 0) {
			cart.printCart();
		}

	}

	public static void menuCartClear() throws CartException {
		// System.out.println("장바구니 비우기");
		if (cart.cartCount == 0) {
			//System.out.println("장바구니에 항목이 없습니다");
			throw new CartException("장바구니에 항목이 없습니다.");
		} else {
			System.out.println("장바구니에 모든 항목을 삭제하겠습니까? Y | N ");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			if (str.toUpperCase().equals("Y") || str.toLowerCase().equals("y")) {
				System.out.println("장바구니에 모든 항목을 삭제했습니다");
				cart.deleteBook();
			}
		}
	}

	public static void menuCartAddItem(Book[] book) {
		// System.out.println("장바구니에 항목 추가하기 : ");

		bookList(book); // 도서 정보가 저장되어 있는 메서드 호출
		/*
		 * // 도서 정보 출력 for (int i = 0; i < NUM_BOOK; i++) { for (int j = 0; j <
		 * NUM_ITEM; j++) System.out.print(book[i][j] + " | "); System.out.println("");
		 * }
		 */

		cart.printBookList(book);
		boolean quit = false;
		while (!quit) {
			Scanner input = new Scanner(System.in);
			System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 :");
			String inputStr = input.nextLine();
			boolean flag = false; // 일치 여부
			int numId = -1; // 인덱스 번호
			for (int i = 0; i < NUM_BOOK; i++) {
				// 입력한 도서ID와 저장되어 이쓴 도서 정보의 ID가 일치하면
				// 인덱스 번호와 일치 여부 변수의 값을 변경한다.
				if (inputStr.equals(book[i].getBookId())) {
					numId = i;
					flag = true;
					break;
				}
			}
			// 일치하면 장바구니 추가 여부를 묻는다.
			if (flag) {
				System.out.println("장바구니에 추가하겠습니까? Y | N ");
				inputStr = input.nextLine();
				if (inputStr.toUpperCase().equals("Y") || inputStr.toLowerCase().equals("y")) {
					System.out.println(book[numId].getBookId() + " 도서가 장바구니에 추가되었습니다.");
					// 장바구니에 넣기
					if (!isCartInBook(book[numId].getBookId())) {
						// cartItem[cartCount++] = new CartItem(book[numId]);
						cart.insertBook(book[numId]);
					}
				}
				quit = true;
			} else {
				System.out.println("다시 입력해 주세요");
			}
		}
	}

	public static void menuCartRemoveItemCount() {
		System.out.println("5. 장바구니의 항목 수량 줄이기");
	}

	public static void menuCartRemoveItem() throws CartException {
		// System.out.println("6. 장바구니의 항목 삭제하기");
		if (cart.cartCount == 0) {
			//System.out.println("장바구니에 항목이 없습니다");
			throw new CartException("장바구니에 항목이 없습니다.");
		} else {
			menuCartItemList();
			boolean quit = false;
			while (!quit) {
				System.out.print("장바구니에서 삭제할 도서의 ID를 입력하세요 :");
				Scanner input = new Scanner(System.in);
				String str = input.nextLine();
				boolean flag = false;
				int numId = -1;
				for (int i = 0; i < cart.cartCount; i++) {
					if (str.equals(cart.cartItem[i].getBookID())) {
						numId = i;
						flag = true;
						break;
					}
				}
				if (flag) {
					System.out.println("장바구니의 항목을 삭제하겠습니까? Y | N ");
					str = input.nextLine();
					if (str.toUpperCase().equals("Y") || str.toLowerCase().equals("y")) {
						System.out.println(cart.cartItem[numId].getBookID() + "장바구니에서 도서가 삭제되었습니다.");
						cart.removeCart(numId);
					}
					quit = true;
				} else {
					System.out.println("다시 입력해 주세요");
				}
			}
		}

	}
	// 주문처리
	public static void menuCartBill() throws CartException {
		// System.out.println("7. 영수증 표시하기");
		if (cart.cartCount == 0) {
			//System.out.println("장바구니에 항목이 없습니다.");
			throw new CartException("장바구니에 항목이 없습니다.");
		} else {
			System.out.println("배송받을 분의 고객정보와 같습니까? Y | N");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();

			if (str.toUpperCase().equals("Y") || str.toLowerCase().equals("y")) {
				System.out.print("배송지를 입력해주세요. ");
				String address = input.nextLine();
				// 주문 처리 후 영수증 출력 메서드 호출
				printBill(user.getName(), String.valueOf(user.getPhone()), address);
			} else {
				System.out.print("배송받을 고객명을 입력하세요 ");
				String name = input.nextLine();

				System.out.println("배송받을 고객이 연락처를 입력하세요 ");
				String phone = input.nextLine();
				System.out.println("배송받을 고객의 배송지를 입력해주세요 ");
				String address = input.nextLine();
				// 주문 처리 후 영수증 출력 메서드호출
				printBill(name, phone, address);

			}

		}
	}

	public static void menuExit() {
		System.out.println("8. 종료");
	}

	public static void bookList(Book[] book) {
		book[0] = new Book("book1", "ISBN 978-89-01-26726-5", "빅 히스토리", 33000);
		book[0].setAuthor("데이비드 크리스천");
		book[0].setDescription("우주와 지구, 인간을 하나로 잇는 새로운 역사");
		book[0].setCategory("인문 교양");
		book[0].setReleaseDate("2022/12/23");
		book[1] = new Book("book2", "ISBN 979-11-6921-062-1", "SICP", 45000);
		book[1].setAuthor("해럴드 에이블슨, 류광");
		book[1].setDescription("컴퓨터 프로그래밍의 구조와 해석");
		book[1].setCategory("개발 방법론");
		book[1].setReleaseDate("2022/12/30");
		book[2] = new Book("book3", "ISBN 978-89-6626-366-0", "러스트 프로그래밍", 35000);
		book[2].setAuthor("팀 맥나마라, 장연호");
		book[2].setDescription("러스트는 시스템 프로그래밍에 적합한 언어");
		book[2].setCategory("프로그래밍 언어");
		book[2].setReleaseDate("2022/07/08");
	}

	// 장바구니의 도서 ID 존재 여부 확인
	public static boolean isCartInBook(String bookId) {
		/*
		 * boolean flag = false; for (int i = 0; i < cartCount; i++) { if (bookId ==
		 * cartItem[i].getBookID()) { cartItem[i].setQuantity(cartItem[i].getQuantity()
		 * + 1); flag = true; } } return flag;
		 */
		return cart.isCartInBook(bookId);
	}

	// 관리자 로그인 정보 확인 메서드
	public static void menuAdminLogin() {
		System.out.println("관리자 정보를 입력하세요");

		Scanner input = new Scanner(System.in);
		System.out.println("아이디 : ");
		String adminId = input.next();

		System.out.println("비밀번호 : ");
		String adminPw = input.next();

		Admin admin = new Admin(user.getName(), user.getPhone());
		if (adminId.equals(admin.getId()) && adminPw.equals(admin.getPassword())) {
			System.out.println("이름 : " + admin.getName() + ", 연락처 : " + admin.getPhone());
			System.out.println("아이디 : " + admin.getId() + ", 비밀번호 : " + admin.getPassword());

		} else {
			System.out.println("관리자 정보가 일치하지 않습니다.");
		}
	}

	public static void printBill(String name, String phone, String address) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		String strDate = formatter.format(date);
		System.out.println();
		System.out.println("-------------배송 받을 고객 정보-------------");
		System.out.println("고객명 : " + name + "   \t\t연락처 : " + phone);
		System.out.println("배송지 : " + address + "\t발송일 : " + strDate);
		// 장바구니에 담긴 항목 출력
		cart.printCart();

		// 장바구니에 담긴 항목의 총 금액 계산
		int sum = 0;
		for (int i = 0; i < cart.cartCount; i++) {
			sum += cart.cartItem[i].getTotalPrice();
		}
		System.out.println("\t\t\t 주문 총금액 : " + sum + "원\n");
		System.out.println("---------------------------------------");
		System.out.println();

	}
}