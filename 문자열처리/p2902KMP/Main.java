package 문자열처리.p2902KMP;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	static Pattern pattern = Pattern.compile("^[A-Z]$");
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		String input = scr.next();
		
		String[] newString = input.split("[^-@*s|A-Z*$]");
		
		StringBuffer sb = new StringBuffer();
		
		for(String element : newString) {
			sb.append(element);
		}
		
		System.out.println(sb.toString());
	}
}
