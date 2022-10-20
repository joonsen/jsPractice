package control;

public class WhileTest {
	//1~10까지 출력
	public void test1() {
		int i = 0;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
		System.out.println("-----------------------------");
	}
	public void test2() {
		int i = 0;
		while(i<=100) {
			if(i%5==0) System.out.println(i);
			i=i+3;
		}
		System.out.println("-----------------------------");
	}
	public void test3() {
		int i=0;
		while(i<=10) {
			i++;
			if(i%2==0) System.out.println(i);
		}
		System.out.println("-----------------------------");
	}
	public void test4() {
		int i=0;
		while(i<=100) {
			i++;
			System.out.println(i);
			if(i>=10) break;
		}
		System.out.println("-----------------------------");
	}
	public void test5() {
		int i = 1;
		int sum = 0;
		while(sum<=1000) {
			sum += i;
			System.out.println(i + "=>" + sum);
			i++;
		}
		System.out.println("----------------------------");
	}
/*
 * i의 합이 1000을 넘을 때 i의 값
 * 원기센세 sol
 * int i = 0;
 * int sum = 0;
 * while(sum<1000) {
 * 		i++;
 * 		sum += i;
 * 		}
 * system.out.printf("i=%d, sum=%d\n", i ,sum);
 */
	public void test6() {
		int n= 124;
		int i= 1;
		while(i<=124) {
			if (n%i==0) System.out.println(i);
			i++;
		}
		System.out.println("----------------------------");
	}
/*
 * 124의 약수들
 * int i = 1;
 * int su = 124;
 * while(i<su) {
 * 		i++;
 * 		if(su%1==0){
 * 			system.out.println(i);
 * 		}
 * }
 */
	public void test7() {
		int x=0;
		int y=0;
		while(y<=33) {
			x++;
			y = 2*x + 10;
			if(y>33) break;
			System.out.println(x + "," + y);
		}
	}
/*
 * y=2x+10의 해(단, x>=1, y<=33)
 * int i=0;
 * int x=0;
 * int y=0;
 * while(true){
 * 		x++;
 * 		y=2*x+10;
 * 		if(y>33) break;
 * 		System.out.printf("(%d,%d) \n", x,y);
 * 		}
 */
	public static void main(String[] args) {
		WhileTest wt = new WhileTest();
		wt.test1();
		wt.test2();
		wt.test3();
		wt.test4();
		wt.test5();
		wt.test6();
		wt.test7();
	}
}
