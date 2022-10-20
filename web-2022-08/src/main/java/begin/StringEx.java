package begin;

import java.io.UnsupportedEncodingException;

public class StringEx {
	
	public static void main(String[] abc) {
		String s1 = "홍길동";
		String s2 = "홍길동";
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2)); //문자열 비교
//s1이 가리키는 주소와 s2가 가리키는 주소가 똑같니? 값을 비교하는게 아니다.
		// 그러나
		String s3 = new String("일지매");
		String s4 = new String("일지매"); // 새로운 주소를 추가한것이니 주소가 다를수밖에 - heap memory
		System.out.println(s3==s4); //s3과 s4가 가리키는 주소 비교
		System.out.println(s3.equals(s4)); //s3과 s4의 값 비교
		//s4에 가보면 string type의 data가 있다.
		//실제로 s4는 reference type이기 때문에 "일지매"가 저장돼있는 대구라는 주소를 저장하고 있는거지..
		//문자열은 실제로 heap이라는 memory에 저장되어있다.
		//new가 들어가면 heap에 "일지매"가 기존에 있건없건 그냥 또! 만든다.
		//절대 문자열을 비교할때는 무조건 equlas 라는 method를 통해서 문자열이 동일한지 판단해야한다.
		
		System.out.println("------------------------");
		String jumin = "123456-2";

		//charAt(int index) index를 정수형태로 집어넣어라.찾으려는 위치값
		// char - String 이 명령어를 시행하면 반환값이 character type이다. String이란 객체에 있는 method다.
		//chars() : intStream - intStream이라는것을 반환하겠다. String이란 클래스에 있는 접근가능한 메소드다.
		// getChars(int ~~~~) : void - String . 얘를 실행해봐야 반환값은 없어(void).  
		// String이란 class에 존재하는 접근가능한 메소드.
		
		char c = jumin.charAt(7);
		// jumin.charAt() 이라는 메소드를 적고 멍때리면 안돼. 결과값을 반환받으려면 char type의 변수에 저장을 해야해.
		// 왜 굳이 char type을 선택?? - 아무도 몰라! charAt의 reference를 찾아봐야.
		int r = Character.getNumericValue(c);
		//왜 굳이 integer? reference 찾아봐
		String str = null;
		if( r%2==0) str = "여자";
		else		str = "남자";
		System.out.println("c=" + c);
		System.out.println("성별=" + str);
		
		if(c=='1' || c=='3') str = "진짜 남자 !!!!";
		else				str = "진짜 여자 !!!!";
		System.out.println(str);
		
		/* String pn = '123R456'인 경우 4번째 값은
		 * R:red, B:blue, G:green 색을 나타내고 있다.
		 * 위의 pn을 확인하여 어떤색의 제품인지 출력
		 */
		
		String pn = "123R456";
		char co = pn.charAt(3);
		System.out.println(co);
		String str1 = null;
		if(co == 'R') str1 = "red";
		else if(co == 'B') str1 = "blue";
		else if(co == 'G') str1 = "green";
		System.out.println(str1);
		/* String str = null; -> str ( ) 뭔가를 가리키는 값이 아예 없음
		 * String abc = ""; -> heap memory에 공백을 만든다. 주소를 만들지만 찾아가보면 아무것도 없음.
		 * 위 두개는 내용을 보면 완전히 다르다. 
		 * */
		
		System.out.println("-------------------------------------");
		
		// getBytes ------------------------
		
		String str11 = "abc 123 가나다";
		//duplicate local variable alert -> 지역변수를 두번 선언했어. 이자식아
		//1 quick fix available 조치방법? rename 해라
		try {
			byte[] euc = str11.getBytes("euc-kr");
			byte[] ksc = str11.getBytes("ksc5601");
			byte[] iso = str11.getBytes("iso8859-1");
			byte[] utf = str11.getBytes("utf-8");
			
			System.out.println("euc-kr: " + new String(euc) );
			System.out.println("ksc: " + new String(ksc) );
			System.out.println("iso: " + new String(iso) );
			System.out.println("utf: " + new String(utf) );
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//Unhandled exception type UnsupportedEncodingException
		//예외처리를 하지 않았다. 지원되지 않는 인코딩을 하려했을때 발생하는 오류.
		//add throws declaration 던져버리기~ 나에겐 권한이 없으니. 상부에 보고.
		//surround with try/catch 내가 처리하겠다.
		//try{오류가 날 가능성이 있는 코드} catch ~~
		//e.printStackTrace() 에러메세지를 뜨게해주겠다~~
		// 이 code에서 핵심은 getBytes가 아니라~~ try catch다. try catch를 왜 쓰는지. 어떤 의미가 있는지.
		// try catch 구글링 한번 해봐... 
		//초창기 컴퓨터는 예외처리에 대한 개념이 없었음. 플로피 디스크 어쩌고저쩌고 blabla~~
	}

}
















