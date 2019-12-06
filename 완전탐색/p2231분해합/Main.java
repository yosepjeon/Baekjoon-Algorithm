package 완전탐색.p2231분해합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int input;
		char[] carr;
		int[] iarr;
		int num;
		String value;
		int result=-1;
		boolean flag = false;
		
		input= scr.nextInt();
		
		for(int i=1;i<input;i++) {
			result = i;
			value = String.valueOf(i);
			
			carr = new char[value.length()];
			iarr = new int[value.length()];
			
			carr = value.toCharArray();
			num = Integer.parseInt(value);
			
			for(int j=0;j<carr.length;j++) {
				iarr[j] = carr[j]-'0';
				
				num = num+iarr[j];
			}
			
			if(num == input){
				flag = true;
				break;
			}
		}
		if(flag){
			System.out.println(result);
		}else {
			System.out.println(0);
		}
	}
}
