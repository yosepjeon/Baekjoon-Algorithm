package DynamicProgramming.p6359만취한상범;

import java.util.Scanner;

public class Main {
	static int T;
	static int N;
	static boolean[] prison;
	
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		T = scr.nextInt();
		StringBuffer sb = new StringBuffer();
		int result;
		
		for(int i=0;i<T;i++) {
			N = scr.nextInt();
			prison = new boolean[N+1];
			result = 0;
			
			doCrazyAction(2);
			
			for(int j=1;j<=N;j++) {
				if(!prison[j])
					result++;
			}
			
			sb.append(result + "\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void doCrazyAction(int count) {
		if(count > N)
			return;
		int i = 1;
		
		int num;
		while(true) {
			num = i * count;
			if(num > prison.length-1)
				break;
			
			if(prison[num])
				prison[num] = false;
			else
				prison[num] = true;
			i++;
		}
		
		doCrazyAction(count+1);
	}
}
