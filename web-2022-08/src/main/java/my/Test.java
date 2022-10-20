package my;

public class Test {

	public static void main(String[] args) {
		PrivateClass c = new PrivateClass();
		//c.score = 100;//score는 private variable이기에 x
		//c.k();//k method는 private 이라 x
		c.tot = 200;
		c.hap();
	}
}
