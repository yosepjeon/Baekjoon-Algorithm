package 시뮬레이션.p1018체스판다시칠하기.legacy;

import java.util.Scanner;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] copyMap;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		String input;

		N = scr.nextInt();
		M = scr.nextInt();
		scr.nextLine();

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			input = scr.next();
			map[i] = input.toCharArray();
		}

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				copyMap = new int[8][8];
				copy(j, i);
				copyMap[i][j] = 0;
				paintBoard(0);
				copy(j, i);
				copyMap[i][j] = copyMap[0][0] + 1 % 2;
				paintBoard(0);
			}
		}

		System.out.println(result);
	}

	public static void copy(int x, int y) {
		// System.out.println("X: " + x + ", Y: " + y);
		int width = x + 8;
		int height = y + 8;
		for (int i = y; i < height; i++) {
			for (int j = x; j < width; j++) {
				if (map[i][j] == 'W') {
					copyMap[i - y][j - x] = 1; // 0은 Black
				} else {
					copyMap[i - y][j - x] = 0; // 1은 White
				}

				// System.out.print(copyMap[i-y][j-x]);
			}
			// System.out.println();
		}
	}

	public static void paintBoard(int count) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				if (copyMap[i][j] == copyMap[i][j + 1]) {
					copyMap[i][j + 1] = copyMap[i][j] + 1 % 2;
					count++;
				}

				if (copyMap[j][i] == copyMap[j + 1][i]) {
					copyMap[j + 1][i] = copyMap[j][i] + 1 % 2;
					count++;
				}
			}
		}
		
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 7; j++) {
//				
//
//				if (copyMap[j][i] == copyMap[j + 1][i]) {
//					copyMap[j + 1][i] = copyMap[j][i] + 1 % 2;
//					count++;
//					// if (copyMap[j][i] == 'B') {
//					// copyMap[j + 1][i] = 'W';
//					// result++;
//					// } else {
//					// copyMap[j + 1][i] = 'B';
//					// result++;
//					// }
//				}
//			}
//		}
		
		if (count < result) {
			result = count;
		}
	}
}
