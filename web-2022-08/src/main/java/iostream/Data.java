package iostream;

import java.io.Serializable;
import java.util.Vector;

public class Data implements Serializable {		//가장중요
	public static long serialVersionUID=100L;		//static - 한번 설정이 되면 나중에 초기화가 되지 않도록 static
	
	String id, mName, addr, phone;
	int point;
	
	public Data() {}
	public Data(String id, String mName, String addr, String phone, int point) {
		this.id = id;
		this.mName = mName;
		this.addr = addr;
		this.phone = phone;
		this.point = point;
	}

	//JTable의 데이터 속성이 Vector<Vector>이기 때문에 (list interface의 장점?)
	public Vector getVector() {
		Vector v = new Vector();
		v.add(id);
		v.add(mName);
		v.add(addr);
		v.add(phone);
		v.add(point);
		return v;
	}
	
	@Override
	public String toString() {		//console창에 뿌리기 위한 작업. 의미가 없어졌음.
		String temp ="\n-----------------"
					+"\nid : " + this.id
					+"\nname : " + this.mName
					+"\naddress : " + this.addr
					+"\nphone : " + this.phone
					+"\npoint : " + this.point;
		return temp;
	}

	@Override
	public int hashCode() {
		// 패키지명.클래스명@자신의 hashCode 동등객체를 비교하려면 hashCode값이 같아야한다.
		//hashCode같으면 equals method가 실행되어.. equals마저 같다고 판단하면 동등객체다.
		//
		return this.id.hashCode();	//문자열이 똑같으면 똑같은 hashCode가 반환이된다
	}

	@Override
	public boolean equals(Object obj) {
		boolean b=false;
		if(obj instanceof Data) {
			Data d = (Data)obj;
			b = d.getId().equals(this.id);	//object에서 가져온 id값이 같으면 true가 return
			
		}
		return b;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
}





















