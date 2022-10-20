package Interface_ex;

public class AfterMember implements MemberInterface {

	String abc;
	
	@Override
	public void setName(String name) {
		this.abc = name;	//name이 abc에 들어가겠지.		
	}

	@Override
	public String getName() {
		return this.abc;
	}

}
