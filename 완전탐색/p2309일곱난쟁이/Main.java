package 완전탐색.p2309일곱난쟁이;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[] dwarfs = new int[9];
	static boolean[] visited = new boolean[9];
	//static int total = 0;
	static boolean flag = false;
	
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<9;i++) {
			dwarfs[i] = scr.nextInt();
		}
		
		for(int i=0;i<9;i++) {
			dfs(i,1,0);
			if(flag)
				break;
			visited[i] = false;
		}
		
		for(int i=0;i<9;i++) {
			if(visited[i])
				list.add(dwarfs[i]);
		}
		
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	public static void dfs(int index,int count,int total) {
		if(count == 7) {
			visited[index] = true;
			total += dwarfs[index];
			
			if(total == 100) {
				flag = true;
			}else {
				visited[index] = false;
			}
		}else {
			visited[index] = true;
			total += dwarfs[index];
			
			if(total >= 100) {
				visited[index] = false;
				return;
			}else {
				for(int i=index+1;i<9;i++) {
					if(visited[i] == false){
						dfs(i,count+1,total);
						if(flag)
							break;
						visited[i] = false;
					}
				}
			}
		}
	}
}
