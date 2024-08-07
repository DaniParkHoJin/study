package homework;

import java.util.Scanner;

public class MileToKilometer {

	public static void main(String[] args) {
		// 입력받기 위한 스캐너 객체 생성
		Scanner input = new Scanner(System.in);
		
		// 변수 선언
		double mile;  // 마일
		double kilometer;  // 킬로미터
		
		// 입력받기 위한 프롬프터
		System.out.print("마일을 입력하세요. : ");
		mile = input.nextDouble();
		
		// 킬로미터를 마일로 변환
		// 킬로미터 = 마일 * 킬로미터변환상수(1.609)
		kilometer = mile * 1.609;
		
		// 답 출력
		System.out.println(mile + "마일은 " + kilometer + "킬로미터입니다." );
		
		// 스캐너 객체 종료
		input.close();
	}

}
