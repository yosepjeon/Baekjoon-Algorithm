package dfs.p11403경로찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static Queue<Element> queue = new LinkedList<Element>();
	static int N;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int a = scr.nextInt();
				map[i][j] = a;

				if (map[i][j] == 1) {
					queue.add(new Element(j, i));
				}
			}
		}

		
		while (!queue.isEmpty()) {
			visited = new boolean[N];
			Element element = queue.poll();
			visited[element.x] = true;
			dfs(element.y, element.y, element.x);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void dfs(int root, int start, int next) {
		if(root == next) {
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (map[next][i] == 1 && !visited[i]) {
				visited[i] = true;
				map[root][i] = 1;
				dfs(root, next, i);
			}
		}
	}
}

class Element {
	int x, y;

	public Element(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
