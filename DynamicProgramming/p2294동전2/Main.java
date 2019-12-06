package DynamicProgramming.p2294동전2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int n, k;
		long[] coins;
		long[] dp;

		n = scr.nextInt();
		k = scr.nextInt();
		coins = new long[n + 1];
		dp = new long[100001];

		for (int i = 1; i <= k; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= n; i++) {
			coins[i] = scr.nextInt();
			dp[(int) coins[i]] = 1;
		}
		
		dp[0] = 0;
		

		for (int i = 1; i <= k; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				for (int j = 1; j <= i; j++) {
					dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
				}
			} else {
				continue;
			}
		}
		if (dp[k] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(dp[k]);
		}
	}
}
