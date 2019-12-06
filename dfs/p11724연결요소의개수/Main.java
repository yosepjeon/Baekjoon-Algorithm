package dfs.p11724연결요소의개수;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int u, v;
	static int[][] map;
	static boolean[] visited;
	static int count = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		M = scr.nextInt();

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				map[i][j] = 0;
			}
			visited[i] = false;
		}
		
//		if(M == 0){
//			System.out.println(N);
//			return;
//		}

		for (int i = 0; i < M; i++) {
			u = scr.nextInt();
			v = scr.nextInt();

			map[u][v] = 1;
			map[v][u] = 1;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				boolean flag = false;
				for (int j = 1; j <= N; j++) {
					if (!visited[j] && i!=j && map[i][j] == 1) {
						count++;
						dfs(i, j);
						flag = true;
					}
				}
				
				if(!flag)
					count++;
			}
		}

		System.out.println(count);
	}

	public static void dfs(int from, int to) {
		visited[to] = true;
		for (int j = 1; j <= N; j++) {
			if (!visited[j] && (map[to][j] == 1 || map[from][j] == 1)) {
				dfs(to, j);
			}
		}

	}
}
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
// 
//public class Main {
//    static int nV;
//    static int nE;
//    static ArrayList<ArrayList<Integer>> adj;
//    static boolean isvisited[];
//    static int cont;
//    public static void main(String[] args) {
//        Scanner input=new Scanner(System.in);
// 
//        nV=input.nextInt();
//        nE=input.nextInt();
//        adj=new ArrayList<ArrayList<Integer>>();
//        isvisited=new boolean[nV];
//        for(int i=0; i<=nV; i++)
//            adj.add(new ArrayList<Integer>());
//        for(int i=0; i<nV; i++)
//            isvisited[i]=false;
//        for(int i=0; i<nE; i++)
//        {
//            int t1=input.nextInt();
//            int t2=input.nextInt();
// 
//            adj.get(t1).add(t2);
//            adj.get(t2).add(t1);
//        }
// 
//        int k=1;
// 
//        // 1부터 탐색시작
// 
//        for(int i=0; i<isvisited.length; i++)
//        {
//            if(isvisited[i]==false)
//            {
//                bfs(i+1);
//                cont++;
//            }
// 
//        }
//        
//        System.out.println(cont);
// 
// 
//    }
// 
//    public static void bfs(int n)
//    {
//        Queue<Integer> q=new LinkedList<Integer>();
//        q.offer(n);
//        
//        while(!q.isEmpty())
//        {
//            int t=q.poll();
// 
//            for(int i=0; i<adj.get(t).size(); i++)
//            {
//                if(isvisited[adj.get(t).get(i)-1]==false )
//                {
//                    isvisited[adj.get(t).get(i)-1]=true;
//                    q.offer(adj.get(t).get(i));
//                }
//            }
// 
//        }
// 
//    }
//}
