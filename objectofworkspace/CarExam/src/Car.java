
public class Car {
	private double speed; 	// 속도

	private int gear; 		// 기어

	private String color; 	// 색상

	// default 생성자
	public Car() { 
		super();
	}

	// 전체 생성자
	public Car(double speed, int gear, String color) {
		super();
		this.speed = speed;
		this.gear = gear;
		this.color = color;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getGear() {
		return gear;
	}

	public void setGear(int gear) {
		this.gear = gear;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [getSpeed()=" + getSpeed() + ", getGear()=" + getGear() + ", getColor()=" + getColor() + "]";
	}

}

