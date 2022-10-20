package begin;

public class C {

	public static void main(String[] args) {
		C e = new C();

	}
	
	public C() {
		byte b = 'a';
		System.out.println("b=" + b);
		System.out.println("b=" + (char)b);
		
		b++;
		
		System.out.println("b=" + b);
		System.out.println("b=" + (char)b);
	}

}
