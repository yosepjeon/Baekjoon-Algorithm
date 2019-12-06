package 시뮬레이션.p17144미세먼지;

import java.util.LinkedList;
import java.util.Scanner;

public class Practice {
	static LinkedList<Integer> list = new LinkedList<>();
	
	public static void main(String[] args ) {
		int n = -1;
		Scanner scr = new Scanner(System.in);
		
		while((n = scr.nextInt()) != 0) {
			list.add(n);
		}
		
		for(int element : list) {
			System.out.println(element);
		}
	}
}
