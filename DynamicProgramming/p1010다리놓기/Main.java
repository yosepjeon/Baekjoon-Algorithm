package DynamicProgramming.p1010다리놓기;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static BigInteger result;
	static long N, M;
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int count = scr.nextInt();

		for (int i = 0; i < count; i++) {
			result = new BigInteger("1");
			N = scr.nextLong();
			M = scr.nextLong();

			calculateCombination();
		}
		
		System.out.println(sb.toString());
	}

	public static void calculateCombination() {
		long m = M;
		for (int i = 0; i < N; i++) {
//			result *= m--;
			result = result.multiply(BigInteger.valueOf(m--));
		}

		for (int i = 1; i <= N; i++) {
//			result /= i;
			result = result.divide(BigInteger.valueOf(i));
		}
		
		sb.append(result + "\n");
	}
}
