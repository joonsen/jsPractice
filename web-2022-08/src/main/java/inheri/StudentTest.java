package inheri;

public class StudentTest {
	
	public static void main(String[] args) {
		
		System.out.println("====================================================================");
		System.out.println("성명\t주소\t전화\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("--------------------------------------------------------------------");
		Student stu1 = new Student("이박사","봉천동","010-1111-1234", 88, 83, 80);
		Student stu2 = new Student("김일성", "평양시", "010-1234-2344",58, 20, 71);
		Student stu3 = new Student("모택동", "북경시", "010-3456-1234", 73, 60, 55);
		Student stu4 = new Student("장수근", "목동", "010-222-4412", 11, 22, 47);

		System.out.println(stu1);
		System.out.println(stu2);
		System.out.println(stu3);
		System.out.println(stu4);
		System.out.println("--------------------------------------------------------------------");
	}

}
