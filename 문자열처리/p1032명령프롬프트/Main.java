package 문자열처리.p1032명령프롬프트;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int N = scr.nextInt();
		scr.nextLine();

		String[] sarr = new String[N];

		for (int i = 0; i < N; i++) {
			sarr[i] = scr.next();
		}

		String answer = check(sarr);
		
		System.out.println(answer);
	}

	public static String check(String[] sarr) {
		int len = sarr[0].length();
		
		String s = sarr[0];
		StringBuffer answer= new StringBuffer();
		
		for (int i = 0; i < len; i++) {
			boolean flag = false;
			for (int j = 0; j < sarr.length; j++) {
				if(!s.substring(i,i+1).equals(sarr[j].substring(i,i+1))) {
//					System.out.println(s.substring(i,i+1));
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				answer.append(s.substring(i,i+1));
			}else {
				answer.append("?");
			}
				
		}
		
		return answer.toString();
	}
}
