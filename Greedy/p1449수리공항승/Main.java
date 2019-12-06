package Greedy.p1449수리공항승;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, L;
	static int[] brokenIndex;
	static int sideLen = 1; // 양쪽 0.5씩 더 붙여줬을때 길이
	static List<Integer> list = new ArrayList<>();
	static boolean[] check;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		L = scr.nextInt();

		brokenIndex = new int[1001];
		check = new boolean[1001];

		for (int i = 1; i <= N; i++) {
			brokenIndex[i] = scr.nextInt();
		}

		Arrays.sort(brokenIndex);

		for(int i=1;i<N;i++) {
			for(int j=i+1;j<=N;j++) {
				
			}
		}

		Collections.sort(list, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1 > o2) {
					return -1;
				} else if (o1 < o2) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		
		
	}
}

/*
 * 4 3
 * 1 2 3 5 6 7 8 
 * 
 */
