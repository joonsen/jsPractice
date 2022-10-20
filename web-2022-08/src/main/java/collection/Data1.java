package collection;

public class Data1 {
	String id;
	String irum;
	int age;
	
	public Data1(String id, String irum, int age) {
		this.id = id;
		this.irum = irum;
		this.age = age;
	}
	
	@Override
	public String toString() {
		String str = id + " , " + irum + " , " + age + "\n";
		return str;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
