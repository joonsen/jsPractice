package control;

public class Gugudan {
	Gugudan(){
		for(int dan=2; dan<=9; dan++) {
			int r = 0;
			System.out.println(dan + " 단");
			for(int i =1; i<=9; i++) {
				r= dan*i;
				System.out.printf("%d * %d = %d", dan,i,r);
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		int r =0;
		for(int i=2;i<10;i++) {
		System.out.println(i+"단");
		for(int j=1; j<10;j++) {
			r=i*j;
			System.out.printf("%3d*%3d=%4d\n",i,j,r);
		}
		}
		new Gugudan();
	}
}

// 실행결과는 생성자에서 blabla
// 같은 패키지에서는 객체를 생성할 수 있다. 다른 패키지에선 객체 생성 불가
// 










