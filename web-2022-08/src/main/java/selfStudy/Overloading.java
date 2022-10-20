package selfStudy;

public class Overloading {
	
	String name = "자동차";
	int aa = 1800;
	String color = "검정";
	
	public void a() {
		System.out.println(this.name);
		System.out.println(this.aa);
		System.out.println(this.color);
	}
	
	public void a(String name) {
		this.name = name;
		a();
	}
	
	public void a(String name, String color) {
		
	}
	
	public static void main(String[] args) {
		Overloading ov = new Overloading();
		ov.a();
	}

}
