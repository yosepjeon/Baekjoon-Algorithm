package BackTracking.p1342행운의문자열;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args ) {
		String str;
		Scanner scr = new Scanner(System.in);
		
//		str = scr.next();
//		
//		char c1 = str.charAt(0);
//		char c2 = str.charAt(1);
//		
//		System.out.println(c1 + ", " +  c2);
		
//		System.out.println((int)'a');
		String s = "";
		str(s);
		
		System.out.println();
	}
	
	public static void str(String s) {
		s = s+"abc";
		System.out.println(s);
	}
}
