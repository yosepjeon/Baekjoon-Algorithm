package 문자열처리.p9251LCS;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String str1 = scr.next();
		String str2 = scr.next();
		
		char[] carr1 = str1.toCharArray();
		char[] carr2 = str2.toCharArray();
		boolean[] carr2Visited = new boolean[carr2.length];
		
		int str1Size = str1.length();
		int str2Size = str2.length();
		
		int max = 0;
		for(int i=0;i<str1Size;i++) {
			carr2Visited = new boolean[carr2.length];
			int cnt = 0;
			for(int j=0;j<str1Size;j++) {
				for(int k=0;k<str2Size;k++) {
					if(carr2Visited[k]) {
						continue;
					}
					
					if(carr1[j]==carr2[k]) {
//						System.out.println("j: " + j + ", k: " + k );
						cnt++;
						carr2Visited[j] = true;
//						for(int l = j;l>=0;l--) {
//							carr2Visited[l] = true;
//						}
						break;
					}
				}
			}
			
			if(max < cnt) {
				max = cnt;
			}
		}
		
		System.out.println(max);
	}
}
