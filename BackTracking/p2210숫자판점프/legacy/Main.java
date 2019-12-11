package BackTracking.p2210숫자판점프.legacy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int[][] map = new int[5][5];
	static Map<Integer, Integer> valueMap = new HashMap<>();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				map[i][j] = scr.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i, j, 1, "");
			}
		}
		
		System.out.println(valueMap.size());
	}

	public static void dfs(int y, int x, int count, String str) {
		if (count > 6) {
			int elem = Integer.valueOf(str);
			if(valueMap.getOrDefault(elem, null) == null) {
				valueMap.put(elem, elem);
			}
		} else {
			str += map[y][x];

			// 상
			if (y - 1 >= 0) {
				dfs(y - 1, x, count + 1, str);
			}

			// 하
			if (y + 1 < 5) {
				dfs(y + 1, x, count + 1, str);
			}

			// 좌
			if (x - 1 >= 0) {
				dfs(y, x - 1, count + 1, str);
			}
			// 우
			if (x + 1 < 5) {
				dfs(y, x + 1, count + 1, str);
			}
		}
	}
}
