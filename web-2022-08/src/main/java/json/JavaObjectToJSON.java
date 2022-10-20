package json;

import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JavaObjectToJSON {
	public JavaObjectToJSON(){
		//---------------------------
		JSONObject obj = new JSONObject();
		obj.put("name", "홍길동");
		obj.put("score", 90); //90이 어떻게 들어갈까? 기본형인데.
//		90은 auto boxing된다. 버전이 옛날버전이라면 new Integer(90) 이라 적어야.
		obj.put("addre",  "봉천동");
		
		
		System.out.println(obj.toJSONString());
		System.out.println("name: " + obj.get("name"));
		System.out.println("score: " + obj.get("score"));
		System.out.println("addre: " + obj.get("addre"));
//		어차피 key를 가지고 data를 제어한것이기 때문에 data의 order는 의미가 없다.
		
		// key를 알수 없는 경우------------------------------
		Set<String> set = obj.keySet();
		//java에서 꺽쇄 표시 - generic
		//set string 지정하면 casting 안해도됨
		Iterator<String> iter =  set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key);
		}
		
		//-------------------------------------------
		System.out.println("-".repeat(20));
		Test t1 = new Test();
		t1.setIrum("hong");
		t1.setScore(60);
		
		Test t2 = new Test();
		t2.setIrum("지매");
		t2.setScore(90);
		
		obj = new JSONObject();
		obj.put("o1", t1);
		obj.put("o2", t2);
		
		System.out.println(obj.toJSONString());
		// obj에 저장된 Test객체를 가져와 출력
		Test t3 = (Test)obj.get("o1");
		System.out.println("t3.irum : " + t3.getIrum());
		System.out.println("t3.score : " + t3.getScore());
		
		//key가 o2인 값을 Test t4에 저장하여 출력
		Test t4 = (Test)obj.get("o2");
		System.out.println("t4.irum : " + t4.getIrum());
		System.out.println("t4.score : " + t4.getScore());
		
		System.out.println("------------------------------");
		System.out.println("4. json array object");
		JSONArray array = new JSONArray();
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "박원기");
		obj2.put("phone", "010-1111-1111");
		array.add(obj2);
		array.add(obj2);
		array.add(obj2);
		
		for(Object o : array) {
			System.out.println(o);
		}
		for(Object o : array) {
			obj = (JSONObject) o;
			System.out.println(obj.toJSONString());
//			나머지는 교재에서..
		}
	}

	public static void main(String[] args) {
		new JavaObjectToJSON();
	}
}














