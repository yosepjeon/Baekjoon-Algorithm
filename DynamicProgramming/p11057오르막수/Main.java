package DynamicProgramming.p11057오르막수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N = 0;
		int[][] dp;
		Scanner scr = new Scanner(System.in);
		
		N = scr.nextInt();
		dp = new int[N+1][N+1];
		
		for(int i=0;i<=9;i++) {
			dp[1][i] = 1;
		}
		
	}
}
