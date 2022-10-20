package iostream;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Score implements Serializable{
	public static long serialVersionUID=200L;
	
	String id;
	int kor, eng, mat, tot;
	double avg;
	
	public Score(String id, int kor, int eng, int mat) {
		this.id = id;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = (kor+eng+mat);
		this.avg = tot/3.0;
		
	}
	
	@Override
	public String toString() {
		DecimalFormat sdf = new DecimalFormat("#,###.0");
		
		String temp = "\n-------------"
				    + "\n id : " + this.id
				    + "\n kor : " + this.kor
				    + "\n eng : " + this.eng
				    + "\n mat : " + this.mat
				    + "\n eng : " + this.eng
				    + "\n tot : " + this.tot
				    + "\n avg : " + sdf.format(this.avg);
		return temp;
	}

	public void write() {
		
	}
	public void read() {
		
	}
}
















