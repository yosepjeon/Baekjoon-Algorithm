package DynamicProgramming.p10844쉬운계단수;

import java.util.Scanner;

public class Main {
	static int N;
	// static long[][] dp;
	static long[] dp;
	static long[] minusdp;
	static long n;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

//		N = scr.nextInt();
//		dp = new long[101];
//
//		dp[1] = 9;
//		dp[2] = 17;
//
//		if (N == 1)
//			System.out.println(dp[1]);
//		else if (N == 2) {
//			System.out.println(dp[2]);
//		} else {
//
//			for (int i = 3; i <= N; i++) {
//				if (i % 2 == 0) {
//					dp[i] = (dp[i - 1] * 2 - 1) % 1000000000;
//				} else {
//					int num = 0;
//					dp[i] += dp[i - 1];
//					while (num < i / 2) {
//						dp[i] += dp[num * 2 + 1] % 1000000000;
//						num++;
//					}
//				}
//			}
//
//			System.out.println(dp[N]);
//		}

		int n = scr.nextInt();
	    long[][] dp = new long[101][11];
	 
	    // dp[N][L] = dp[N - 1][L - 1] + dp[N - 1][L + 1]
	    // 길이 N, 마지막 숫자가 L일 경우
	 
	    for (int i = 1; i <= 9; i++) {
	        dp[1][i] = 1;
	    }
	 
	    for (int i = 2; i <= n; i++) {
	        dp[i][0] = dp[i - 1][1];
	        for (int j = 1; j <= 9; j++) {
	            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
	        }
	    }
	 
	    long sum = 0;
	    for (int i = 0; i < 10; i++) {
	        sum += dp[n][i];
	    }
	    System.out.println(sum % 1000000000);


	}
}
