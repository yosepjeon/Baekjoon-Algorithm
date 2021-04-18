package 그래프이론.일반.p1753최단경로.legacy;

//import java.util.*;
//
//public class Main {
//	static int V,E;
//	
//	public static void main(String[] args ) {
//		Scanner scr = new Scanner(System.in);
//		final int INF = 10000;
//		
//		V = scr.nextInt();
//		E = scr.nextInt();
//		int startV = scr.nextInt();
//		
//		int[] result = new int[V+1];
//		List<Vertax> vertaxList = new ArrayList<Vertax>();
//		List<Edge> edgeList = new ArrayList<>();
//		
//		Map<Integer, Map<Integer,Integer>> map = new HashMap<Integer, Map<Integer,Integer>>();
//		
//		for(int i=1;i<=V;i++) {
//			Vertax vertax = new Vertax(i, i, 0);
//			vertaxList.add(vertax);
//		}
//		
//		for(int i=0;i<E;i++) {
//			int u = scr.nextInt();
//			int v = scr.nextInt();
//			int w = scr.nextInt();
//			
//			Edge edge = new Edge(u, v, w);
//			if(map.getOrDefault(u, null) == null) {
//				map.put(i, new HashMap<>());
//			}else {
//				Map<Integer,Integer> edgeMap = map.get(i);
//				edgeMap.put(v, w);
//			}
//			edgeList.add(edge);
//		}
//		
////		PriorityQueue<Map<Integer,Integer>> pq = new PriorityQueue<Edge>((Edge e1, Edge e2) -> {
////			return e1.w - e2.w;
////		});
//		
//		Edge vertax = new Edge(startV,startV,0);
//		pq.add(vertax);
//		result[startV] = 0;
//		
//		
//		while(!pq.isEmpty()) {
//			Edge e = pq.poll();
//			
//			for(int i=1;i<=V;i++) {
////				if(map[v.u][i] == 0 || map[v.u][i] == INF) {
////					continue;
////				}
//				if(e.w == 0 || e.w == INF) {
//					continue;
//				}
//				
//				if(v.w + e.w < result[i]) {
//					result[i] = v.w + map[v.u][i];
//					pq.add(new Vertax(v.u,i,result[i]));
//				}
//			}
//		}
//		
//		StringBuffer sb = new StringBuffer();
//		for(int i=1;i<=V;i++) {
//			sb.append(result[i] == INF? "INF\n" : String.valueOf(result[i]) + "\n");
//		}
//		
//		System.out.println(sb.toString());
//	}
//	
//}
//
//class Vertax {
//	int u;
//	int w;
//	ArrayList<Element> vList;
//	
//	public Vertax(int u,int v, int w) {
//		this.u = u;
//		this.w = w;
//		vList = new ArrayList<>();
//	}
//}
//
//class Edge {
//	int u,v,w;
//	
//	public Edge(int u,int v,int w) {
//		this.u = u;
//		this.v = v;
//		this.w = w;
//	}
//}
//
//class Element {
//	int w;
//}


//import java.util.*;
//
//public class Main {
//	static int V,E;
//	
//	public static void main(String[] args ) {
//		Scanner scr = new Scanner(System.in);
//		final int INF = 10000;
//		
//		V = scr.nextInt();
//		E = scr.nextInt();
//		int startV = scr.nextInt();
//		
//		int[][] map = new int[V+1][V+1];
//		int[] result = new int[V+1];
//		
//		for(int i=1;i<=V;i++) {
//			for(int j=1;j<=V;j++) {
//				if(i == j) {
//					map[i][j] = 0;
//					continue;
//				}
//				map[i][j] = INF;
//			}
//			
//			result[i] = INF;
//		}
//		
//		for(int i=0;i<E;i++) {
//			int u = scr.nextInt();
//			int v = scr.nextInt();
//			int w = scr.nextInt();
//			
//			map[u][v] = w;
//		}
//		
//		PriorityQueue<Vertax> pq = new PriorityQueue<Vertax>((Vertax v1, Vertax v2) -> {
//			return v1.w - v2.w;
//		});
//		
//		Vertax vertax = new Vertax(startV,0);
//		pq.add(vertax);
//		result[startV] = 0;
//		
//		
//		while(!pq.isEmpty()) {
//			Vertax v = pq.poll();
//			
//			for(int i=1;i<=V;i++) {
//				if(map[v.u][i] == 0 || map[v.u][i] == INF) {
//					continue;
//				}
//				
//				if(v.w + map[v.u][i] < result[i]) {
//					result[i] = v.w + map[v.u][i];
//					pq.add(new Vertax(i,result[i]));
//				}
//			}
//		}
//		
//		StringBuffer sb = new StringBuffer();
//		for(int i=1;i<=V;i++) {
//			sb.append(result[i] == INF? "INF\n" : String.valueOf(result[i]) + "\n");
//		}
//		
//		System.out.println(sb.toString());
//	}
//	
//}
//
//class Vertax {
//	int u,v,w;
//	
//	public Vertax(int u, int w) {
//		this.u = u;
//		this.w = w;
//	}
//}
