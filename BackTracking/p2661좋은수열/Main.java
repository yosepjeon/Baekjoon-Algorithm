package BackTracking.p2661좋은수열;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int N;
	static Scanner scr = new Scanner(System.in);
	static BigInteger num,max;
	static boolean stop = false;
	static String str = "";
	static String maxstr=  "1";
	
	public static void main(String[] args ) {
		N = scr.nextInt();
		
		dfs(1,"1");
	}
	
	public static void dfs(int len, String value) {
		if(stop)
			return;
		
		if(len == N) {
			stop = true;
			System.out.println(value);
		}else {
			for(int i=1;i<=3;i++) {
				if(isSatisfy(value+i)){
					dfs(len+1,value+i);
				}
			}
		}
	}
	
	public static boolean isSatisfy(String value) {
		int len = value.length();
		int limit = len/2;
		
		for(int i = 1;i<=limit;i++) {
			for(int j=0;j<=len-(2*i);j++) {
				if(value.substring(j, j+i).equals(value.substring(j+i,j+i+i))) {
					return false;
				}
			}
		}
		
		return true;
	}
}
