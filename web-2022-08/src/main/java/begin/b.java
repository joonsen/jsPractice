package begin;

public class b {
	
	public b() {
		char alpha = 'a';
		char number = '1';
		char hangul = '한';
		
		System.out.println(alpha + "," + number + "," + hangul);
		
		alpha += 1;
		number += 1;
		hangul += 1;
		
		System.out.println(alpha + "," + number + "," + hangul);
	}
	public static void main(String[] args) {
		b b = new b();
	}

}
