package json;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONExam {

	public void test1() throws ParseException {
		System.out.println("1. 정수형 배열을 JSONArray");
		String JsonScr ="[44,33,55,65,78]";
		JSONParser jParser = new JSONParser();
		Object o = jParser.parse(JsonScr);
		JSONArray jArray = (JSONArray)o;
		
		System.out.println(jArray.toJSONString());
		
		double sum=0, avg=0;
		for(int i=0; i<jArray.size(); i++) {
			Long s = (Long)jArray.get(i);
			sum += s;
			avg = sum/jArray.size();
		}
		System.out.println(sum);
		System.out.println(avg);
		
		//-----------------------------------------
		
		System.out.println("-".repeat(20));
		System.out.println("2. map구조를 JSONObject");
		String jsonMap = "[{'id' : 'hong', 'name' : '길동'},"
				+ "{'phone' : '010-2222'}]";
		jsonMap = jsonMap.replaceAll("'", "\"");
		
		
	}
	
	
	public static void main(String[] args) {
		JSONExam je = new JSONExam();
		try {
			je.test1();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
