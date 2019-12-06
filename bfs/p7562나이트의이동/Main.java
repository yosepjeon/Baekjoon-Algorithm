package bfs.p7562나이트의이동;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int T, I;
	static Element current, goal;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Element> queue;
	static StringBuffer sb = new StringBuffer();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int x, y;
		T = scr.nextInt();

		for (int i = 0; i < T; i++) {
			I = scr.nextInt();
			map = new int[I][I];
			visited = new boolean[I][I];
			queue = new LinkedList<>();

			y = scr.nextInt();
			x = scr.nextInt();
			current = new Element(y, x, 0);

			y = scr.nextInt();
			x = scr.nextInt();
			goal = new Element(y, x, 0);

			queue.add(current);
			visited[current.y][current.x] = true;

			bfs();
		}

		System.out.println(sb.toString());
	}

	public static void bfs() {
		Element element = null;

		while (!queue.isEmpty()) {
			element = queue.poll();

			if (element.x == goal.x && element.y == goal.y) {
				if (min > element.count) {
					min = element.count;
					sb.append(min + "\n");
					min = Integer.MAX_VALUE;
					return;
				}
			}

			// 상상우
			if (element.y + 2 < I && element.x + 1 < I && !visited[element.y + 2][element.x + 1]) {
				queue.add(new Element(element.y + 2, element.x + 1, element.count + 1));
				visited[element.y + 2][element.x + 1] = true;
			}

			// 상상좌
			if (element.y + 2 < I && element.x - 1 >= 0 && !visited[element.y + 2][element.x - 1]) {
				queue.add(new Element(element.y + 2, element.x - 1, element.count + 1));
				visited[element.y + 2][element.x - 1] = true;
			}

			// 하하우
			if (element.y - 2 >= 0 && element.x + 1 < I && !visited[element.y - 2][element.x + 1]) {
				queue.add(new Element(element.y - 2, element.x + 1, element.count + 1));
				visited[element.y - 2][element.x + 1] = true;
			}

			// 하하좌
			if (element.y - 2 >= 0 && element.x - 1 >= 0 && !visited[element.y - 2][element.x - 1]) {
				queue.add(new Element(element.y - 2, element.x - 1, element.count + 1));
				visited[element.y - 2][element.x - 1] = true;
			}

			// 우우상
			if (element.y + 1 < I && element.x + 2 < I && !visited[element.y + 1][element.x + 2]) {
				queue.add(new Element(element.y + 1, element.x + 2, element.count + 1));
				visited[element.y + 1][element.x + 2] = true;
			}

			// 우우하
			if (element.y - 1 >= 0 && element.x + 2 < I && !visited[element.y - 1][element.x + 2]) {
				queue.add(new Element(element.y - 1, element.x + 2, element.count + 1));
				visited[element.y - 1][element.x + 2] = true;
			}

			// 좌좌상
			if (element.y + 1 < I && element.x - 2 >= 0 && !visited[element.y + 1][element.x - 2]) {
				queue.add(new Element(element.y + 1, element.x - 2, element.count + 1));
				visited[element.y + 1][element.x - 2] = true;
			}

			// 좌좌하
			if (element.y - 1 >= 0 && element.x - 2 >= 0 && !visited[element.y - 1][element.x - 2]) {
				queue.add(new Element(element.y - 1, element.x - 2, element.count + 1));
				visited[element.y - 1][element.x - 2] = true;
			}
		}

		sb.append(element.count);
	}
}

class Element {
	int y, x, count;

	public Element(int y, int x, int count) {
		this.y = y;
		this.x = x;
		this.count = count;
	}
}
