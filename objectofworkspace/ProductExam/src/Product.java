
public class Product {
	// �ʵ�
	private String name; 	// �̸�
	private double price;	// ����
	// �⺻ ������
	public Product() {
		super();
	}
	// �ʵ带 ��� �޴� ������
	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	// ������, ������
	// ������ �̸�
	public String getName() {
		return name;
	}
	// ������ ����
	public double getPrice() {
		return price;
	}
	// ������ �̸�
	public void setName(String name) {
		this.name = name;
	}
	// ������ ����
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "�ǸŹ��� [��ǰ�� =" + name + ", ���� =" + price + "]";
	}
	
	
	
}