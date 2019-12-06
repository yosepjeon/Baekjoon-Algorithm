package DynamicProgramming.p11726_2xn타일링;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int[] tile;
		int n = scr.nextInt();
		int result;
		tile = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			tile[i] = -1;
		}
		
		for(int i=1;i<=n;i++) {
			if(i == 1){
				tile[i] = 1;
				result = 1;
				continue;
			}
			if(i == 2){
				tile[i] = 2;
				result = 2;
				continue;
			}
			
			tile[i] = tile[i-1]%10007 + tile[i-2]%10007;
		}
		
		System.out.println(tile[n]%10007);
	}
}
