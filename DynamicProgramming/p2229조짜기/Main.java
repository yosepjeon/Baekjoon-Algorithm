package DynamicProgramming.p2229조짜기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int N = scr.nextInt();
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		int optimalValue = 0;
		dp[0] = 0;
		dp[1] = 0;
		int max = 0;
		
		for(int i=1;i<=N;i++) {
			arr[i] = scr.nextInt();
			
			for(int j = i-1;j>=1;j--) {
				max = Math.max(max,Math.abs(arr[i]-arr[j]) + dp[j-1]);
			}
			
			dp[i] = max;
			optimalValue = dp[i];
		}
		
		System.out.println(optimalValue);
	}
}
