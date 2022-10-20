package iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

public class MemberDao {
	public String fileName = "member.obj";
	List<Data> list = new Vector<Data>();
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public MemberDao() {
		this.list = read();
	}
	
	public void write(Data d) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			list.add(d);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			fos.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public List<Data> read() {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			list = (List<Data>)ois.readObject();
			ois.close();
			fis.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
	public void modify(Data d) {
		// 기존 자료를 다시 read
		read();
		// 수정할 데이터를 검색
		int index = list.indexOf(d);
		if(index != -1) {
			list.set(index, d);	//자료 갱신
			try {
				FileOutputStream fos = new FileOutputStream(fileName);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				oos.flush();	//데이터가 많을땐 flush 반드시
				oos.close();	//열려진 stream은 닫아주는게 정석
				fos.close();
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void delete(String id) {
		read();	//최종 결과물로 다시 list를 갱신 굳이 안해도 상관없지만 해주는것이 안전
		Data d = new Data();	//촌스럽게 null, null, null, 0 할순없다
		d.setId(id);
		
		int index= list.indexOf(d);
		if(index != -1) {
			list.remove(index);	//메모리에서만 삭제
			try {
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(list);
				oos.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
	}
	public void view() {}
}

















