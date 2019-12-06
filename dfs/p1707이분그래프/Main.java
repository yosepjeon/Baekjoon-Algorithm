package dfs.p1707이분그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int K;
	static StringBuffer sb = new StringBuffer();
	static int color = 0;
	static Element[] vertax;
	static boolean flag;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		K = scr.nextInt();
		int V, E;
		
		for (int a = 0; a < K; a++) {
			V = scr.nextInt();
			E = scr.nextInt();
			flag = true;

			vertax = new Element[V + 1];

			for (int b = 1; b <= V; b++) {
				vertax[b] = new Element(b, -1);
			}

			for (int b = 1; b <= E; b++) {
				int start, end;
				start = scr.nextInt();
				end = scr.nextInt();

				vertax[start].queue.add(vertax[end]);
				vertax[end].queue.add(vertax[start]);
			}

			for (int b = 1; b <= E; b++) {
				if (!vertax[b].visited)
//					 System.out.println(b);
					dfs(vertax[b], null);
				if (!flag) {
					break;
				}
			}

			if (flag) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
			
			vertax = null;
		}

//		 for(int i=1;i<vertax.length;i++) {
//		 System.out.println(vertax[i].queue.size());
//		 }

		System.out.print(sb.toString());
	}

	public static void dfs(Element element, Element prevElem) {
		element.queue.remove(prevElem);

		if (element.visited && element.color != color) {
			if(element.color != prevElem.color)
				flag = false;
			return;
		}else if (element.visited && element.color == color) {
			element.queue.remove(prevElem);
			return;
		} else{
			element.visited = true;
			element.color = color;
			color = (color + 1) % 2;
//			if (element.queue.size() == 0) {
//				System.out.println(element.num + "->" + " null");
//			} else {
//				System.out.println(element.num + " -> " + element.queue.peek().num);
//			}
			
			if (element.queue.size() != 0) {
				dfs(element.queue.poll(), element);
			}
//			if (element.queue.size() != 0) {
//				if(element.queue.peek().visited) {
//					flag = false;
//					return;
//				}
//				dfs(element.queue.poll(), element);
//			}
		}
	}
}

class Element {
	int num;
	int color;
	boolean visited;
	Queue<Element> queue;

	public Element(int num, int color) {
		this.num = num;
		this.color = color;
		this.visited = false;
		queue = new LinkedList<>();
	}
}
