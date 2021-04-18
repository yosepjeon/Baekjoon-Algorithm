package 그래프이론.일반.p1507궁금한민호;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static int[][] map2;
	
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		N = scr.nextInt();
		
		map = new int[N][N];
		map2 = new int[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0; j<N;j++) {
				int n = scr.nextInt();
				map[i][j] = n;
				map2[i][j] = n;
			}
		}
		
		boolean result = findMinEdge();
		
		if(!result) {
			System.out.println(-1);
			return;
		}
		
		int total = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
//				System.out.print(map2[i][j] + " ");
				total += map2[i][j];
			}
//			System.out.println();
		}
		
		System.out.println(total/2);
	}
	
	public static boolean findMinEdge() {
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(i == k || j == k) continue;
					
					if(map[i][j] == map[i][k] + map[k][j]) {
						
						map2[i][j] = 0;
					}
					
					if(map[i][j] > map[i][k] + map[k][j]) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
}
