package 완전탐색.p2636치즈;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int width, height;
	static Queue<Element> queue = new LinkedList<>();
	static int time = 0;
	static int minCheese = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		height = scr.nextInt();
		width = scr.nextInt();

		map = new int[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				map[i][j] = scr.nextInt();
			}
		}

		initMap(0, 0);

		// for (int i = 0; i < height; i++) {
		// for (int j = 0; j < width; j++) {
		// System.out.print(map[i][j] + " ");
		// }
		// System.out.println();
		// }

		while (!queue.isEmpty()) {
//			System.out.println(queue.size() + "!");
			time++;
			meltCheese();
		}

		System.out.println(time);
		System.out.println(minCheese);
	}

	public static void initMap(int y, int x) {
		map[y][x] = -1;

		if (y - 1 >= 0 && map[y - 1][x] == 1) {
			map[y - 1][x] = 2;
			queue.add(new Element(y - 1, x));
		}

		if (y + 1 < height && map[y + 1][x] == 1) {
			map[y + 1][x] = 2;
			queue.add(new Element(y + 1, x));
		}

		if (x - 1 >= 0 && map[y][x - 1] == 1) {
			map[y][x - 1] = 2;
			queue.add(new Element(y, x - 1));
		}

		if (x + 1 < width && map[y][x + 1] == 1) {
			map[y][x + 1] = 2;
			queue.add(new Element(y, x + 1));
		}

		if (y - 1 >= 0 && map[y - 1][x] == 0) {
			initMap(y - 1, x);
		}

		if (y + 1 < height && map[y + 1][x] == 0) {
			initMap(y + 1, x);
		}

		if (x - 1 >= 0 && map[y][x - 1] == 0) {
			initMap(y, x - 1);
		}

		if (x + 1 < width && map[y][x + 1] == 0) {
			initMap(y, x + 1);
		}
	}

	public static void meltCheese() {
		int size = queue.size();
		if (size != 0) {
			if (minCheese > size)
				minCheese = size;
		}

		for (int i = 0; i < size; i++) {
			Element cheese = queue.poll();
			map[cheese.y][cheese.x] = -1;

			if (cheese.y - 1 >= 0 && map[cheese.y - 1][cheese.x] == 0) {
				initMap(cheese.y - 1, cheese.x);
			}

			if (cheese.y + 1 < height && map[cheese.y + 1][cheese.x] == 0) {
				initMap(cheese.y + 1, cheese.x);
			}

			if (cheese.x - 1 >= 0 && map[cheese.y][cheese.x - 1] == 0) {
				initMap(cheese.y, cheese.x - 1);
			}

			if (cheese.x + 1 < width && map[cheese.y][cheese.x + 1] == 0) {
				initMap(cheese.y, cheese.x + 1);
			}

			//

			if (cheese.y - 1 >= 0 && map[cheese.y - 1][cheese.x] == 1) {
				map[cheese.y - 1][cheese.x] = 2;
				queue.add(new Element(cheese.y - 1, cheese.x));
			}

			if (cheese.y + 1 < height && map[cheese.y + 1][cheese.x] == 1) {
				map[cheese.y + 1][cheese.x] = 2;
				queue.add(new Element(cheese.y + 1, cheese.x));
			}

			if (cheese.x - 1 >= 0 && map[cheese.y][cheese.x - 1] == 1) {
				map[cheese.y][cheese.x - 1] = 2;
				queue.add(new Element(cheese.y, cheese.x - 1));
			}

			if (cheese.x + 1 < width && map[cheese.y][cheese.x + 1] == 1) {
				map[cheese.y][cheese.x + 1] = 2;
				queue.add(new Element(cheese.y, cheese.x + 1));
			}
		}
	}
}

class Element {
	int y, x;

	public Element(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
