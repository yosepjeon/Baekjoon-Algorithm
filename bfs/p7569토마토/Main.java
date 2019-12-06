package bfs.p7569토마토;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int M, N, H;
	static int[][][] map;
	static boolean[][][] visited;
	static Queue<Element> queue = new LinkedList<>();
	static boolean anyZero;
	static int minDay = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		M = scr.nextInt();
		N = scr.nextInt();
		H = scr.nextInt();

		map = new int[H + 1][N + 1][M + 1];
		visited = new boolean[H + 1][N + 1][M + 1];

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= M; k++) {
					map[i][j][k] = scr.nextInt();

					if (map[i][j][k] == 0)
						anyZero = true;

					if (map[i][j][k] == 1) {
						queue.add(new Element(i, j, k));
						visited[i][j][k] = true;
					}
				}
			}
		}

		if (!anyZero) {
			System.out.println(0);
		} else {
			bfs();
			System.out.println(minDay-1);
		}
		
//		for(int i=1;i<=H;i++) {
//			for(int j=1;j<=N;j++) {
//				for(int k=1;k<=M;k++) {
//					System.out.print(map[i][j][k] +" ");
//				}
//				System.out.println();
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
			map[element.z][element.y][element.x] = 1;
			count++;

			// 북
			if (element.y - 1 >= 1 && map[element.z][element.y - 1][element.x] == 0
					&& !visited[element.z][element.y - 1][element.x]) {
				queue.add(new Element(element.z, element.y - 1, element.x));
				visited[element.z][element.y - 1][element.x] = true;
			}

			// 남
			if (element.y + 1 <= N && map[element.z][element.y + 1][element.x] == 0
					&& !visited[element.z][element.y + 1][element.x]) {
				queue.add(new Element(element.z, element.y+1, element.x));
				visited[element.z][element.y + 1][element.x] = true;
			}

			// 서
			if (element.x - 1 >= 1 && map[element.z][element.y][element.x - 1] == 0
					&& !visited[element.z][element.y][element.x - 1]) {
				queue.add(new Element(element.z, element.y, element.x - 1));
				visited[element.z][element.y][element.x - 1] = true;
			}

			// 동
			if (element.x + 1 <= M && map[element.z][element.y][element.x + 1] == 0
					&& !visited[element.z][element.y][element.x + 1]) {
				queue.add(new Element(element.z, element.y, element.x + 1));
				visited[element.z][element.y][element.x + 1] = true;
			}

			// 위
			if (element.z - 1 >= 1 && map[element.z - 1][element.y][element.x] == 0
					&& !visited[element.z - 1][element.y][element.x]) {
				queue.add(new Element(element.z - 1, element.y, element.x));
				visited[element.z - 1][element.y][element.x] = true;
			}

			// 아래
			if (element.z + 1 <= H && map[element.z + 1][element.y][element.x] == 0
					&& !visited[element.z + 1][element.y][element.x]) {
				queue.add(new Element(element.z+1, element.y,element.x));
				visited[element.z+1][element.y][element.x] = true;
			}
			
			if(count >= queueSize) {
				minDay++;
				queueSize = queue.size();
				count = 0;
			}
		}
		
		finalCheckMap:
		for(int i=1;i<=H;i++) {
			for(int j=1;j<=N;j++) {
				for(int k=1;k<=M;k++) {
					if(map[i][j][k] == 0) {
						minDay = 0;
						break finalCheckMap;
					}
				}
			}
		}
	}
}

class Element {
	int x, y, z;

	public Element(int z, int y, int x) {
		this.z = z;
		this.y = y;
		this.x = x;
	}
}
