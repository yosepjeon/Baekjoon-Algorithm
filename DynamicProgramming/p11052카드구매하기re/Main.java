package DynamicProgramming.p11052카드구매하기re;

import java.util.Scanner;

public class Main {
	static int[] cards;
	static int N;
	static int[] memoization;
	static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		cards = new int[N + 1];
		memoization = new int[N+1];

		for (int i = 1; i <= N; i++) {
			cards[i] = scr.nextInt();
		}
		
		for(int i=0;i<N+1;i++) {
			memoization[i] = 0;
		}

		int result = recursive(N);

		System.out.println(result);
	}

	public static int recursive(int count) {
		if(count == 0)
			return 0;
		if(memoization[count] > 0)
			return memoization[count];
		
		for(int i=1;i<=count;i++) {
			memoization[count] =  Math.max(memoization[count], recursive(count-i) + cards[i]);
		}
		
		return memoization[count];
	}
}
