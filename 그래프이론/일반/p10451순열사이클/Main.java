package 그래프이론.일반.p10451순열사이클;

import java.util.Scanner;

public class Main {
	public static boolean[] visited;
	public static int[] elements;
	public static int count = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int loopCount = scr.nextInt();
		StringBuffer sb = new StringBuffer();

		for (int a = 0; a < loopCount; a++) {
			count = 0;
			int num = scr.nextInt();
			elements = new int[num + 1];
			visited = new boolean[num + 1];

			for (int i = 1; i <= num; i++) {
				elements[i] = scr.nextInt();
			}

			for (int i = 1; i <= num; i++) {
				if (!visited[i]) {
					count++;
					findCycle(i);
				}
			}

			if (a == loopCount - 1) {
				sb.append(count);
			} else {
				sb.append(count + "\n");
			}
		}

		System.out.println(sb.toString());
	}

	public static void findCycle(int start) {
		if (visited[start]) {
			return;
		}
		visited[start] = true;

		findCycle(elements[start]);
	}
}
