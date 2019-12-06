package bfs.p2644촌수계산;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class Main{
	static int n;
	static int from,to;
	static int m;
	static int x,y;
	static int[][] map;
	static boolean[] visited;
	static Element[] elements;
	static boolean isFind = false;
	
	static int result;
	
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		n = scr.nextInt();
		
		map = new int[n+1][n+1];
//		element = new Element[n+1];
		visited = new boolean[n+1];
		
		from = scr.nextInt();
		to = scr.nextInt();
		m = scr.nextInt();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = -1;
			}
		}
		
		for(int i=1;i<=m;i++) {
			y = scr.nextInt();
			x = scr.nextInt();
			
			map[y][x] = 1;
		}
		
		bfs(from);
		
		if(isFind)
			System.out.println(result);
		else{
			System.out.println(-1);
		}
			
	}
	
	public static void bfs(int start) {
		Queue<Element> queue = new LinkedList<>();
		visited[start] = true;
		
		for(int i=1;i<=n;i++) {
			if(map[i][start] == 1)
				queue.add(new Element(i,1));
			if(map[start][i] == 1)
				queue.add(new Element(i,1));
		}
		
		
		while(!queue.isEmpty()) {
			Element element = queue.poll();
			if(element.next == to){
				isFind = true;
				result = element.count;
				break;
			}
				
			visited[element.next] = true;
			
			for(int i=1;i<=n;i++) {
				if(map[i][element.next] == 1 && !visited[i])
					queue.add(new Element(i,element.count+1));
				if(map[element.next][i] == 1 && !visited[i])
					queue.add(new Element(i,element.count+1));
				
			}
		}
		
	}
}

class Element {
	int next = 0;
	int count;
	
	public Element(int next, int count) {
		this.next = next;
		this.count = count;
	}
}
