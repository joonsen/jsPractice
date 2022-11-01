package jdbc;

public class ScoreVo {
	String  id, mdate, subject;
	int serial, score;
	
	public ScoreVo() {
		
	}
	
	public ScoreVo(int serial, String id, String mdate,
			String subject, int score) {
		this.serial = serial;
		this.id= id;
		this.mdate = mdate;
		this.subject = subject;
		this.score = score;
	}

	public String getId() {	return id;}

	public void setId(String id) { this.id = id; }

	public String getMdate() {	return mdate;	}

	public void setMdate(String mdate) {	this.mdate = mdate;	}

	public String getSubject() {	return subject;	}

	public void setSubject(String subject) {	this.subject = subject;	}

	public int getSerial() {	return serial;	}

	public void setSerial(int serial) {	this.serial = serial;	}

	public int getScore() {	return score;}

	public void setScore(int score) {	this.score = score;	}

	
	
	
	
}
