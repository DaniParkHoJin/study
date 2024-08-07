package homework;

import java.util.Scanner;

public class SphereVolume {

	public static void main(String[] args) {
		
				// 사용자로부터 입력을 받기 위해 Scanner를 생성한다.
				Scanner input = new Scanner(System.in);

				double radius; // 구의 반지름
				double pi; // π(원주율)
				double volume;

				pi = 3.14159; // 원주율

				System.out.println("구의 부피를 계산하는 프로그램");

				// 반지름을 입력받는다.
				System.out.print("반지름을 실수형으로 입력하세요. : ");
				radius = input.nextDouble();

				// 구의 부피 = 4/3 * 원주율(pi) * 반지름 * 반지름 * 반지름
				volume = 4.0 / 3 * pi * radius * radius * radius;

				// 구의 부피를 출력한다.
				System.out.println("구의 반지름이 " + radius + "인 구의 부피는 " + volume + "입니다.");

				
				// Scanner객체 종료.
				input.close();
	}

}
