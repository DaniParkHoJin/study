package basic;

public class LambdaExample {

	public static void main(String[] args) {
		
		action((x,y) -> {
			int result = x + y;
			System.out.println("result: " + result);
		});
		
		action((x,y) ->{
			int result = x -y;
			System.out.println("result: " + result);
		});
		
	}

	public static void action(Calculable Calculable) {
		// 데이터
		int x;
		int y;

		x = 10;
		y = 4;

		// 데이터 처리
		Calculable.calculate(x, y);
	}

}
