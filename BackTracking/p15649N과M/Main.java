package BackTracking.p15649N과M;

import java.util.Scanner;

public class Main {
	static int N, M;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		N = scr.nextInt();
		M = scr.nextInt();
		
		visited = new boolean[N+1];

		dfs(0, -1, "", sb);
		
		System.out.println(sb.toString());
	}

	public static void dfs(int n,int prev,String str,StringBuffer sb) {
		if (n == M) {
			sb.append(str + "\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			if(n == 0) {
				dfs(n+1,i,str + i, sb);
			}else {
				dfs(n+1,i,str + " " + i, sb);
			}
			visited[i] = false;
		}
	}
}
