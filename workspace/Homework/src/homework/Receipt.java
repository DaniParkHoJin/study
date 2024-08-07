package homework;

import java.util.Scanner;

public class Receipt {

	public static void main(String[] args) {

		// 받은 돈, 상품의 가격을 입력받기 위한 스캐너 객체 생성
		Scanner input = new Scanner(System.in);

		// 변수 선언
		int ReceiveMoney; // 손님으로 부터 받은 돈
		int TotalPrice; // 손님이 구매한 상품의 총액
		double Vat; // 부가세율
		double Tex; // 상품에 붙은 세금
		int RemainMoney; // 거스름 돈

		// 변수 초기화
		ReceiveMoney = 0;
		TotalPrice = 0;
		Vat = 0.1;
		Tex = 0.0;
		RemainMoney = 0;

		// 손님이 구매한 상품의 금액을 입력 받기 위한 프롬프터
		System.out.print("손님이 구매하신 상품의 가격을 입력하세요. : ");

		// 손님이 구매한 상품의 총액을 입력받는다.
		TotalPrice = input.nextInt();

		// 손님으로부터 받은 금액을 입력 받기 위한 프롬프터
		System.out.print("손님으로부터 받음 금액을 입력하세요. : ");

		// 손님으로 부터 받은 금액을 입력 받는다.
		ReceiveMoney = input.nextInt();

		// 거스름 돈을 계산한다.
		RemainMoney = ReceiveMoney - TotalPrice;		
		
		// 손님이 구매한 상품에 붙은 세금을 계산한다.
		// TotalPrice * Vat
		Tex = TotalPrice * Vat;

		// 줄개행
		System.out.println();
		
		// 영수증 출력
		System.out.println("= 영수증 = ");
		System.out.println("받은 돈 : " + ReceiveMoney);
		System.out.println("상품의 총액 : " + TotalPrice);
		System.out.println("부가세 : " + Tex);
		System.out.println("거스름돈 : " + RemainMoney);
		
		input.close();
	}

}
