package begin;

//메소드: 접근제한자 반환형 메소드명(매개변수들){}
public class StringEx2 {

	public void test() {
		System.out.println("----------------");
		String str1 = "abcdefabc";
		String str2 = "abc가나다abc";
		int len1 = str1.length();
		int len2 = str2.length();
		int index1 = str1.indexOf("c");
		int index2 = str2.indexOf("나");
		int index3 = str2.indexOf("ab",3);
		
		System.out.println("len1= " + len1);
		System.out.println("len2= " + len2);
		System.out.println("index1= " + index1);
		System.out.println("index2= " + index2);
		System.out.println("index3= " + index3);
	}
	
	public void replaceTest() {
		System.out.println("replace---------------------");
		String source = "abc def 123 가나다 abc 123";
		String r1 = source.replace("123", "하나둘셋");
		String r2 = source.replaceAll("[12]", "헛둘");
		//정규식..[12]는 1또는2
		
		System.out.println("r1=" + r1);
		System.out.println("r2=" + r2);
	}
	
	public void substringTest() {
		String source = "abc def 123 가나다 abc 123";
		String sub = source.substring(0,3);
		System.out.println(sub); //abc
	}
	
	public void lowerTest() {
		String toCase = "aBCdef";
		System.out.println(toCase.toLowerCase());//abcdef
		System.out.println(toCase.toUpperCase());//ABCDEF
	}
	
	public void trimTest() {
		String trim = "           abc            ";
		System.out.println(trim);//양옆 공백 출력됨
		System.out.println(trim.trim());// 공백 제거됨
	}
	
	public void valueOfTest() {
		int v1 = 123;
		double v2 = 123.45;
		System.out.println(String.valueOf(v1));//문자 123
		System.out.println(String.valueOf(v2));//문자 123.45
	}
	public void splitTest() {
		String str = "123,456.789/012";
		String[] sp1 = str.split(",|/|\\.");
		for(String s : sp1) {
			System.out.println(s);
		}
	}
	public static void main(String[] kkk) {
		StringEx2 ex2 = new StringEx2();
		ex2.test();
		ex2.replaceTest();
		ex2.substringTest();
		ex2.lowerTest();
		ex2.trimTest();
		ex2.valueOfTest();
		ex2.splitTest();
	}
}
//main method를 만들건데 만들수 있는 공간은 public class와 public void test 사이만 가능
//가장 위 package begin; 에 적을수 있는것? package와 import 두가지 뿐. package는 한개밖에 못씀.
//3차원 공간에 같은 물체는 하나밖에 존재할 수 없음. 동시존재 불가.
//import는 필요한만큼.
//test() 안에 존재할수 없는 이유 - method 안에 method는 선언할 수 없음.
//main 함수는 program을 시작하는 기능.
//StringEx2 class를 memory에 올려야 test() method 실행 가능.
//11행 잘 이해해야해. StringEx2 요 class를, ex2 라는 객체로 만들겠다. ex2는 변수인데, 기본형 변수와는 다르게 StringEx2형 이다.
//ex2는 객체요 , object이고, memory에 올라간 object이기 때문에 instance라고 부른다.
//현장에서 "객체 작성했냐?" = "class 작성했냐?" 객체란 단어를 굉장히 광범위하게 쓴다.
//new StringEx2()는 생성자이다. class명과 생성자명은 같다. StringEx2는 class이고 new 뒤의 StringEx2()는 메소드이다.
// 생성자 method 이다.
//ex2.test() = ex2란 객체가 가지고있는(have) test method.
//생성자를 원래 선언해야 하는데, 자바가상머신이 매개변수도 없고 처리되는것도 없는 가상의 생성자를 빌려준다. (?) 교재 읽어봐야.
//overloading : 중복선언. 메소드 기능은 다 똑같은데 매개변수가 다 다르면.. 이름을 똑같게 만들어주도록 하자. -> 작업의 일관성을 위해.
//매개변수는 다르지만 반환타입은 다 정수형이야. 매개변수로 들어오는 값의 위치를 찾아 정수값으로 반환. 0은 첫번째자리. -1은 데이터가 없음.


















