package forExam;

public class RealNumberTest {

	public static void main(String[] args) {
		float sum;
		sum = 0.0f;
		double dsum;
		dsum = 0.0;
		for (float i = 0.01f; i <= 1.0f; i = i + 0.01f) {
			sum += i;
		}System.out.println("flat 합은" + sum + "이다.");
		
		double currentValue = 0.01;
		for(int i = 0; i <100; i++) {
			dsum += currentValue;
				currentValue += 0.01;
			
			System.out.println("double의 합은 " + dsum + "이다.");
		}

	}

}