package iostream;

import java.io.Serializable;
import java.util.Vector;

public class ScoreVo implements Serializable {
	public static long serialVersionUID=300L;
	
	int serial,score;
	String id, mDate, subject;
	
	public ScoreVo(int s, String id, String md, String sub, int score) {
		this.serial = s;
		this.id = id;
		this.mDate = md;
		this.subject = sub;
		this.score = score;
	}

	public Vector getVector() {
		Vector v = new Vector();
		v.add(serial);
		v.add(id);
		v.add(mDate);
		v.add(subject);
		v.add(score);
		return v;
	}
	@Override
	public int hashCode() {
		return this.serial;
	}

	@Override
	public boolean equals(Object obj) {
		boolean b = false;
		if(obj instanceof ScoreVo) {
			ScoreVo vo = (ScoreVo)obj;
			b = (vo.getSerial() == this.serial)	;
			}
		
		return b;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		ScoreVo.serialVersionUID = serialVersionUID;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getmDate() {
		return mDate;
	}

	public void setmDate(String mDate) {
		this.mDate = mDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}






















