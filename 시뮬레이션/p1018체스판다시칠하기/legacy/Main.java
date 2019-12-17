package 시뮬레이션.p1018체스판다시칠하기.legacy;

import java.util.Scanner;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] copyMap;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		String input;
//		int T = scr.nextInt();
//		for (int a = 0; a < T; a++) {
			result = Integer.MAX_VALUE;
			N = scr.nextInt();
			M = scr.nextInt();
			scr.nextLine();

			map = new char[N][M];

			for (int i = 0; i < N; i++) {
				// input = scr.next();
				input = scr.nextLine();
				map[i] = input.toCharArray();
			}

			for (int i = 0; i <= N - 8; i++) {
				for (int j = 0; j <= M - 8; j++) {
					copyMap = new int[8][8];
					copy(j, i);

					// if (copyMap[i][j] == 0) {
					// copyMap[i][j] = 1;
					// paintBoard(1);
					// copy(j, i);
					// paintBoard(0);
					// } else {
					// copyMap[i][j] = 0;
					// paintBoard(1);
					// copy(j,i);
					// paintBoard(0);
					// }

					copyMap[0][0] = (copyMap[0][0] + 1) % 2;
					paintBoard(1);
					copy(j, i);
					paintBoard(0);
				}
			}
//			sb.append(result + "\n");
			System.out.println(result);
//		}
		
//		System.out.println(sb.toString());
	}

	public static void copy(int x, int y) {
		// System.out.println("X: " + x + ", Y: " + y);
		int width = x + 8;
		int height = y + 8;
		for (int i = y; i < height; i++) {
			for (int j = x; j < width; j++) {
				if (map[i][j] == 'W') {
					copyMap[i - y][j - x] = 1; // 1은 White
				} else {
					copyMap[i - y][j - x] = 0; // 0은 Black
				}
			}
		}
	}

	public static void paintBoard(int count) {
		for (int j = 0; j < 7; j++) {

			if (copyMap[j][0] == copyMap[j + 1][0]) {
				// System.out.println(copyMap[j][0] + ", " + copyMap[j + 1][0]);
				copyMap[j + 1][0] = (copyMap[j + 1][0] + 1) % 2;
				count++;
			}

			if (count > result) {
				return;
			}
		}

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				if (copyMap[i][j] == copyMap[i][j + 1]) {
					copyMap[i][j + 1] = (copyMap[i][j + 1] + 1) % 2;
					count++;
				}

				if (count > result) {
					return;
				}
			}
		}

		if (count < result) {
			result = count;
		}
	}
}

// 8 9
// BWBWBWBWB
// WBWBWBWBB
// BWBWBWBWB
// WBWBWBWBB
// BWBWBWBWB
// WBWBWBWBB
// BWBWBWBWB
// WBWBWBWBB
