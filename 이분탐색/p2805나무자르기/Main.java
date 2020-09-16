package 이분탐색.p2805나무자르기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int max,min;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		N = scr.nextInt();
		M = scr.nextInt();
		
		List<Integer> trees = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int tree = scr.nextInt();
			trees.add(tree);
		}
		
		trees.sort((i1,i2) -> i1-i2);
		
		min = trees.get(0);
		max = trees.get(N-1);
		
		int result = findOptimal(trees,min,max);
		
		System.out.println(result);
		
	}
	
	public static int findOptimal(List<Integer> trees,int min,int max) {
		int p = (min+max)/2;
		
		if(min >= max) {
			return max;
		}else {
			int m = cutTrees(trees,p);
			
			if(m < M) {
				max = p;
				return findOptimal(trees,p,max);
			}else {
				min = p;
				return findOptimal(trees,min,p);
			}
		}
	}
	
	public static int cutTrees(List<Integer> trees, int p) {
		int total = 0;
		
		for(int tree : trees) {
			if(tree >= p){
				total += tree - p;
			}
		}
		
		return total;
	}
}


