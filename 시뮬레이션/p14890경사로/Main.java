package 시뮬레이션.p14890경사로;

import java.util.Scanner;

public class Main {
	static int N, L;
	static int[][] map;
	static boolean[][] ramp;
	static int count = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		L = scr.nextInt();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scr.nextInt();
			}
		}

		checkFromUpToDown();
		checkFromLeftToRight();

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(ramp[i][j] + " ");
//			}
//			System.out.println();
//		}

		System.out.println(count);
	}

	@SuppressWarnings("unused")
	public static void checkFromUpToDown() {
		int y = 0, x = 0;
		ramp = new boolean[N][N];

		for1: for (int i = 0; i < N; i++) {
			boolean isRoot = true;
			for2: for (int j = 0; j < N - 1; j++) {
				if (map[j][i] == map[j + 1][i]) {
					x = i;
					y = j;
					continue;
				}

				if (map[j][i] > map[j + 1][i]) {
					if (map[j][i] - map[j + 1][i] != 1 || (N - (j + 1)) < L) {
						isRoot = false;
						break for2;
					}

					if (L == 1) {
						if (!ramp[j + 1][i]) {
							ramp[j + 1][i] = true;
							continue;
						} else {
							isRoot = false;
							break for2;
						}
					}
					for (int k = 0; k < L - 1; k++) {
						if (map[j + 1 + k][i] == map[j + 1 + k + 1][i]
								&& (/* !ramp[j + 1 + k][i] && */ !ramp[j + 1 + k + 1][i])) {
							ramp[j + 1 + k][i] = true;
							ramp[j + 1 + k + 1][i] = true;
							continue;
						} else {
							isRoot = false;
							// System.out.println("break point : x=" + i + " y="
							// + j);
							break for2;
						}
					}
				}

				if (map[j][i] < map[j + 1][i]) {
					if (map[j + 1][i] - map[j][i] != 1 || (j + 1) < L) {
						isRoot = false;
						break for2;
					}

					if (L == 1) {
						if (!ramp[j][i]) {
							ramp[j][i] = true;
							continue;
						} else {
							isRoot = false;
							break for2;
						}
					}
					for (int k = 0; k < L - 1; k++) {
						if (map[j - k][i] == map[j - k - 1][i]
								&& (/* !ramp[j - k][i] && */ !ramp[j - k - 1][i])) {
							ramp[j - k][i] = true;
							ramp[j - 1 - k][i] = true;
							continue;
						} else {
							isRoot = false;
							// System.out.println("break point : x=" + i + " y="
							// + j);
							break for2;
						}
					}
				}
			}

			if (isRoot) {
//				System.out.println("x: " + x);
				count++;
			}
		}
	}

	@SuppressWarnings("unused")
	public static void checkFromLeftToRight() {
		int y = 0, x = 0;
		ramp = new boolean[N][N];

		for1: for (int i = 0; i < N; i++) {
			boolean isRoot = true;
			for2: for (int j = 0; j < N - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					y = i;
					x = j;
					continue;
				}

				if (map[i][j] > map[i][j + 1]) {
					if (map[i][j] - map[i][j + 1] != 1 || (N - (j + 1)) < L) {
						isRoot = false;
						break for2;
					}

					if (L == 1) {
						if (!ramp[i][j + 1]) {
							ramp[i][j + 1] = true;
							continue;
						} else {
							isRoot = false;
							break for2;
						}
					}
					for (int k = 0; k < L - 1; k++) {
						if (map[i][j + 1 + k] == map[i][j + 1 + k + 1]
								&& (/* !ramp[i][j + 1 + k] && */ !ramp[i][j + 1 + k + 1])) {
							ramp[i][j + 1 + k] = true;
							ramp[i][j + 1 + k + 1] = true;
							continue;
						} else {
							isRoot = false;
							// System.out.println("break point : x=" + i + " y="
							// + j);
							break for2;
						}
					}
				}

				if (map[i][j] < map[i][j + 1]) {
					if (map[i][j + 1] - map[i][j] != 1 || (j + 1) < L) {
						isRoot = false;
						break for2;
					}

					if (L == 1) {
						if (!ramp[i][j]) {
							ramp[i][j] = true;
							continue;
						} else {
							isRoot = false;
							break for2;
						}
					}
					for (int k = 0; k < L - 1; k++) {
						if (map[i][j - k] == map[i][j - k - 1]
								&& (/* !ramp[i][j - k] && */ !ramp[i][j - k - 1])) {
							ramp[i][j - k] = true;
							ramp[i][j - 1 - k] = true;
							continue;
						} else {
							isRoot = false;
							// System.out.println("break point : x=" + i + " y="
							// + j);
							break for2;
						}
					}
				}
			}

			if (isRoot) {
//				System.out.println("y: " + y);
				count++;
			}
		}
	}
}
