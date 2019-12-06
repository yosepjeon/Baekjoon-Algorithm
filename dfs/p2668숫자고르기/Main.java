package dfs.p2668숫자고르기;

import java.util.Scanner;

public class Main {
	public static int N;
	public static int[] arr;
	public static boolean[] visited;
	public static int[] resultList;
	public static int result = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		arr = new int[101];
		visited = new boolean[101];

		for (int i = 1; i <= N; i++) {
			arr[i] = scr.nextInt();
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			if (!dfs(i, arr[i])) {
				visited[i] = false;
			} else {
				visited[i] = true;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i])
				result++;
		}

		System.out.println(result);

		for (int i = 1; i <= N; i++)
			if (visited[i])
				System.out.println(i);
	}

	public static boolean dfs(int root, int index) {
		if (arr[index] == root) {
			visited[index] = true;
			return true;
		}

		if (visited[index])
			return false;

		visited[index] = true;
		if (!dfs(root, arr[index])) {
			visited[index] = false;
			return false;
		} else {
			return true;
		}
	}
}
