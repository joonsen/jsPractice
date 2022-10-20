//package iostream;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ObjectStreamEx2 {
//	String fileName = "object2.obj";
//	List<Score> list;
//	
//	public void write() {
//		FileOutputStream fos = new FileOutputStream(fileName);
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		
//		list = new ArrayList<Score>();
//		
//	}
//	
//	public void read() throws Exception {
//		FileInputStream fis = new FileInputStream(fileName);
//		ObjectInputStream ois = new ObjectInputStream(fis);
//		list = (List<Score>) ois.readObject();
//		
//		list.forEach(x->System.out.print(x));
//		
//		ois.close();
//		fis.close();
//	}
//	
//	public static void main(String[] args) {
//		ObjectStreamEx2 ex = new ObjectStreamEx2();
//		try {
//			ex.write();
//			ex.read();
//			
//		} catch() {
//			
//		}
//		
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
