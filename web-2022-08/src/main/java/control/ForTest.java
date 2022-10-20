package control;

public class ForTest {
	/* 파라메터로 전달된 정수까지 1부터 출력*/
	public void test1(int su) {
		for(int a=1; a<=su; a++ ) {
			System.out.println(a);
		}
	System.out.println("---------------------------");
	}
/*
 * test1(int su){
 * 		int i=0;
 * 		for(i=1; i<=su; i++){
 * 			system.out.print(i+"");
 * 		}
 * }
 *  
 * 	
 */
	/* 1부터 파라메터로 전달된 정수까지의 홀수의 합 */
	public void test2(int su) {
		int a = 0;
		int sum = 0;
		for(a=1; a<=su; a++) {
			if(a%2==1) sum +=a;
		}
	System.out.println("sum="+sum);
	System.out.println("------------------------");
	}
	
/*
 * int i =0;
 * int hap = 0;
 * for(i=1; i<=su; i=i+2){
 * 		hap += i;	
 * }
 * System.out.printf("1~%d까지 홀수의합=%d\n", su, hap);
 * i=2로 지정시 짝수의 합.
 * i=5, i=i+5 하면 5의 배수의 합.
 */
	
	
	
	/* 파라메터로 전달된 수에 해당하는 구구단 출력 */
	public void test3(int dan) {
		int r = 0;
		for(int a=1; a<=9; a++) {
			r = dan * a;
		System.out.println(dan + "*" + a + "=" + r);
		}
	}
	/*
	 * int r= 0;
	 * for(int i=1; i<=9; i++) {
	 * int r = 0;
	 * for(int i=1; i<=9; i++) {
	 * 		r=dan*i;
	 * 		system.out.printf("%d * %d = %d \n", dan , i, r);
	 * 		}
	 * }
	 */
	/*
	 * d 정수. f 실수. c문자. s문자열. %10d ㅁㅁㄴㄹㅇㅇ
	 */
	
	
	/*1부터 파라메터로 전달된 n까지의 합계가 1500이상이
	 * 되는 시점의 값과 합계 출력
	 */
	public void test4(int n) {
		int sum = 0;
		int a=0;
		for(a=1; a<=n; a++) {
			sum += a;
			if(sum>=1500) break;
		}
	System.out.println("a="+a);
	System.out.println("sum="+sum);
	}
	public static void main(String[] args) {
		ForTest ft = new ForTest();
		ft.test1(10);
		ft.test2(5);
		ft.test3(9);
		ft.test4(100);
	}
}

/*
 * for문은 내성적이다. 뭔가 자꾸 물어본다.
	초기값을 물어보고, 범위를 물어보고, ...
	
 */
// for test ft = new fortest() 객체를 생성할때 아무나 생성할수있게 하겠다
// fortest 클래스명 ft변수(객체,인스턴스) fortest() 생성자.
// 생성자가 하나라도 기술되면 작성된 생성자로만 객체를 생성 가능.
// abstract class 객체 단독생성 불가/ class 객체 단독생성/ interface 객체 단독생성 불가
// 클래스엔 필드와 메소드
// ft.test1() 이런 코드를 아무나 쓸수있게 하겠다  = public
// void = 어떤 결과값도 반환하지 않겠다
// 문자열 배열을 parameter로 받는다
// method 의 기술순서는 상관無
// method 안에 method는 선언x method안에 class는 선언가능 class안에 class는 선언가능.
// 코딩은 수학문제와 비슷한것 같다. 직접 풀어보지 않고 눈으로만 감상하면 결국 남는게 하나도 없다.
// program은 결국 손끝으로 느끼지 않으면... 맞냐 틀리냐 결과는 不중요..







