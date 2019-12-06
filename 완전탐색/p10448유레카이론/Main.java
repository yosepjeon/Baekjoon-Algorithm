package 완전탐색.p10448유레카이론;

import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> list;
	static int[] T;
	static int K;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int n = scr.nextInt();
		int num = 1;
		T = new int[45];
		
		while(num*(num+1)/2 <= 1000) {
			T[num] = num*(num+1)/2;
			num++;
		}
		
		for(int i=1;i<=n;i++) {
			K = scr.nextInt();
			int index = 0;
			boolean state = false;
			
			bruteForce:
			for(int a=1;a<num;a++) {
				for(int b=1;b<num;b++) {
					for(int c=1;c<num;c++) {
						
						if(T[a]+T[b]+T[c] == K) {
							state = true;
							sb.append(1 + "\n");
							break bruteForce;
						}
					}
				}
			}
			
			if(!state) {
				sb.append(0 + "\n");
			}
			
			
//			dfs(index,0);
		}
		
		System.out.print(sb.toString());
	}
	
//	public static void dfs(int index,int count) {
//		if(count == 3) {
//			
//		}
//		
//	}
}
