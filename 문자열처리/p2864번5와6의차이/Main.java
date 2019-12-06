package 문자열처리.p2864번5와6의차이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		char[] carr1 = scr.next().toCharArray();
		char[] carr2 = scr.next().toCharArray();
		
		for(int i=0;i<carr1.length;i++) {
			if(carr1[i] == '5') {
				carr1[i] = '6';
			}
		}
		for(int i=0;i<carr2.length;i++) {
			if(carr2[i] == '5') {
				carr2[i] = '6';
			}
		}
		int max = Integer.valueOf(String.valueOf(carr1)) + Integer.valueOf(String.valueOf(carr2));

		for(int i=0;i<carr1.length;i++) {
			if(carr1[i] == '6') {
				carr1[i] = '5';
			}
		}
		for(int i=0;i<carr2.length;i++) {
			if(carr2[i] == '6') {
				carr2[i] = '5';
			}
		}
		
		int min = Integer.valueOf(String.valueOf(carr1)) + Integer.valueOf(String.valueOf(carr2));
		
		System.out.println(min + " " + max);
	}
	
	public static void converMax(char[] carr) {
		for(char c:carr) {
			if(c == 5) {
				c = 6;
			}
		}
	}
	
	public static void converMin(char[] carr) {
		for(char c:carr) {
			if(c == 6) {
				c = 5;
			}
		}
	}
}
