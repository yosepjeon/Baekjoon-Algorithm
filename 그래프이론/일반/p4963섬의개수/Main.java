package 그래프이론.일반.p4963섬의개수;

import java.util.Scanner;

public class Main {
	static int row, col;
	static Scanner scr = new Scanner(System.in);
	static int[][] map;
	static boolean[][] visited;
	static int count = 0;

	public static void main(String... args) {
		StringBuffer sb = new StringBuffer();

		while (true) {
			col = scr.nextInt();
			row = scr.nextInt();
			count = 0;

			if (col == 0 && row == 0)
				break;

			map = new int[row][col];
			visited = new boolean[row][col];

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					map[i][j] = scr.nextInt();
				}
			}

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (!visited[i][j] && map[i][j] != 0) {
						count++;
						dfs(i, j);
					}
				}
			}
			
			sb.append(count + "\n");

		}
		
		System.out.println(sb.toString());
	}

	public static void dfs(int r, int c) {
		if (visited[r][c] || map[r][c] == 0) {
			return;
		}

		visited[r][c] = true;

		// 동
		if (c + 1 < col && !visited[r][c + 1]) {
			dfs(r,c+1);
		}
		// 서
		if (c - 1 >= 0 && !visited[r][c - 1]) {
			dfs(r,c-1);
		}

		// 남
		if (r + 1 < row && !visited[r + 1][c]) {
			dfs(r+1,c);
		}
		// 북
		if (r - 1 >= 0 && !visited[r - 1][c]) {
			dfs(r-1,c);
		}
		
		// 북동
		if(r-1 >= 0 && c+1 < col && !visited[r-1][c+1]) {
			dfs(r-1,c+1);
		}
		// 북서
		if(r-1 >= 0 && c-1 >= 0 && !visited[r-1][c-1]) {
			dfs(r-1,c-1);
		}
		
		// 남동
		if(r+1 < row && c+1 < col && !visited[r+1][c+1]) {
			dfs(r+1,c+1);
		}
		
		// 남서
		if(r+1 < row && c-1 >= 0 && !visited[r+1][c-1]) {
			dfs(r+1,c-1);
		}
	}
}
