package 문자열처리.p2902KMP;

import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner scr=  new Scanner(System.in);
		
		String input = scr.next();
		
		StringBuffer sb = new StringBuffer();
		String[] sarr = input.split("a");
		
		for(String element:sarr) {
			sb.append(element);
		}
		
		System.out.println(sb.toString());
	}
}
