package 시뮬레이션.p1021회전하는큐;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		int elem;
		Deque<Integer> dq = new LinkedList<>();
		
		for(int i=1;i<=10;i++) {
			dq.addLast(i);
		}
		
		elem = dq.pollFirst();
		dq.addLast(elem);
		
		System.out.println(dq.peekFirst());
	}
}
