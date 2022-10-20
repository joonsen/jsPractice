package exception_ex;

public class TryTest {

	int a(){
		String s = "abc";
		try {
			int i = Integer.parseInt(s);
		}catch(NumberFormatException ex) {
			System.out.println("좋은말할 때 숫자로");
		}finally {
			System.out.println("무조건이야~");
		}
		return 10;
	}
	void b() {
		String[] ary = {"a","b","c"};
		for(int i=0; i<=3; i++) {
			try {
			System.out.println(ary[i]);
			}catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("배열의 크기를 벗어난듯");
			}
		}
	}
	
	void c() throws Exception{ // 연산오류
		int a=10;
		int r = a/0;
	}
	
	void d() { // null 오류
		String name  = null;
		try {
			System.out.println(name.equals("abc"));
		} catch(Exception ex) {
			System.out.println("문자열이 비어있네요");
		}
	}
	
	void test() {
		try {
			throw new Exception("오류남");
			// System.out.println("이곳은 실행되지 않음");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			new TryTest().test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}











