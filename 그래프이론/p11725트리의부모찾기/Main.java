package 그래프이론.p11725트리의부모찾기;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N;
	static Element[] elements;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		elements = new Element[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			elements[i] = new Element(i);
		}

		for (int i = 1; i <= N-1; i++) {
			int num1 = scr.nextInt();
			int num2 = scr.nextInt();

			elements[num1].linkedElements.add(elements[num2]);
			elements[num2].linkedElements.add(elements[num1]);
		}

//		for (int i = 1; i <= N; i++) {
//			dfs(i, i);
//		}
		
		elements[1].parent = 1;
		dfs(1);
		
		for(int i=2;i<=N;i++) {
			System.out.println(elements[i].parent);
		}
	}

	public static void dfs(int start) {
//		System.out.println(start + "시작!");
		if (elements[start].isVisited) {
//			System.out.println(start + " 방문함");
			return;
		}
		
		elements[start].isVisited = true;
		
		Iterator<Element> itr = elements[start].linkedElements.iterator();
		
		while(itr.hasNext()) {
			Element element = itr.next();
			if(element.parent == -1)
				element.parent = start;
			
			dfs(element.id);
		}
	}
}

class Element {
	int id;
	int parent = -1;
	List<Element> linkedElements = new ArrayList<>();
	boolean isVisited = false;

	public Element(int id) {
		this.id = id;
	}
}

//7
//1 6
//6 3
//3 5
//4 1
//2 4
//4 7
