package 시뮬레이션.p15686드래곤커브;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Practice {
	public static void main(String[] args ) {
		Stack<Integer> tempStack = new Stack<>();
		Stack<Integer> realStack = new Stack<>();
		Scanner scr = new Scanner(System.in);
		int n;
		while((n=scr.nextInt()) != -1) {
			tempStack.push(n);
		}
		
		Iterator<Integer> itr = tempStack.iterator();
		while(itr.hasNext()) {
			int num = itr.next();
			
			realStack.push(num);
		}
		
		System.out.print("tempStack: ");
		while(!tempStack.isEmpty()) {
			System.out.print(tempStack.pop() + " ");
		}
		System.out.println();
		
		System.out.print("realStack: ");
		while(!realStack.isEmpty()) {
			System.out.print(realStack.pop()+" ");
		}
		System.out.println();
		
	}
}
