package DynamicProgramming.p190401타일;

import java.util.Scanner;

// top-down
public class Main {
	static int[] zeroOneTile;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int N;

		N = scr.nextInt();

		zeroOneTile = new int[N + 1];
		
		if(N == 1){
			zeroOneTile[1] = 1;
		}else {
			zeroOneTile[1] = 1;
			zeroOneTile[2] = 2;
		}
		
		for (int i = 1; i <= N; i++)
			zeroOneTile[i] = -1;

		int result = dp(N);

		System.out.println(result);
	}

	public static int dp(int N) {
		if (N == 1) {
			return 1;
		}
		if (N == 2) {
			return 2;
		}
		
		if (zeroOneTile[N] != -1) {
			return zeroOneTile[N]%15746;
		} else {
			zeroOneTile[N] = dp(N - 1) + dp(N-2);
			return zeroOneTile[N]%15746;
		}

	}
}

// bottom-up
