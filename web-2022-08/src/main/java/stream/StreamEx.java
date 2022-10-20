package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamEx {
	public StreamEx() {
		//List
		String[] str = {"강아지","송아지","망아지","호랑이","고양이"};
		List<String> list = new ArrayList<String>(Arrays.asList(str));
		Stream<String> stream = list.stream();
		stream.forEach(x->System.out.println(x));
		
		System.out.println("-".repeat(20));
		list.forEach(x->System.out.println(x));
		
		//Array
		System.out.println("-".repeat(20));
		stream = Arrays.stream(str);
		stream.forEach(abc->System.out.println(abc));
		
		//Map<K,V>
		System.out.println("-".repeat(20));
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaaa", "kim");
		map.put("bbbb", "lee");
		map.put("cccc", "park");
		map.put("dddd", "hong");
		
		map.forEach( (key,value)->{
			System.out.printf("%s : %s \n", key, value);
		});
		
		//map()
		System.out.println("-".repeat(20));
		List<String> list1 = Arrays.asList("abc", "Abc", "aBC" , "abC");
		Stream stream1 = list1.stream().map(x->x.toUpperCase());
		stream1.forEach(x -> System.out.print(x + ","));
		System.out.println();
		
		//distinct()
		System.out.println("-".repeat(20));
		List<Integer> list2 = Arrays.asList(1,2,3,4,3,4,5,6);
		Stream stream2 = list2.stream();
		stream2.distinct().forEach(x ->System.out.print(x));
		
		//filter()
		
		System.out.println();
		System.out.println("-".repeat(20));
		List<Integer> list3 = Arrays.asList(1,2,3,4,3,4,5,6);
		Stream stream3 = list3.stream().filter(x->x>4);
		stream3.forEach(x ->System.out.print(x + ""));
		
		//sorted()
		System.out.println();
		System.out.println("-".repeat(20));
		List<Integer> list4 = Arrays.asList(6,5,8,9,4,3,2,1,7);
		Stream stream4 = list4.stream().sorted();
		stream4.forEach(x->System.out.println(x+""));
		
		//match()
		System.out.println("-".repeat(20));
		List<Integer> list5 = Arrays.asList(6,5,8,9,4,3,2,1,7);
		boolean b1 = list5.stream().allMatch(x -> x%2==0);
		System.out.println("모두 짝수인가?" + b1);
		
		Stream stream5 = list5.stream();
		boolean b2 = list5.stream().allMatch(x->x<10);
		System.out.println("모두 10보다 작은가?" + b2);
		
		
		//sum(), count(), average(), max(), min()
		//reduce()
		//collect()
		
	}
	
	public static void main(String[] args) {
		new StreamEx();
	}
}
