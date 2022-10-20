package begin;

public class StringEx3 {
	//생성자
	public StringEx3() {
		System.out.println("생성자.......");
		StringBuilder b1 = new StringBuilder("abc");
		StringBuilder b2 = new StringBuilder("abc");
		
		if(b1 == b2) System.out.print("b1, b2는 같다");
		else 		 System.out.println("b1, b2는 다르다");
		
		String s1 = b1.toString();
		String s2 = b2.toString();
		
		if(s1==s2) System.out.println("s1==s2");
		else	   System.out.println("s1,s2는 다르다.");
		
		if(s1.equals(s2)) System.out.println("같다...");
		else			  System.out.println("다르다..");
	}
	public void test() {
		System.out.println("StringEx3.test");
		StringBuilder sb = new StringBuilder();
		sb.append("이름:hong gil dong\n"+"주소: 봉천\n"+"연락처:010-1111\n");
		String str = sb.toString();
		
		System.out.println("sb=" + sb);
		System.out.println("str=" + str);
	}
	public static void main(String[] args) {
		StringEx3 ex3 = new StringEx3();
		ex3.test();
	}
}

//생성자를 가지고 만들거야 반환형은 없어
//생성자 특징 1. 반환형 없음(있으면 메소드) 2. 반드시 클래스명과 동일 
//역할 - 객체가 생성될 때, 객체를 초기화.
//생성자 기술하지 않으면, 매개변수도 없고, 처리내용도 아무것도없는 가상의 생성자를 자바가상머신이 빌려준다.
//생성자를 하나라도 선언하면 빌려주지 않는다.
//클래스명 인스턴스명 = new 생성자명(); ex3는 StringEx3 type의 변수가 된다. 매개변수가 없는 생성자 StringEx3()으로 객체를 생성.
//java.lang은 java를 사용할때 기본적으로 사용하는 method만 모아놔서 import를 하지 않아도 됨.
//[미션]
//1) StringEx3 클래스에 public void test() 메소드 추가
//2) test() 메소드안에 'StringEx3.test'문자열 출력
//3) test() 메소드를 실행시켜 문자열 확인
//4) test() 에서 추가
//	- StringBuilder 객체를 생성
//	- 객체안에 이름,주소,연락처를 추가
//	- 객체안의 문자열을 고정 문자열로 바꾸어 화면에 출력




















