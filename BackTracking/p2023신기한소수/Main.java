package BackTracking.p2023신기한소수;

import java.util.Scanner;

public class Main {
	static int N;
	static StringBuffer sb = new StringBuffer();
	static int[] arr;
	
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		N = scr.nextInt();
		
		dfs("",0);
		
		System.out.print(sb.toString());
	}
	
	public static void dfs(String str,int len) {
		if(len == N) {
			sb.append(str + "\n");
		}else {
			for(int i=1;i<=9;i++) {
				if(isPrime(Integer.valueOf(str + i))) {
					dfs(str + i, len+1);
				}
			}
		}
	}
	
	public static boolean isPrime(int num) {
		if(num == 1)
			return false;
		
		for(int i=2;i*i<=num;i++) {
			if(num % i == 0)
				return false;
		}
		
		return true;
	}
}
