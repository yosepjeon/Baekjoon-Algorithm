package dfs.p1707이분그래프;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice {
	public static void main(String[] arsg) {
		Scanner scr = new Scanner(System.in);
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		queue.add(5);
		queue.add(2);
		queue.add(3);
		queue.add(1);
		queue.add(4);
		
		Collections.sort(queue, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2) {
					return 1;
				}else if(o1 < o2) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		System.out.println(queue);
	}
}

