package pdf0523;

import java.util.Scanner;

public class SubtractionQuizLoop {

	public static void main(String[] args) {

		// 사용자로부터 입력을 받기위해 Scanner를 생성한다
		Scanner input = new Scanner(System.in);

		// 변수 선언
		final int NUMBER_OF_QUESTIONS; // 총 문제 갯수 변수
		int courrectCount; // 정답 갯수 변수
		int count; // 반복문 탈출
		long startTime; // 시작시간 변수
		long endTime; // 종료시간 변수
		long testTime; // 테스트 전체 초 변수
		long currentSecond; // 테스트 초 계산 변수
		long totalMinutes; // 테스트 분 계산 변수

		// 변수 초기화
		NUMBER_OF_QUESTIONS = 5; // 문제 갯수 5개
		courrectCount = 0; // 정답 갯수 0개
		count = 0;

		startTime = System.currentTimeMillis() / 1000; // 밀리나노초를 초로 변경

		String output = "";
		System.out.println("다섯 개의 뺄셈문제 테스트 프로그램");

		int number1; // 첫번째 랜덤 숫자 변수
		int number2; // 두번째 랜덤 숫자 변수

		number1 = (int) (Math.random() * 101); // 첫번째 숫자 넣기
		number2 = (int) (Math.random() * 101); // 두번째 숫자 넣기

		if (number1 < number2) {
			int temp; // 순서 변경을 위한 임시 변수
			temp = number1;
			number1 = number2;
			number2 = temp;
		}

		count++;

		System.out.println("\n문제 " + count + "번");
		System.out.println(number1 + " - " + number2 + " = ");
		int answer = input.nextInt();

		if (number1 - number2 == answer) {
			System.out.println("정답!");
			courrectCount++;
		} else {
			System.out.println("오답\n" + number1 + " - " + number2 + " = " + (number1 - number2));
		} 
		input.close();
	}

}
