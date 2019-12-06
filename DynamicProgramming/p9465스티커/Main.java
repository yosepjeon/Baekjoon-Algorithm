package DynamicProgramming.p9465스티커;

import java.util.Scanner;

public class Main {
	static int T;
	static int n;
	static int[][] sticker;
	static int[][] dp;
	
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		T = scr.nextInt();
		
		for(int a=0;a<T;a++) {
			n = scr.nextInt();
			sticker = new int[3][n+1];
			dp = new int[3][n+1];
			
			for(int b=1;b<3;b++) {
				for(int c=1;c<=n;c++) {
					sticker[b][c] = scr.nextInt();
					dp[b][c] = 0;
				}
			}
			
			dp[1][1] = sticker[1][1];
			dp[2][1] = sticker[2][1];
			
			for(int i=2;i<=n;i++) {
				dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + sticker[1][i];
				dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[2][i];
			}
			
			sb.append(String.valueOf(Math.max(dp[1][n], dp[2][n])) + "\n");
		}
		
		System.out.println(sb.toString());
	}
}
