package inheri;

public class Student extends Data {
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	
	
	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public Student(String name, String address, String phone, int kor, int eng, int math) {
		setName(name);
		setAddress(address);
		setPhone(phone);
		setKor(kor);
		setEng(eng);
		setMath(math);
		computeTot();
		computeAvg();
		}
	public double computeTot() {
		return this.tot = kor + eng + math;
	}

	public double computeAvg() {
		return this.avg = tot/3;
	}
	
	@Override
	public String toString() {
		return name + "\t" + address + "\t" + phone +"\t" + kor + "\t" + eng + "\t" + math +"\t" +tot +"\t" +avg ;
		
	}
	
}















