package your;

import my.PackageClass;

public class YourClass {

	YourClass(){
		PackageClass c = new PackageClass();
		c.b=100;
		// c.a=200;	//	public이 아니라 package이기 때문에 x
		//c.c=200;// public이 아니라 protected이기 때문에 x
	}
}
