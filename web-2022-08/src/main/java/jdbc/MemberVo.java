package jdbc;

public class MemberVo {
	String id, irum, gender, phone, picture, mDate;
	
	public MemberVo() {}	//한건의 데이터만 저장하는 공간
	
	public MemberVo(String id, String irum, String gender,
					String phone, String picture) {
		this.id = id;
		this.irum = irum;
		this.gender = gender;
		this.phone = phone;
		this.picture = picture;
		
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getmDate() {
		return mDate;
	}
	public void setmDate(String mDate) {
		this.mDate = mDate;
	}
}
