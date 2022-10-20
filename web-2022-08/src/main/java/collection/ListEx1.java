package collection;

import java.util.ArrayList;
import java.util.List;

import array.Data;

public class ListEx1 {
	public void test1() {
		List<String> list = new ArrayList<String>();
		//추가
		list.add("kim");
		list.add("lee");
		list.add("hong");
		list.add("park");
		list.add("choi");
		System.out.println(list);
		System.out.println(list.get(2));
		// 수정(hong -> gang)
		list.set(2,  "gang");
		System.out.println(list);
		
		// 조회
		int index = list.indexOf("choi");
		System.out.println("index = " + index);
		boolean b = list.contains("ga");
		System.out.println("b");
		
		//삭제;
		list.remove(4);
		System.out.println(list);
		list.remove("gang");
		System.out.println(list);
		
		
	}
	
	public void test2() {
		List<Data> list = new ArrayList<Data>();
		Data1 d = new Data1("a001","kim",18);
		//list.add(d);
		//list.add(new Data1("b001","hong",20));
		//list.add(new Data1("c001","park",15));
		
		//수정
		String findId = "b001";
		int index = list.indexOf(findId);
		System.out.println("index=" + index);
		boolean b = list.contains(findId);
		System.out.println(b);
		
	}
	
	public static void main(String[] args) {
		new ListEx1().test1();

	}
}
