package bfs.p6593상범빌딩;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 상, 하, 좌, 우, 위, 아래

public class Main {
	static int L; // 층수
	static int R; // 한층의 행(y)
	static int C; // 한층의 열(x)
	static char[][][] building;
	static boolean[][][] visited;

	static boolean isFind = false;
	static int result=0;
	
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scr = new Scanner(System.in);
		int floor = 0, y = 0, x = 0; // 시작점

		while (true) {
			L = scr.nextInt();
			R = scr.nextInt();
			C = scr.nextInt();

			if (L == 0 && R == 0 && C == 0)
				break;

			building = new char[L][R][C];
			visited = new boolean[L][R][C];

			for (int a = 0; a < L; a++) {
				for (int b = 0; b < R; b++) {
					String str = scr.next();
					building[a][b] = str.toCharArray();
				}
			}

			for (int a = 0; a < L; a++) {
				for (int b = 0; b < R; b++) {
					for (int c = 0; c < C; c++) {
						if (building[a][b][c] == 'S') {
							floor = a;
							y = b;
							x = c;
						}
					}
				}
			}

			bfs(floor, y, x, 0);

//			for (int a = 0; a < L; a++) {
//				for (int b = 0; b < R; b++) {
//					for (int c = 0; c < C; c++) {
//						System.out.print(visited[a][b][c] + "");
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}

			if (isFind) {
				sb.append("Escaped in " + result + " minute(s).\n");
				isFind = false;
			}
			else{
				sb.append("Trapped!\n");
			}
		}
		
		System.out.println(sb.toString());
	}

	public static void bfs(int floor, int y, int x, int minute) {
		Queue<Element> queue = new LinkedList<Element>();
		Element element;
		queue.add(new Element(floor, y, x, minute));
		visited[floor][y][x] = true;

		while (!queue.isEmpty()) {
			element = queue.poll();

			if (building[element.floor][element.y][element.x] == 'E') {
				isFind = true;
				result = element.minute;
			}

			// 상
			if (element.y - 1 >= 0
					&& (building[element.floor][element.y - 1][element.x] == '.'
							|| building[element.floor][element.y - 1][element.x] == 'E')
					&& !visited[element.floor][element.y - 1][element.x]) {
				queue.add(new Element(element.floor, element.y - 1, element.x, element.minute + 1));
				visited[element.floor][element.y - 1][element.x] = true;
			}

			// 하
			if (element.y + 1 < R
					&& (building[element.floor][element.y + 1][element.x] == '.'
							|| building[element.floor][element.y + 1][element.x] == 'E')
					&& !visited[element.floor][element.y + 1][element.x]) {
				queue.add(new Element(element.floor, element.y + 1, element.x, element.minute + 1));
				visited[element.floor][element.y + 1][element.x] = true;
			}

			// 좌
			if (element.x - 1 >= 0
					&& (building[element.floor][element.y][element.x - 1] == '.'
							|| building[element.floor][element.y][element.x - 1] == 'E')
					&& !visited[element.floor][element.y][element.x - 1]) {
				queue.add(new Element(element.floor, element.y, element.x - 1, element.minute + 1));
				visited[element.floor][element.y][element.x - 1] = true;
			}

			// 우
			if (element.x + 1 < C
					&& (building[element.floor][element.y][element.x + 1] == '.'
							|| building[element.floor][element.y][element.x + 1] == 'E')
					&& !visited[element.floor][element.y][element.x + 1]) {
				queue.add(new Element(element.floor, element.y, element.x + 1, element.minute + 1));
				visited[element.floor][element.y][element.x + 1] = true;
			}

			// 오르기
			if (element.floor + 1 < L
					&& (building[element.floor + 1][element.y][element.x] == '.'
							|| building[element.floor + 1][element.y][element.x] == 'E')
					&& !visited[element.floor + 1][element.y][element.x]) {
				queue.add(new Element(element.floor + 1, element.y, element.x, element.minute + 1));
				visited[element.floor + 1][element.y][element.x] = true;
			}

			// 내리기
			if (element.floor - 1 >= 0
					&& (building[element.floor - 1][element.y][element.x] == '.'
							|| building[element.floor - 1][element.y][element.x] == 'E')
					&& !visited[element.floor - 1][element.y][element.x]) {
				queue.add(new Element(element.floor - 1, element.y, element.x, element.minute + 1));
				visited[element.floor - 1][element.y][element.x] = true;
			}
		}

	}
}

class Element {
	int floor, y, x;
	int minute;

	public Element(int floor, int y, int x, int minute) {
		this.floor = floor;
		this.y = y;
		this.x = x;
		this.minute = minute;
	}
}
