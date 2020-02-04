package 시뮬레이션.p1021회전하는큐;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		int elem;
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=1;i<=10;i++) {
			list.addLast(i);
		}
		
		for(int i=10;i%10>=0;i--) {
			System.out.println(list.get(i%10));
		}
		
//		list.forEach((element) -> {
//			if(element%2 == 0)
//				list.remove(element);
//		});
//		
//		list.forEach((element) -> {
//			System.out.println(element);
//		});
	}
}
