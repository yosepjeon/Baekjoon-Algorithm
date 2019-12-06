package 시뮬레이션.p17144미세먼지;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C, T;
	static Element[][] map;
	static int time = 0;
	static Queue<Element> queue;
	static LinkedList<Element> airCleaner = new LinkedList<>();
	static int total = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		R = scr.nextInt();
		C = scr.nextInt();
		T = scr.nextInt();

		map = new Element[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int dust = scr.nextInt();
				map[i][j] = new Element(i, j, dust, 0);

				if (dust == -1) {
					airCleaner.add(new Element(i, j, -1, -1));
				}
			}
		}

		while (time < T) {
			time++;
			queue = new LinkedList<>();

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j].dust > 0) {
						queue.add(new Element(i, j, map[i][j].dust, map[i][j].dust / 5));
					}
				}
			}

			spreadDust();
			runAirCleaner();
		}

//		System.out.println("Result");
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j].dust != -1) {
					total += map[i][j].dust;
//					System.out.print(map[i][j].dust + " ");
				} else {
//					System.out.print("* ");
				}
			}
//			System.out.println();
		}

		System.out.println(total);
	}

	public static void spreadDust() {
		for (Element element : queue) {
			// 상
			if (element.y - 1 >= 0 && map[element.y - 1][element.x].dust != -1) {
				map[element.y - 1][element.x].dust += element.spreadDust;
				map[element.y][element.x].dust -= element.spreadDust;
			}

			// 하
			if (element.y + 1 < R && map[element.y + 1][element.x].dust != -1) {
				map[element.y + 1][element.x].dust += element.spreadDust;
				map[element.y][element.x].dust -= element.spreadDust;
			}

			// 좌
			if (element.x - 1 >= 0 && map[element.y][element.x - 1].dust != -1) {
				map[element.y][element.x - 1].dust += element.spreadDust;
				map[element.y][element.x].dust -= element.spreadDust;
			}

			// 우
			if (element.x + 1 < C && map[element.y][element.x + 1].dust != -1) {
				map[element.y][element.x + 1].dust += element.spreadDust;
				map[element.y][element.x].dust -= element.spreadDust;
			}
		}

//		System.out.println("Spread Dust");
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				if (map[i][j].dust != -1) {
//					// total += map[i][j].dust;
//					System.out.print(map[i][j].dust + " ");
//				} else {
//					System.out.print("* ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
	}

	public static void runAirCleaner() {
		windNonCircuit(airCleaner.get(0).y, airCleaner.get(0).x + 1);
		windCircuit(airCleaner.get(1).y, airCleaner.get(1).x + 1);

//		System.out.println("Run AirCleaner");
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				if (map[i][j].dust != -1) {
//					// total += map[i][j].dust;
//					System.out.print(map[i][j].dust + " ");
//				} else {
//					System.out.print("* ");
//				}
//			}
//			System.out.println();
//		}
//		System.out.println();
	}

	public static void windNonCircuit(int y, int x) {
		Element temp;
		// 상
		for (int i = y - 1; i >= 1; i--) {
			temp = new Element(map[i - 1][0].y, map[i - 1][0].x, map[i - 1][0].dust, map[i - 1][0].spreadDust);
			map[i - 1][0] = map[i][0];
			map[i][0] = temp;
		}
		// 우
		for (int i = 0; i < C - 1; i++) {
			temp = new Element(map[0][i + 1].y, map[0][i + 1].x, map[0][i + 1].dust, map[0][i + 1].spreadDust);
			map[0][i + 1] = map[0][i];
			map[0][i] = temp;
		}
		// 하
		for (int i = 0; i < y; i++) {
			temp = new Element(map[i + 1][C - 1].y, map[i + 1][C - 1].x, map[i + 1][C - 1].dust,
					map[i + 1][C - 1].spreadDust);
			map[i + 1][C - 1] = map[i][C - 1];
			map[i][C - 1] = temp;
		}
		// 좌
		for (int i = C - 1; i > 1; i--) {
			temp = new Element(map[y][i - 1].y, map[y][i - 1].x, map[y][i - 1].dust, map[y][i - 1].spreadDust);
			map[y][i - 1] = map[y][i];
			map[y][i] = temp;
		}
		map[y][x] = new Element(y, x, 0, 0);
	}

	public static void windCircuit(int y, int x) {
		Element temp;

		// 하
		for (int i = y + 1; i < R - 1; i++) {
			temp = new Element(map[i + 1][0].y, map[i + 1][0].x, map[i + 1][0].dust, map[i + 1][0].spreadDust);
			map[i + 1][0] = map[i][0];
			map[i][0] = temp;
		}
		// 우
		for (int i = 0; i < C - 1; i++) {
			temp = new Element(map[R - 1][i + 1].y, map[R - 1][i + 1].x, map[R - 1][i + 1].dust,
					map[R - 1][i + 1].spreadDust);
			map[R - 1][i + 1] = map[R - 1][i];
			map[R - 1][i] = temp;
		}
		// 상
		for (int i = R - 1; i > y; i--) {
			temp = new Element(map[i - 1][C - 1].y, map[i - 1][C - 1].x, map[i - 1][C - 1].dust,
					map[i - 1][C - 1].spreadDust);
			map[i - 1][C - 1] = map[i][C - 1];
			map[i][C - 1] = temp;
		}
		// 좌
		for (int i = C - 1; i > 1; i--) {
			temp = new Element(map[y][i - 1].y, map[y][i - 1].x, map[y][i - 1].dust, map[y][i - 1].spreadDust);
			map[y][i - 1] = map[y][i];
			map[y][i] = temp;
		}

		map[y][x] = new Element(y, x, 0, 0);
	}

}

class Element {
	int y, x, dust;
	int spreadDust;

	public Element(int y, int x, int dust, int spreadDust) {
		this.y = y;
		this.x = x;
		this.dust = dust;
		this.spreadDust = spreadDust;
	}
}

// public static void up(int y, int x) {
//
// }
//
// public static void down(int y, int x) {
//
// }
//
// public static void left(int y, int x) {
//
// }
//
// public static void right(int y, int x) {
//
// }
