package BackTracking.p1182부분집합의해.legacy;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	static int N,S;
	static List<Integer> numList = new ArrayList<>();
	static boolean[] visited;
	static int result = 0;
	
	public static void main(String[] args ) {
		Scanner scr= new Scanner(System.in);
		N = scr.nextInt();
		S = scr.nextInt();
		
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			int setElement = scr.nextInt();
			numList.add(setElement);
		}
		
		for(int i=0;i<N;i++) {
			visited[i] = true;
			dfs(i,numList.get(i));
			visited[i] = false;
		}
		
		System.out.println(result);
	}
	
	public static void dfs(int index,int goalNum) {
		if(index >= N) {
			if(goalNum == S) 
				result++;
		}else {
			if(goalNum == S) 
				result++;
			for(int i = index+1;i<N;i++) {
				visited[i] = true;
				dfs(i,goalNum+numList.get(i));
				visited[i] = false;
			}
		}
	}
}
