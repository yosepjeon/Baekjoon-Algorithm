package 완전탐색.p3085사탕게임;

import java.util.Scanner;

public class Main {
	static int N;
	static char[][] map;
	static int max = Integer.MIN_VALUE;
	static int count = 1;
	static Scanner scr;
	static int R = 0, B = 0, G = 0, Y = 0;

	public static void main(String[] args) {
		input();

		startLogic();
	}

	// Logic Methods
	public static void input() {
		scr = new Scanner(System.in);
		String input;
		N = scr.nextInt();
		char[] carr = new char[N];

		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			input = scr.next();
			carr = input.toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = carr[j];
			}
		}

	}

	public static void startLogic() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				countCandy(j, i);
			}
		}

		if (max == Integer.MIN_VALUE)
			max = 1;

		System.out.println(max);
	}

	public static void showMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println(max);
		System.out.println();
	}

	public static void swapCandy(Index i1, Index i2) {
		char temp = map[i1.y][i1.x];
		map[i1.y][i1.x] = map[i2.y][i2.x];
		map[i2.y][i2.x] = temp;
	}

	public static void countCandy(int x, int y) {
		if (y - 1 >= 0) {
			if (map[y][x] != map[y - 1][x]) {
				swapCandy(new Index(x, y), new Index(x, y - 1));
				count(x, y);
				swapCandy(new Index(x, y), new Index(x, y - 1));
				InitiateCount();
			}
		}

		if (y + 1 < N) {
			if (map[y][x] != map[y + 1][x]) {
				swapCandy(new Index(x, y), new Index(x, y + 1));
				count(x, y);
				swapCandy(new Index(x, y), new Index(x, y + 1));
				InitiateCount();
			}
		}

		if (x - 1 >= 0) {
			if (map[y][x] != map[y][x - 1]) {
				swapCandy(new Index(x, y), new Index(x - 1, y));
				count(x, y);
				swapCandy(new Index(x, y), new Index(x - 1, y));
				InitiateCount();
			}
		}

		if (x + 1 < N) {
			if (map[y][x] != map[y][x + 1]) {
				swapCandy(new Index(x, y), new Index(x + 1, y));
				count(x, y);
				swapCandy(new Index(x, y), new Index(x + 1, y));
				InitiateCount();
			}
		}
	}

	public static void count(int x, int y) {
//		showMap();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					count++;
				} else {
					if (max < count) {
						max = count;
					}
					count = 1;
				}
			}
			if (max < count) {
				max = count;
			}
			
			count = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (map[j][i] == map[j + 1][i])
					count++;
				else {
					if (max < count) {
						max = count;
					}
					count = 1;
				}
			}
			if (max < count) {
				max = count;
			}

			count = 1;
		}
	}

	public static void InitiateCount() {
		count = 1;
	}
}

class Index {
	int x, y;

	public Index(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 3
// YCP
// CZY
// ZCP

// 4
// CYPC
// ZZZC
// YCYP
// PCPC

// 6
// CCYYCC
// YYCCYY
// CCYYCC
// YYCCYY
// CCYYCC
// YYCCYY