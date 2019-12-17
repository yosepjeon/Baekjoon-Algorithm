package DynamicProgramming.p11054가장긴바이토닉부분수열;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		N = scr.nextInt();
		arr = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i] = scr.nextInt();
		}
		
		
	}
}
