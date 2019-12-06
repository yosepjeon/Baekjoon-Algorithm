package PriorityQueue.p2075N번쨰큰수;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1 < o2) {
					return 1;
				} else if (o1 > o2) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		int N;
		int[][] map;
		int result = 0;

		N = scr.nextInt();

		map = new int[N][N];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int n = scr.nextInt();
				pq.add(n);
			}
		}
		
		for(int i=1;i<=N;i++) {
			result = pq.poll();
		}
		
		System.out.println(result);

	}
}
