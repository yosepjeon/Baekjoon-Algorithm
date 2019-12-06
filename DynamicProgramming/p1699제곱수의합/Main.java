package DynamicProgramming.p1699제곱수의합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N;
		long[] dp;

		N = scr.nextInt();
		dp = new long[100001];

		for (int i = 1; i <= 100000; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 1;

		for (int i = 1; i <= N; i++) {
			if (dp[i] == Integer.MAX_VALUE) {
				for (int j = 1; j*j <= i; j++) {
					if(j*j == i) {
						dp[i] = 1;
						continue;
					}
					dp[i] = Math.min(dp[i], dp[(int) Math.pow(j, 2)] + dp[(int) (i - Math.pow(j, 2))]);
				}
			} else {
				continue;
			}
		}

		System.out.println(dp[N]);
	}
}
