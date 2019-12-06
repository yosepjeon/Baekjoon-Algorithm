package BackTracking.p1405미친로봇;

import java.util.Scanner;

public class Main {
	static int n;
	static double[] directions = new double[4];
	static double E, W, S, N;
	static boolean[][] map = new boolean[29][29];
	static int curX = 14, curY = 14;
	static double result = 0;
	static int cnt = 1;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		n = scr.nextInt();
		E = scr.nextDouble();
		W = scr.nextDouble();
		S = scr.nextDouble();
		N = scr.nextDouble();

		directions[0] = E / 100;
		directions[1] = W / 100;
		directions[2] = S / 100;
		directions[3] = N / 100;

		map[curY][curX] = true;

		for (int i = 0; i < 4; i++) {
			dfs(i, 0, 1);
		}

//		for(int i=0;i<29;i++) {
//			for(int j=0;j<29;j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.printf("%.10f", result);
	}

	public static void dfs(int direction, int count, double value) {
		if (count == n) {
			// System.out.println(cnt++);
			if (map[curY][curX]) {
				result += value;
				map[curY][curX] = false;
			}
		} else {
			activeDirection(direction);

			if (!map[curY][curX]) {
				map[curY][curX] = true;
				for (int i = 0; i < 4; i++) {
					dfs(i, count + 1, value * directions[direction]);
				}
				map[curY][curX] = false;
				refreshDirection(direction);
			} else {
//				System.out.println("call");
				refreshDirection(direction);
				return;
			}
		}
	}

	public static void activeDirection(int direction) {
		switch (direction) {
		case 0:
//			System.out.println("동");
			curX = curX + 1;
			break;
		case 1:
//			System.out.println("서");
			curX = curX - 1;
			break;
		case 2:
//			System.out.println("남");
			curY = curY - 1;
			break;
		case 3:
//			System.out.println("북");
			curY = curY + 1;
			break;
		}
	}

	public static void refreshDirection(int direction) {
		switch (direction) {
		case 0:
			curX = curX - 1;
			break;
		case 1:
			curX = curX + 1;
			break;
		case 2:
			curY = curY + 1;
			break;
		case 3:
			curY = curY - 1;
			break;
		}
	}
}

class Position {
	int x, y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
