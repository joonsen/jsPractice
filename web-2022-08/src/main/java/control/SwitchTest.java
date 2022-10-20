package control;

public class SwitchTest {
	
	public SwitchTest() {
		char code='a';
		int price = 0;
		int ea = 100;
		int amt = 0;
		
		switch(code) {
		case 'a': price=5; break;
		case 'b': price=3; break;
		case 'c': price=1; break;
		}
		amt = ea * price;
		System.out.println(amt);
		System.out.println("---------------");
	}
	
	public void test1() {
		int su = 3;
		while(su<=100) {
			if(su%5==0) System.out.println(su);
			su += 3;
		}
		System.out.println("-----------------");
	}
	
	public void test2() {
		int i=0;
		while(i<=10) {
			i++;
			if(i%2==1) continue;
			System.out.println(i);
		}
		System.out.println("----------------------");
	}
	
	public void test3() {
		int i=0;
		while(i<100) {
			i++;
			System.out.println(i);
			if(i>=10) break;
		}
		System.out.println("--------------");
	}
	
	public static void main(String[] args) {
		SwitchTest st = new SwitchTest();
		st.test1();
		st.test2();
		st.test3();
	}

}
