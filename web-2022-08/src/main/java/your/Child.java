package your;

import my.PackageClass;

public class Child extends PackageClass{
	// packageClass(parents)라는 놈을 상속받아서 Child를 만듬.
	Child(){
		//a=1;//같은 package 내에서만 사용가능.
		b=2;
		c=3;
		//고수들은 member들을 전부 private으로 declaration(for security)
	}
	
}
