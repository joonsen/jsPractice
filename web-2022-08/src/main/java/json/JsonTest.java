package json;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonTest {

	public void stringToJSON() throws Exception {
		//method name은 무조건 소문자로 시작
		//----------------------------------
	    System.out.println("1. 정수형 배열을 JSONArray");
		String JsonInt = "[1,2,3,4,5]"; //배열이면 list 구조로. map
		//json구조는 문자열로 들어와
		JSONParser jParser = new JSONParser();
		Object o = jParser.parse(JsonInt);
		JSONArray jArray = (JSONArray)o;
		
		System.out.println(jArray.toJSONString());
		
		for(int i=0; i<jArray.size(); i++) {
			Long s =(Long)jArray.get(i);
			System.out.printf("%d : %d\n", i ,s);
		}
		//------------------------------------------
		System.out.println("-".repeat(20));
		System.out.println("2. 문자열배열을 JSONArray");
		
		String jsonString = "['a','b','1','c']"; //편의상 이렇게 쓰고있지만 parsing 전 큰따옴표로 바꿔줘야한다.
		jsonString = jsonString.replace("'","\"");
		jArray = (JSONArray)jParser.parse(jsonString);
		
		System.out.println(jArray.toJSONString());
		for(int i=0; i<jArray.size(); i++) {
			System.out.printf("%d : %s\n", i ,jArray.get(i));
		}
		
		//------------------------------------------
		System.out.println("-".repeat(20));
		System.out.println("3. map구조를 JSONObject");
		String jsonMap = "{'name' : 'hong', 'age' : '20'}";
		jsonMap = jsonMap.replaceAll("'", "\"");
		JSONObject jObject = (JSONObject)jParser.parse(jsonMap);
		System.out.println("name:" + jObject.get("name") );
		System.out.println("age: " + jObject.get("age") );
		// ---------------------------------------------
		System.out.println("-".repeat(20));
		String jsonListMap = "[{'name':'hong', 'addr':'서울'}, "
			+ "{'name':'kim', 'addr':'부산'}]";
		jsonListMap = jsonListMap.replace("'","\"");
		jArray = (JSONArray)jParser.parse(jsonListMap);
		for(Object o2 : jArray) {
			JSONObject job = (JSONObject)o2;
			System.out.println("name: " + job.get("name"));
			System.out.println("addr: " + job.get("addr"));
		}
		//--------------------------------------------
		System.out.println("-".repeat(20));
		jsonString = "{'names' : ['a','b','c','d']}"; //java는 이런 value를 반드시 String 처리 해야한다
		jsonString = jsonString.replace("'", "\"");
		jObject = (JSONObject) jParser.parse(jsonString); //casting 형변환
		Object value = jObject.get("names");
		jArray = (JSONArray)value;
		for(Object ob : jArray) {
			System.out.println(ob);
		}		//교재엔 안나왔지만 이렇게 for로 찍을수도 있다
		
		//------------------------------------------
		jsonString = "[ {'names': ['a','b','c']}, "
		             +"  {'ages':  [5,6,7]} ]";
		jsonString = jsonString.replace("'","\"");
		jArray = (JSONArray)jParser.parse(jsonString);
		System.out.println(jArray.toJSONString());
		for(int i=0; i<jArray.size(); i++) {
			jObject = (JSONObject) jArray.get(i);
			Iterator<String> iter = jObject.keySet().iterator();
			while(iter.hasNext()) {
				String key = (String)iter.next();
				JSONArray values = (JSONArray)jObject.get(key);
				System.out.println(values.toJSONString());
			}
		} // 첨자가 필요없을때
		for(Object ob : jArray) {
			
		} // 첨자가 필요할때
	}
	public static void main(String[] args) {
		JsonTest abc = new JsonTest();
		try {
			abc.stringToJSON();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
