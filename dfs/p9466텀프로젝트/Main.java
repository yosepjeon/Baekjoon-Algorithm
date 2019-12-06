package dfs.p9466텀프로젝트;

import java.util.Scanner;

public class Main {
	static int T;
	static int n;
	static int[] students;
	static boolean[] visited;
	static boolean[] checkIsTeamMember;
	static int result = 0;

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		T = scr.nextInt();

		for (int i = 1; i <= T; i++) {
			n = scr.nextInt();
			students = new int[n + 1];
			checkIsTeamMember = new boolean[n+1];
			result = 0;

			for (int j = 1; j <= n; j++) {
				students[j] = scr.nextInt();
			}

			for (int j = 1; j <= n; j++) {
				visited = new boolean[n + 1];
				if (j != students[j]) {
					visited[j] = true;
					dfs(j, j,students[j]);
//					dfs(j);
				}else {
					checkIsTeamMember[j] = true;
				}
			}
			
			for(int j = 1;j<= n;j++) {
				if(!checkIsTeamMember[j])
					result++;
			}

			sb.append(result + "\n");
		}

		System.out.println(sb.toString());
	}

	public static void dfs(int root, int my, int partner) {
		if(root == students[partner] && !visited[partner]) {
			checkIsTeamMember[root] = true;
			return;
		}else {
			if(!visited[partner] && !checkIsTeamMember[partner]){
				visited[partner] = true;
				dfs(root, partner, students[partner]);
			}else {
				return;
			}
		}
	}
}

class Element {
	
}

//1
//3
//2 3 2
