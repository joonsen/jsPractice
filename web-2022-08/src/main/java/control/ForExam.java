package control;

public class ForExam {
	
	public void test1(int x, int y) {
		for(x=2; x<y; x++) {
			int j;
			for(j=2;j<x;j++) {
				if(x%j == 0) {
					break;
				}
			}
			if(x==j) {
				System.out.println(j);
			}
		}
		System.out.println("-------------test1-----------------");
	}
	public void test2(int x) {
		for(int i = 1; i<=x;i++) {
			for(int j = 0; j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=0;i<x;i++) {
			for(int j=x-1; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("-----------------test2------------------");
	}
	public void test3(int x, int y, int z) {
		for(int i=x; i<=y; i++ ) {
			if(i%z == 0) {
				System.out.println(i);
			}
		}
		System.out.println("-------------test3--------------------");
	}

	public void test4(int x, int y) {
		for(int i=x; i<=y; i++) {
			for(int j=i; j<=y; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
			ForExam fe = new ForExam();
			fe.test1(2,50);
			fe.test2(5);
			fe.test3(3,20,5);
			fe.test4(1, 5);
	}
}
