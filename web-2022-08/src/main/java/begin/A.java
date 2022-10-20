package begin;

public class A {
	public static void main(String[] abc)  {
		System.out.println("이준혁");
		System.out.println("봉천동");
		System.out.println(10+10);
		
		/*논리형 */
		boolean b1 = true;
		boolean b2 = 10>20;
		System.out.println("b1=" + b1);
		System.out.println("b1=" + b2);
		
		//문자형character type - 작은따옴표로 묶여있어야한다
		char c1 = '1';
		c1 += 1;
		System.out.println("c1=" + c1);
		
		//long
		long l1 = 10L;
		
		//실수형
		float f1 = (float) 3.14; // double to float casting
		float f2 = 3.14f;

		//정수형 연산 정수형은 정수형
		System.out.println(10/4);
		System.out.println( (double)10/4 );
		System.out.println( 10/ (double)4 );
	}
}
//A란 class는 begin이란 folder안에 있을거야~ String[]까지는 한글자도 틀려선 안돼 소괄호안은 parameter,
//java에선 argument라 부른다. 또는 매개변수. String은 문자열 유형. abc는 문자열형 배열이다.
//그중에서 main이라 하는 함수는 시작, start.
//이 구조는 bin 이다. module이라고 불리기도 한다.
//run configuration - java는 단독으로 web running이 불가능하다.
//반드시 java는 클래스 선언을 한후에야 다음 작업을 할 수 있다. 
//별도로 가능한것은 package. import. comment. @metadata.
//promotion 은 데이터가 작은 타입에서 큰 타입으로, 자동변환.
//casting은 데이터가 큰 타입을 작은 타입으로, 인위조정.
//현업에서는 promotion과 casting을 엄격히 구분하지 않는다. 그냥 'casting했어?' 형변환은 모두 casting이다.
//영문자 L은 대문자로만 쓴다. 숫자 1이랑 헷갈리잖아. 초기엔 c와 (, 0과 o, 2와 z 등 헷갈리는것이 많았다.
//정수형 실수형 연산 -> 결과치는 실수형.
//byte. short. char과 정수형이 연산되면 정수형이 된다.
//정수형 연산 정수형은 무조건 정수형





















