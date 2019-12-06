package DynamicProgramming.p11053가장긴증가하는수열;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scr = new Scanner(System.in);
		int A;
		int[] arr;
		boolean[] checkArr;
		int[] dp;
		int index;
		int count = 0;
		int max = 1;

		A = scr.nextInt();
		arr = new int[A + 1];
		dp = new int[A + 1];

		for (int i = 1; i <= A; i++) {
			arr[i] = scr.nextInt();
			dp[i] = 1;
		}

		for (int i = 1; i <= A; i++) {
			for (int j = 1; j <= i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}

			// System.out.print(dp[i] +" ");
		}
		// System.out.println();

		System.out.println(max);

	}
}
