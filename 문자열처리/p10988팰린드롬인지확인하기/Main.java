package 문자열처리.p10988팰린드롬인지확인하기;

import java.util.Scanner;

public class Main {
	static String str;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		str = scr.next();
		
		System.out.println(checkPelindrom(0, str.length()-1));
	}
	public static int checkPelindrom(int start, int end) {
		if(start > end) {
			return 1;
		}
		
		if(str.charAt(start) == str.charAt(end)) {
			return checkPelindrom(start+1,end-1);
		}else {
			return 0;
		}
	}
	
	public static int checkPelindromOdd(int start, int end) {
		
		return 0;
	}
	
	public static int checkPelindromEven(int start, int end) {
		return 0;
	}
}
