package dfs.p14502연구소;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] map;
	static int result = Integer.MIN_VALUE;
	static int[][] tempMap;
	static Queue<Element> queue = new LinkedList<>();
	static Queue<Element> tempQueue = new LinkedList<>();
	// static int area = 0;
	static int wallcnt;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		M = scr.nextInt();

		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = scr.nextInt();

				if (map[i][j] == 2) {
					tempQueue.add(new Element(i, j));
					queue.add(new Element(i, j));
				}

				if (map[i][j] == 1) {
					wallcnt++;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfsWall(i, j, 1);
					map[i][j] = 0;
				}
			}
		}

		System.out.println(result);

	}

	public static void dfsWall(int height, int width, int count) {
		if (count == 3) {
			Element element;
			tempMap = new int[N + 1][M + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					tempMap[i][j] = map[i][j];
				}
			}

			bfsVirus(tempMap);

			Iterator<Element> itr = tempQueue.iterator();

			while (itr.hasNext()) {
				element = itr.next();
				queue.add(element);
			}

			return;
		} else {
			for (int i = height; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						dfsWall(i, j, count + 1);
						map[i][j] = 0;
					}
				}
			}

//			if (width >= M) {
//				for (int i = 1; i <= N; i++) {
//					for (int j = 1; j <= M; j++) {
//						if (map[i][j] == 0) {
//							map[i][j] = 1;
//							dfsWall(i, j, count + 1);
//							map[i][j] = 0;
//						}
//					}
//				}
//			} else {
//				for (int i = 1; i <= N; i++) {
//					for (int j = 1; j <= M; j++) {
//						if (map[i][j] == 0) {
//							map[i][j] = 1;
//							dfsWall(i, j, count + 1);
//							map[i][j] = 0;
//						}
//					}
//				}
//			}
		}
	}

	public static void bfsVirus(int[][] tempMap) {
		Element element;
		boolean[][] visited = new boolean[N + 1][M + 1];
//		visited[y][x] = true;
		int area = 0;
		
//		System.out.println("queue.size() : " + queue.size());
		while (!queue.isEmpty()) {
			element = queue.poll();

			if (element.y - 1 >= 1 && tempMap[element.y - 1][element.x] == 0 && !visited[element.y - 1][element.x]) {
				visited[element.y - 1][element.x] = true;
				tempMap[element.y - 1][element.x] = 2;
				queue.add(new Element(element.y - 1, element.x));
			}

			if (element.y + 1 <= N && tempMap[element.y + 1][element.x] == 0 && !visited[element.y + 1][element.x]) {
				visited[element.y + 1][element.x] = true;
				tempMap[element.y + 1][element.x] = 2;
				queue.add(new Element(element.y + 1, element.x));
			}

			if (element.x - 1 >= 1 && tempMap[element.y][element.x - 1] == 0 && !visited[element.y][element.x - 1]) {
				visited[element.y][element.x - 1] = true;
				tempMap[element.y][element.x - 1] = 2;
				queue.add(new Element(element.y, element.x - 1));
			}

			if (element.x + 1 <= M && tempMap[element.y][element.x + 1] == 0 && !visited[element.y][element.x + 1]) {
				visited[element.y][element.x + 1] = true;
				tempMap[element.y][element.x + 1] = 2;
				queue.add(new Element(element.y, element.x + 1));
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (tempMap[i][j] == 0)
					area++;
			}
		}

		if (result <= area) {
			result = area;
		}
	}
}

class Element {
	int y, x;

	public Element(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
