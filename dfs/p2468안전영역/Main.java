package dfs.p2468안전영역;

import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int count = 0;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = scr.nextInt();
			}
		}

		for (int h = 0; h <= 100; h++) {
			count = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!visited[i][j] && map[i][j] > h){
						count++;
						dfs(i, j, h);
					}
				}
			}
			if(max < count)
				max = count;
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					visited[i][j] = false;
				}
			}
		}
		
		System.out.println(max);
	}

	public static void dfs(int y, int x, int height) {
		visited[y][x] = true;

		if (y - 1 >= 1 && !visited[y - 1][x] && map[y - 1][x] > height) {
			dfs(y-1,x,height);
		}

		if (y + 1 <= N && !visited[y + 1][x] && map[y + 1][x] > height) {
			dfs(y+1,x,height);
		}

		if (x - 1 >= 1 && !visited[y][x - 1] && map[y][x - 1] > height) {
			dfs(y,x-1,height);
		}

		if (x + 1 <= N && !visited[y][x + 1] && map[y][x + 1] > height) {
			dfs(y,x+1,height);
		}
	}
}
