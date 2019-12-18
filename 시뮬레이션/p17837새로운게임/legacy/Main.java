package 시뮬레이션.p17837새로운게임.legacy;

import java.util.Scanner;

public class Main {
	static int N, K;
	static int[][] map;
	static Element[] elements;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		K = scr.nextInt();

		map = new int[N][N];
		elements = new Element[K];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scr.nextInt();
			}
		}

		for (int i = 0; i < K; i++) {
			int y = scr.nextInt();
			int x = scr.nextInt();
			int direction = scr.nextInt();
			elements[i] = new Element(y, x, direction);
		}
		
		
	}
}

class Element {
	int y, x, direction; // 1-r 2-l 3-u 4-d

	public Element(int y, int x, int direction) {
		this.y = y;
		this.x = x;
		this.direction = direction;
	}
}
