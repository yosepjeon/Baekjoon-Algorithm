package 문자열처리.p9251LCS;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String str1 = scr.next();
		String str2 = scr.next();

		char[] carr1 = str1.toCharArray();
		char[] carr2 = str2.toCharArray();
		boolean[] carr2Visited = new boolean[carr2.length];

		int str1Size = str1.length();
		int str2Size = str2.length();

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int i = 0; i < str1Size; i++) {
			for (int j = 0; j < str2Size; j++) {
				
			}
		}

	}
}
