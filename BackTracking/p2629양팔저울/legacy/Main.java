package BackTracking.p2629양팔저울.legacy;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int MAX = 30;
	static int[] choos = new int[MAX+1];
	static int[] bids = new int[7];
	static boolean[][] map = new boolean[MAX + 1][40001];

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();

		for (int i = 0; i < N; i++) {
			choos[i] = scr.nextInt();
		}

		M = scr.nextInt();

		for (int i = 0; i < M; i++) {
			bids[i] = scr.nextInt();
		}

		// map = new boolean[MAX+1][MAX * 500 + 1];
		calcul(0, 0);

		for (int i = 0; i < M; i++) {
			if (bids[i] > 40000) {
				System.out.print("N ");
			} else if (bids[i]<=15000 && map[N][bids[i]] == true) {
//			if (bids[i]<=15000 && map[N][bids[i]] == true) {
				System.out.print("Y ");
			} else {
				System.out.print("N ");
			}
		}
		scr.close();
//		System.out.println();
	}

	public static void calcul(int chooCount, int totalWeight) {
		if (chooCount > N)
			return;

		if (map[chooCount][totalWeight] == true)
			return;

		map[chooCount][totalWeight] = true;

		calcul(chooCount + 1, totalWeight + choos[chooCount]);
		calcul(chooCount + 1, totalWeight);
		calcul(chooCount + 1, Math.abs(totalWeight - choos[chooCount]));
	}
}