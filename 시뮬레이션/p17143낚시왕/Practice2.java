package 시뮬레이션.p17143낚시왕;

import java.util.ArrayList;
import java.util.List;

public class Practice2 {
	public static void main(String[] args ) {
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(list1.get(1));
		
		System.out.println(list1);
		System.out.println(list2);
		
		list1.remove(1);
		
		System.out.println(list1);
		System.out.println(list2);
	}
}

class A {
	int a, b;
}
