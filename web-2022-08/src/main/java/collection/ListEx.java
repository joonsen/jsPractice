package collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;


public class ListEx {
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
		Data d = new Data("a001","kim",18);
		list.add(d);
		list.add(new Data("b001","hong",20));
		list.add(new Data("c001","park",15));
		
		//수정
		String findId = "b001";
		int index = list.indexOf(findId);
		System.out.println("index=" + index);
		boolean b = list.contains(findId);
		System.out.println(b);
		for(int i=0; i<list.size(); i++) {
			Data temp = list.get(i);
			if(temp.getId().equals(findId)) {
				index = i;
				break;
			}
		}
		list.set(index, new Data("d001","gang",30));
		System.out.println(list);
		
		//수정(II)
		Data temp = new Data("c001", "", 0);
		index = list.indexOf(temp);
		System.out.println("new index =" + index);
		b = list.contains(temp);
		System.out.println("contains = " + b);
		
		//삭제
		list.remove(temp);
		System.out.println(list);
		
	}
	
	public void test3() {	//교집합
		Integer[] a = {1,2,3,4,5,6,7};
		Integer[] b = {4,5,6,7,8,9};
		List<Integer> list = new Vector<Integer>();
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<b.length; j++) {
				if(a[i] == b[j]) {
					System.out.printf("%4d",a[i]);
					list.add(a[i]);
					break;
				}
			}
		}
		System.out.println();
		System.out.println(list);
		//retainAll
		List<Integer> aa = new ArrayList<Integer>(Arrays.asList(a));
		List<Integer> bb = new ArrayList<Integer>(Arrays.asList(b));
		aa.retainAll(bb);
		System.out.println("retainAll : " + aa);
		
	}
	// Vector의 기능?
	
	public static void main(String[] args) {
				new ListEx().test3();
	}
}
