package collection;

public class Data {
	String id;
	String irum;
	int age;
	
	public Data(String id, String irum, int age) {
		this.id = id;
		this.irum = irum;
		this.age = age;
	}
	
	@Override
	public String toString() {
		String str = id + " , " + irum + " , " + age + "\n";
		return str;
	}
	
	@Override
	public int hashCode() {
		
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if(obj instanceof Data) {
			Data temp = (Data)obj;
			if(this.id.equals(temp.getId())) {
				b= true;
			}
		}else {
			String temp = (String)obj;
			if(this.id.equals(temp)) {
				b=true;
			}
		}
		
		return b;
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
