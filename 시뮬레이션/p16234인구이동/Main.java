package 시뮬레이션.p16234인구이동;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, L, R;
	static int[][] map;
	static int union;
	static boolean[][] visited;
	static boolean[][] isOpen;
	static boolean endFlag = false;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt(); // 크기
		L = scr.nextInt(); // L 이하
		R = scr.nextInt(); // R 이상
		int count = 0;

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = scr.nextInt();
			}
		}

		while (true) {
			union = 0;
			endFlag = true;
			isOpen = new boolean[N][N];
//			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!isOpen[i][j]) {
						union++;
						isOpen[i][j] = true;
//						visited[i][j] = true;
						openBFS(i, j);
					}
				}
			}
			
			if(endFlag) {
				break;
			}else {
				count++;
			}
//			System.out.println();
//			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		System.out.println(count);
	}

	public static void openBFS(int y, int x) {
		int total = 0;
		Queue<Element> queue = new LinkedList<>();
		Queue<Element> unionQueue = new LinkedList<>();

		queue.add(new Element(y, x, map[y][x]));
		
		while (!queue.isEmpty()) {
			Element element = queue.poll();
			unionQueue.add(element);
			total += element.value;
//			System.out.println(element.y + " " + element.x);
//			System.out.println(total);
			
			// 상
			if (element.y - 1 >= 0 && !isOpen[element.y - 1][element.x]
					&& (Math.abs(map[element.y][element.x] - map[element.y - 1][element.x]) <= R
							&& Math.abs(map[element.y][element.x] - map[element.y - 1][element.x]) >= L)) {
				isOpen[element.y - 1][element.x] = true;
				queue.add(new Element(element.y - 1, element.x, map[element.y - 1][element.x]));
				endFlag = false;
			}

			// 하
			if (element.y + 1 < N && !isOpen[element.y + 1][element.x]
					&& (Math.abs(map[element.y][element.x] - map[element.y + 1][element.x]) <= R
							&& Math.abs(map[element.y][element.x] - map[element.y + 1][element.x]) >= L)) {
				isOpen[element.y + 1][element.x] = true;
				queue.add(new Element(element.y + 1, element.x, map[element.y + 1][element.x]));
				endFlag = false;
			}

			// 좌
			if (element.x - 1 >= 0 && !isOpen[element.y][element.x - 1]
					&& (Math.abs(map[element.y][element.x] - map[element.y][element.x - 1]) <= R
							&& Math.abs(map[element.y][element.x] - map[element.y][element.x - 1]) >= L)) {
				isOpen[element.y][element.x - 1] = true;
				queue.add(new Element(element.y, element.x - 1, map[element.y][element.x - 1]));
				endFlag = false;
			}

			// 우
			if (element.x + 1 < N && !isOpen[element.y][element.x + 1]
					&& (Math.abs(map[element.y][element.x] - map[element.y][element.x + 1]) <= R
							&& Math.abs(map[element.y][element.x] - map[element.y][element.x + 1]) >= L)) {
				isOpen[element.y][element.x + 1] = true;
				queue.add(new Element(element.y, element.x + 1, map[element.y][element.x + 1]));
				endFlag = false;
			}
		}
		
		
		int unionQueueSize = unionQueue.size();
		while(!unionQueue.isEmpty()) {
			Element element = unionQueue.poll();
			
			map[element.y][element.x] = total/unionQueueSize;
		}
	}
}

class Element {
	int y, x, value;

	public Element(int y, int x, int value) {
		this.y = y;
		this.x = x;
		this.value = value;
	}
}
