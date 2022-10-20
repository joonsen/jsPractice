package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetEx {
	
	public void test1() {//CRUD
		Set<String> hs = new HashSet<String>();
		//추가할때 쓰는 명령어 add
		hs.add("kim");
		hs.add("hong");
		hs.add("park");
		hs.add("nam");
		//수정(remove -> add)
		hs.remove("park");
		hs.add("gang");
		System.out.println(hs.toString());
		//입력된 순서와 출력순서는 같지않다. set은 어떤 데이터를 입력하느나와 상관없이 출력순서는 알수없다.
		//조회(순차접근) Set -> Iterator ->hasNext, next
		System.out.println("-".repeat(25));
		Iterator<String> iter = hs.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
		
	}
	
	public void test2() {//중복값 제거 후 출력
		Integer[] a = {1,31,41,32,290,34,1,6,3,921,912};
		Integer[] b = {1,315,5,252,11234};
		
		List<Integer> aa = new ArrayList<Integer>(Arrays.asList(a));
		List<Integer> bb = new ArrayList<Integer>(Arrays.asList(b));
		
		//합집합
		System.out.println(aa);
		aa.addAll(bb);
		System.out.println(aa);
		System.out.println(bb);
		
		//중복제거
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(aa);
		System.out.println("set: " + set.toString());
	}
	
	public void test3() {	//요소의 개수를 count
		Integer[] su = {1,1,1,2,3,3,4,4,4,4,5,6,7,7,7};
		List<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(su));
		
		Set<Integer> set = new HashSet(list);
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			int cnt = Collections.frequency(list, i);
			System.out.printf("%d - %d\n", i, cnt);
		}
		
		
	}
	/*
	 * score의 값을 사용하여 각 학점대의 명수를 출력 
	 */
	public void test4() {
		Integer[] score = {90,90,70,70,50,50,80,40,30};
		List<Integer> list = new ArrayList<Integer>();
		
		for(Integer i : score) {
			list.add(Math.floorDiv(i, 10));
		}
		
		Set<Integer> set = new HashSet<Integer>(list);
		Iterator<Integer> iter =set.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			int cnt = Collections.frequency(list, i);
			System.out.printf("%d~ : %d명\n", (i*10), cnt);
		}
	}
	
	public static void main(String[] args) {
		new SetEx().test4();
	}
}























