package bfs.p7576토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Element> queue = new LinkedList<>();
	static int minDay = 0;
	static boolean flag;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		M = scr.nextInt();
		N = scr.nextInt();

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = scr.nextInt();

				if (map[i][j] == 1) {
					queue.add(new Element(i, j));
					visited[i][j] = true;
				}
			}
		}
		
		finalCheckMap:
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(map[i][j] == 0){
						flag = true;
					}
				}
			}

		if(flag) {
			bfs();
			System.out.println(minDay-1);
		}else {
			System.out.println(0);
		}
		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
	}

	public static void bfs() {
		Element element;
		int count = 0;
		int queueSize = queue.size();

		while (!queue.isEmpty()) {
			element = queue.poll();
			count++;
			map[element.y][element.x] = 1;

			// 상
			if (element.y - 1 >= 1 && map[element.y - 1][element.x] == 0 && !visited[element.y - 1][element.x]) {
				queue.add(new Element(element.y - 1, element.x));
				visited[element.y - 1][element.x] = true;
			}

			// 하
			if (element.y + 1 <= N && map[element.y + 1][element.x] == 0 && !visited[element.y + 1][element.x]) {
				queue.add(new Element(element.y + 1, element.x));
				visited[element.y + 1][element.x] = true;
			}

			// 좌
			if (element.x - 1 >= 1 && map[element.y][element.x - 1] == 0 && !visited[element.y][element.x - 1]) {
				queue.add(new Element(element.y, element.x - 1));
				visited[element.y][element.x - 1] = true;
			}

			// 우
			if (element.x + 1 <= M && map[element.y][element.x + 1] == 0 && !visited[element.y][element.x + 1]) {
				queue.add(new Element(element.y, element.x + 1));
				visited[element.y][element.x + 1] = true;
			}
			
			if (count == queueSize) {
//				System.out.println(queueSize);
				minDay++;
				queueSize = queue.size();
//				System.out.println(queue.size());
				count = 0;
			}
		}

		finalCheckMap:
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(map[i][j] == 0){
					minDay = 0;
					break finalCheckMap;
				}
			}
		}
	}
}

class Element {
	int x, y;

	public Element(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
