package bfs.p3055탈출;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Vertax> waters = new LinkedList<>();
	static Queue<Vertax> sQueue = new LinkedList<>();
	static Vertax D;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		R = scr.nextInt();
		C = scr.nextInt();

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = scr.next();
			map[i] = str.toCharArray();

			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					visited[i][j] = true;
					sQueue.add(new Vertax(i, j,0));
				}
				
				if(map[i][j] == 'D') {
					D = new Vertax(i,j,0);
				}

				if (map[i][j] == '*') {
					waters.add(new Vertax(i, j,0));
				}
			}		
		}
		
		while(!sQueue.isEmpty()) {
			moveWater();
			moveS();
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(min);
		}
	}

	public static void moveWater() {
		int watersSize = waters.size();
		
		for(int i=0;i<watersSize;i++) {
			Vertax water = waters.poll();
			
			// 동
			if(water.c+1 < C && map[water.r][water.c+1] != '*' && map[water.r][water.c+1] != 'X' && map[water.r][water.c+1] != 'D') {
				map[water.r][water.c+1] = '*';
				waters.add(new Vertax(water.r, water.c+1,0));
			}
			// 서
			if(water.c-1 >= 0 && map[water.r][water.c-1] != '*' && map[water.r][water.c-1] != 'X' && map[water.r][water.c-1] != 'D') {
				map[water.r][water.c-1] = '*';
				waters.add(new Vertax(water.r,water.c-1,0));
			}
			// 남
			if(water.r+1 < R && map[water.r+1][water.c] != '*' && map[water.r+1][water.c] != 'X' && map[water.r+1][water.c] != 'D') {
				map[water.r+1][water.c] = '*';
				waters.add(new Vertax(water.r+1,water.c,0));
			}
			// 북
			if(water.r-1 >= 0 && map[water.r-1][water.c] != '*' && map[water.r-1][water.c] != 'X' && map[water.r-1][water.c] != 'D') {
				map[water.r-1][water.c] = '*';
				waters.add(new Vertax(water.r-1,water.c,0));
			}
		}
	}

	public static void moveS() {
		int queueSize = sQueue.size();
		
		for(int i=0;i<queueSize;i++) {
			Vertax s = sQueue.poll();
			map[s.r][s.c] = '.';
			if(s.r == D.r && s.c == D.c && s.w < min) {
				min = s.w;
				continue;
			}
			
			// 동
			if(s.c+1 < C && !visited[s.r][s.c+1] && (map[s.r][s.c+1] == '.' || map[s.r][s.c+1] == 'D')) {
				visited[s.r][s.c+1] = true;
				sQueue.add(new Vertax(s.r,s.c+1,s.w+1));
			}
			
			// 서
			if(s.c-1 >= 0 && !visited[s.r][s.c-1] && (map[s.r][s.c-1] == '.' || map[s.r][s.c-1] == 'D')) {
				visited[s.r][s.c-1] = true;
				sQueue.add(new Vertax(s.r,s.c-1,s.w+1));
			}
			
			// 남
			if(s.r+1 < R && !visited[s.r+1][s.c] && (map[s.r+1][s.c] == '.' || map[s.r+1][s.c] == 'D')) {
				visited[s.r+1][s.c] = true;
				sQueue.add(new Vertax(s.r+1,s.c,s.w+1));
			}
			
			// 북
			if(s.r-1 >= 0 && !visited[s.r-1][s.c] && (map[s.r-1][s.c] == '.' || map[s.r-1][s.c] == 'D')) {
				visited[s.r-1][s.c] = true;
				sQueue.add(new Vertax(s.r-1,s.c,s.w+1));
			}
		}
	}
}

class Vertax {
	int r, c;
	int w = 0;

	public Vertax(int r, int c, int w) {
		this.r = r;
		this.c = c;
		this.w = w;
	}
}
