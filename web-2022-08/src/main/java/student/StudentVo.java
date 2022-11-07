package student;

public class StudentVo {
//id에서 email까지 정보를 담을 vo를 만듬 ,DB연결까지 생각해서 쿼리박스 mydb->student테이블의 컬럼값들을 토대로 선언.
   String id;   //폼태그의 input태그의 name값들과같아야함
   String name;
   String phone;
   String pwd;
   String address;
   String address2;
   String gender;
   String email;
   String zipcode;
   
   
   public String getId() {return id;}
   public void setId(String id) {this.id = id;}
   public String getName() {return name;}
   public void setName(String name) {this.name = name;}
   public String getPhone() {return phone;}
   public void setPhone(String phone) {this.phone = phone;}
   public String getPwd() {return pwd;}
   public void setPwd(String pwd) {this.pwd = pwd;}
   public String getAddress() {return address;}
   public void setAddress(String address) {this.address = address;}
   public String getAddress2() {return address2;}
   public void setAddress2(String address2) {this.address2 = address2;}
   public String getGender() {return gender;}
   public void setGender(String gender) {this.gender = gender;}
   public String getEmail() {return email;}
   public void setEmail(String email) {this.email = email;}
   public String getZipcode() {return zipcode;}
   public void setZipcode(String zipcode) {this.zipcode = zipcode;}
}