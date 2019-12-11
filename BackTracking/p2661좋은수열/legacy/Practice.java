package BackTracking.p2661좋은수열.legacy;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		String str = scr.next();
		
		System.out.println(str.substring(0,3));
		System.out.println(str.substring(3,6));
		
		int len = (int)Math.ceil(5/2);
		
		System.out.println(len);
	}
}
