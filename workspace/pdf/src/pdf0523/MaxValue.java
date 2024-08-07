package pdf0523;

import java.util.Scanner;

public class MaxValue {

	public static void main(String[] args) {

		// 사용자로부터 입력을 받기 위해 Sacnner 객체 생성
		Scanner input = new Scanner(System.in);

		// 필요한 각종 선언
		final int TOTAl_NUMBERS = 6; // 배열 갯수
		int[] numbers = new int[TOTAl_NUMBERS]; // TOTAl_NUMBERS 만큼 배열 생성
		int max;
		int count;
		count = 0;
		String output = "\n 배열 : "; // 출력문자열

		System.out.println("6개의 정수를 입력받아 최대값을 출력하는 프로그램");

		// 6개의 정수를 입력받는다.
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("정수를 입력하세요. : ");
			numbers[i] = input.nextInt();
		}

		// 최대값을 찾는다.
		max = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (max < numbers[i]) {
				max = numbers[i];
			}
		}
		// 최대값과 같은 수가 있는지 찾는다.
		for (int i = 0; i < numbers.length; i++) {
			if (max == numbers[i]) {
				count++;
			}
		}
		// 배열을 출력한다.
		for (int i = 0; i < numbers.length; i++) {
			System.out.println();
		}

		// 배열 출력 문자열
		for (int i = 0; i < numbers.length; i++) {
			output += numbers[i] + " ";
		}
		
		output += "\n 최대값 : " + max;
		output += "\n 가장 큰 숫자의 발생 횟수 : " + count;
		
		// 결과 출력
		System.out.println(output);
		input.close();

	}
}