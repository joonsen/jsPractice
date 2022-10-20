package array;

import java.util.Arrays;

public class ObjectArraySort {

	public static void main(String[] args) {
		Data2[] a = new Data2[3];
		//		int[] b = new int[10];
		//정수형을 저장하는 배열이냐? Data2 type을 저장하는 배열이냐? 의 difference
		a[0] = new Data2("kim", 90);
		a[1] = new Data2("lee", 95);
		a[2] = new Data2("park", 65);
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
}




























