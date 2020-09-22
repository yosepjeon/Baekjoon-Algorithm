package 그래프이론.p1753최단경로.newtype;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int V,E,START;
	public static boolean[] isVisited;
//	public static int[] wList;
	public static int INF = 1000000000;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		int u,v,w;
		V = scr.nextInt();
		E = scr.nextInt();
		START = scr.nextInt();
		isVisited = new boolean[V+1];
		List<Vertax> vList = new ArrayList<>();
		
		for(int i=0;i<=V;i++) {
			vList.add(new Vertax(i));
		}
		
		for(int i=1;i<=E;i++) {
			u = scr.nextInt();
			v = scr.nextInt();
			w = scr.nextInt();
			
			vList.get(u).edges.add(new Edge(v,w));
		}
		
		Vertax startV = vList.get(START);
		startV.w = 0;
		PriorityQueue<Vertax> pq = new PriorityQueue<>((Vertax v1, Vertax v2) -> {
			if(v1.w > v2.w) {
				return 1;
			}else if(v1.w < v2.w) {
				return -1;
			}else {
				if(v1.id > v2.id) {
					return 1;
				}else if (v1.id < v2.id) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		pq.add(startV);
		
		while(!pq.isEmpty()) {
			Vertax vertax = pq.poll();
//			System.out.println("start: " + vertax.id);
			if(vertax.isVisited) {
				continue;
			}
			
			vertax.isVisited = true;
			
			for(Edge edge : vertax.edges) {
//				System.out.println("from: " + vertax.id + " to: " + edge.to + " w: " + wList[edge.to]);
//				System.out.println("v.w: " + vertax.w + " edge.w: " + edge.w);
				if(vertax.w + edge.w < vList.get(edge.to).w) {
					vList.get(edge.to).w = vertax.w + edge.w;
					
					if(!vList.get(edge.to).isVisited) {
						pq.add(vList.get(edge.to));
					}else {
						vList.get(edge.to).isVisited = false;
						pq.add(vList.get(edge.to));
					}
					
//					System.out.println("from: " + vertax.id + " to: " + edge.to + " w: " + vList.get(edge.to).w);
//					System.out.println("v.id: " + vertax.id + " v.w: " + vertax.w + " edge.w: " + edge.w);
				}
			}
		}
		
		for(int i=1;i<vList.size();i++) {
			int value = vList.get(i).w;
			
			if(value == INF) {
				System.out.println("INF");
			} else {
				System.out.println(vList.get(i).w);
			}
		}
	}
}

class Vertax {
	int id;
	List<Edge> edges = new ArrayList<Edge>();
	boolean isVisited = false;
	int w;
	
	public Vertax(int id) {
		this.id = id;
		w = 1000000000;
	}
}

class Edge {
	int to;
	int w;
	
	public Edge(int to, int w) {
		this.to = to;
		this.w = w;
	}
}
