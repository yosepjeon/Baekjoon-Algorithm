package BackTracking.p6603로또.legacy;

import java.util.Scanner;

public class Main {
	static int[] arr;
	static int k;
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		k = -1;
		
		while(true) {
			k = scr.nextInt();
			if(k == 0)
				break;
			
			arr = new int[k];
			
			for(int i=0;i<k;i++) {
				arr[i] = scr.nextInt();
			}
			
			for(int i=0;i<k;i++) {
				dfs(i,1,arr[i] + " ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static void dfs(int index,int size,String str) {
		if(size == 6){
			sb.append(str + "\n");
		}
		
		for(int i = index+1;i<k;i++) {
			dfs(i,size+1,str + arr[i] + " ");
		}
	}
}
