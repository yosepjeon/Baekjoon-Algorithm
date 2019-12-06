package 시뮬레이션.p1021회전하는큐;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] goalIndex;
	static boolean[] checkGetElements;
	static int result = Integer.MAX_VALUE;
	static Deque<Integer> dq = new LinkedList<>();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		Deque<Integer> tempdq;

		N = scr.nextInt();
		M = scr.nextInt();

		goalIndex = new int[M + 1];
		checkGetElements = new boolean[N + 1];

		for (int i = 1; i <= M; i++) {
			goalIndex[i] = scr.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			dq.addLast(i);
		}
		
		System.out.println(dq);

		for (int i = 1; i <= 3; i++) {
			if(i == 1){
				run(0, i, 0);
			}
			
			if(i == 2) {
				run(1,i,0);
			}
			
			if(i == 3) {
				run(1,i,0);
			}
		}
		
		System.out.println(result);
	}

	public static void run(int count, int select, int getCount) {
		int cnt = getCount;
		int elem = 0;

		if (result <= count) {
//			System.out.println("result: " + result + " count: " + count);
//			System.out.println("return");
			return;
		} else {
			if (getCount == goalIndex.length-1) {
				System.out.println("goalIndex.length: " + goalIndex.length);
				if (result >= count) {
					result = count;
				}
				return;
			} else {
				switch (select) {
				case 1:
//					System.out.println(dq);
					System.out.println("cnt: " + cnt);
					elem = dq.pollFirst();

//					for (int i = 1; i <= M; i++) {
//						if (elem == goalIndex[i]) {
//							System.out.println(elem);
//							cnt++;
//							break;
//						}
//					}
					
					
					break;
				case 2:
					elem = dq.pollFirst();
					dq.addLast(elem);
					break;
				case 3:
					elem = dq.pollLast();
					dq.addFirst(elem);
					break;
				}

				for (int i = 1; i <= 3; i++) {
					if(i == 1) {
						run(count, i, cnt);
						dq.addFirst(elem);
						System.out.println("select1: " + dq);
					}else if(i == 2) {
						run(count+1, i, cnt);
						elem = dq.pollLast();
						dq.addFirst(elem);
						System.out.println("select2: " + dq);
					}else if(i == 3) {
						run(count+1, i, cnt);
						elem = dq.pollFirst();
						dq.addLast(elem);
						System.out.println("select3" +dq);
					}
				}
			}
		}
	}
}
