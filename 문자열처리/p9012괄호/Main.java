package 문자열처리.p9012괄호;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int num = scr.nextInt();
		StringBuffer results = new StringBuffer();
		
		for (int i = 0; i < num; i++) {
			Stack<Character> stack = new Stack<>();
			String str = scr.next();

			char[] carr = str.toCharArray();
			for (char c : carr) {
				if(c == '(') {
					stack.add(c);
				}else if(c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}else if(stack.isEmpty()){
						stack.add(c);
					}
				}
			}
			
			String result = stack.isEmpty() ? "YES\n" : "NO\n";
			results.append(result);
		}
		
		System.out.println(results.toString());
	}
}
