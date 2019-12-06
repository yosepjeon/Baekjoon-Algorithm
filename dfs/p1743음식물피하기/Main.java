package dfs.p1743음식물피하기;

import java.util.Scanner;

public class Main {
	static int N,M,K;
	static int[][] map;
	static boolean[][] visited;
	static int count = 0;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		int r,c;
		
		N = scr.nextInt();
		M = scr.nextInt();
		K = scr.nextInt();
		
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				map[i][j] = 0;
			}
		}
		
		for(int i=0;i<K;i++) {
			r = scr.nextInt();
			c = scr.nextInt();
			map[r][c]  = 1;
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					count = 0;
					dfs(i,j);
					if(max < count)
						max = count;
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static void dfs(int y,int x) {
		visited[y][x] = true;
		count++;
		
		if(y-1>=1 && !visited[y-1][x] && map[y-1][x] == 1) {
//			visited[y][x] = true;
			dfs(y-1,x);
		}
		
		if(y+1<=N && !visited[y+1][x] && map[y+1][x] == 1) {
//			visited[y][x] = true;
			dfs(y+1,x);
		}
		
		if(x-1 >= 1 && !visited[y][x-1] && map[y][x-1] == 1) {
//			visited[y][x] = true;
			dfs(y,x-1);
		}
		
		if(x+1 <= M && !visited[y][x+1] && map[y][x+1] == 1) {
//			visited[y][x] = true;
			dfs(y,x+1);
		}
	}
}
