package DynamicProgramming.p2293동전1;

import java.util.Scanner;

public class Main {
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args ) {
		@SuppressWarnings("resource")
		Scanner scr = new Scanner(System.in);
		int n ,k;
		n = scr.nextInt();
		k = scr.nextInt();
		
		arr = new int[n+1];
		dp = new int[k+1];
		
		for(int i=0;i<=n;i++) {
			arr[i] = 0;
		}
		
		for(int i=0;i<=k;i++) {
			dp[i] = 0;
		}
		
		for(int i=1;i<=n;i++) {
			arr[i] = scr.nextInt();
		}
		
		dp[0]= 1;
		
		for(int i=1;i<=n;i++) {
			for(int j=arr[i];j<=k;j++) {
				dp[j] += dp[j-arr[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}
