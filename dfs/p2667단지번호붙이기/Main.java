package dfs.p2667단지번호붙이기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int size = 0;
	static int count = 0;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		String str;
		char carr[];

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			str = scr.next();
			carr = str.toCharArray();

			for (int j = 1; j <= N; j++) {
				map[i][j] = (int) (carr[j-1] - '0');
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				size = 0;
				if (!visited[i][j] && map[i][j] == 1) {
					count++;
					dfs(i, j);
					list.add(size);
				}
			}
		}
		
		Collections.sort(list);
		
		System.out.println(count);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

	public static void dfs(int y, int x) {
		size++;
		visited[y][x] = true;

		if (y + 1 <= N && !visited[y + 1][x] && map[y + 1][x] == 1) {
			dfs(y + 1, x);
		}

		if (y - 1 >= 1 && !visited[y - 1][x] && map[y - 1][x] == 1) {
			dfs(y - 1, x);
		}

		if (x + 1 <= N && !visited[y][x + 1] && map[y][x + 1] == 1) {
			dfs(y, x + 1);
		}

		if (x - 1 >= 1 && !visited[y][x - 1] && map[y][x - 1] == 1) {
			dfs(y, x - 1);
		}
	}
}
