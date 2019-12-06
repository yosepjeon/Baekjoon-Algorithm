package 완전탐색.p10448유레카이론;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n;
		while((n = scr.nextInt()) != 0) {
			System.out.println(n*(n+1)/2);
		}
	}
	
//	Scanner scr = new Scanner(System.in);
//	int n = 1;
//	while(n*(n+1)/2 <= 1000) {
//		System.out.println(n);
//		n++;
//	}
}
