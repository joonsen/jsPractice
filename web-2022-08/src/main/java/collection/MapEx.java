package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx {
	public void test1() {
		Map<String, String> hm = new HashMap<String,String>();
		//입력
		hm.put("a1", "aaaa");
		hm.put("a2", "bbbb");
		hm.put("a3", "cccc");
		System.out.println(hm);
		//수정
		hm.put("a2", "홍길동");
		System.out.println(hm);
		//삭제
		hm.remove("a2");
		System.out.println(hm);
		//조회(key): 키를 알고있는 경우
		System.out.println(hm.get("a1"));
		System.out.println(hm.get("a3"));
		
		//키를 모를 때
		System.out.println("-".repeat(25));
		Set<String> set = hm.keySet();	//set 구조는 index란 개념이 없다 -> iterator를 만들거다
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(hm.get(key));
		}		
		//value들만 필요할 때
		System.out.println("values.........");
		Collection<String> values = hm.values();
		iter = values.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}		//set map 구조는 수단방법을 가리지않고 iterator를 만드는게 최선이다. 그렇지 못하면 접근이 상당히 까다롭다
		
		//Map.Entry
		Set<Map.Entry<String, String>> set2 = hm.entrySet();  //set구조가 가지고있는 generic
		Iterator<Map.Entry<String, String>> iter2 = set2.iterator();	//iterator의 String대신 Map.Entry가 들어갔을뿐
		while(iter2.hasNext()) {
			Map.Entry  entry = iter2.next();
			System.out.println(entry.getKey() + "," + entry.getValue());
		}		//너무 복잡하다? -> 버리셔도 됩니다
		// value 값이 Data 클래스
		Map<String, Data> hm3 = new HashMap<String, Data>();
		hm3.put("a001", new Data("a001","hong", 18));
		hm3.put("b001", new Data("b001", "kim", 20));
		hm3.put("c001", new Data("c001", "park", 30));
		// key값을 기준으로
		Set<String> set3 = hm3.keySet();	//set구조는 순서가 없기 때문에 index가 없음
		Iterator<String> iter3 = set3.iterator();
		while(iter3.hasNext()) {
			String key = iter3.next();
			Data d = hm3.get(key);
			System.out.println(d);   //순서가 중요하다 하면 set이나 map구조를 절대 쓰면 안돼 그냥 list에 저장
		}
	
	}
	
	public static void main(String[] args) {
		new MapEx().test1();
	}
}
