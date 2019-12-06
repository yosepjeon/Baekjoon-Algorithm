package bfs.p5014스타트링크;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int F,S,G,U,D;
	static Queue<Element> queue = new LinkedList<>();
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		F = scr.nextInt();
		S = scr.nextInt();
		G = scr.nextInt();
		U = scr.nextInt();
		D = scr.nextInt();
		
		visited = new boolean[F+1];
		queue.add(new Element(S,0));
		visited[S] = true;
		bfs();
		
		if(min == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		}else {
			System.out.println(min);
		}
	}
	
	public static void bfs() {
		Element element;
		int count = 0;
		
		while(!queue.isEmpty()) {
			element = queue.poll();
//			System.out.println(element);
			count++;
			if(element.floor == G) {
//				System.out.println(element.count);
				if(count < min) {
					min = element.count;
					break;
				}
				count = 0;
			}
			
			
			//U
			if(element.floor+U <= F && !visited[element.floor+U]) {
				queue.add(new Element(element.floor+U,element.count+1));
				visited[element.floor+U] = true;
//				System.out.println("U");
			}
				
			//D
			if(element.floor-D >= 1 && !visited[element.floor-D]) {
				queue.add(new Element(element.floor-D,element.count+1));
				visited[element.floor-D] = true;
//				System.out.println("D");
			}
			
			visited[element.floor] = true;
		}
	}
}

class Element {
	int floor;
	int count;
	
	public Element(int floor,int count) {
		this.floor = floor;
		this.count = count;
	}
}
