package 문자열처리.p11720숫자의합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner scr= new Scanner(System.in);
		
		int number = scr.nextInt();
		
		int total = 0;
		String str = scr.next();
		char[] carr = str.toCharArray();
		
		for(int i=0;i<carr.length;i++) {
			total += (carr[i]-'0');
		}
		
		System.out.println(total);
	}
}
