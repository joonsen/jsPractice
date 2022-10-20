package control;

public class If_test {
	public void test1() {
		int score = 50;
		if(score >= 80) {
			System.out.println("合格");
		} else if(score < 40) {
			System.out.println("科落");
		} else System.out.println("待機");
	}
/* 1. 메소드 test1()을 추가.
 * 2. 정수형 변수 score를 추가하고 임의의 초기값을 대입
 * 3. if문을 사용하여~
 */
/* 박원기 센세
public void test1() {
	int score=90;
	String msg="";
	if(score>=80)	msg="합격";
	else if(score>=40) msg="대기";
	else			msg="과락";
	System.out.println(msg);
}
 */
	
	public void test2() {
		int price = 90;
		int ea = 1;
		int amount = price*ea;
		int tax = (int)(amount*0.1);
		int totAmount = amount + tax;
		String str = "";
		if(totAmount >= 1000) 		str="비행기";
		else if(totAmount >= 500) 	str="자동차";
		else if(totAmount >= 300) 	str="자전거";
		else						str="화장지";
		System.out.println("단가: " + price);
		System.out.println("수량: " + ea);
		System.out.println("세금: " + tax);
		System.out.println("금액: " + amount);
		System.out.println("총액: " + totAmount);
		System.out.println("사은품: " + str);
		System.out.println("귀하는 "+str+" 당첨입니다");
		
	}
	/*
	 * 1. 메소드 test2() 추가
	 * 2. 정수형 변수 price에 임의의 단가 입력, 정수형 변수 ea에 임의의 수량 입력
	 * 3. 정수형 변수 amount에 수량*단가를 계산하여 대입
	 * 4. 정수형 변수 tax에 부가세 계산.
	 * 5. 정수형 변수 totAmount에 금액+세금을 대입~~
	 */
	
	public static void main(String[] args) {
		If_test it1 = new If_test();
		it1.test1();
		it1.test2();
	}
}
















