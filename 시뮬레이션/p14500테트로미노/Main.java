package 시뮬레이션.p14500테트로미노;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		M = scr.nextInt();

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = scr.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				nomalTetrominoDfs(j, i, 1, 0);
				visited[i][j] = false;
			}
		}
		
		unNomalTetrominoDfs();
		
		
		System.out.println(max);
	}

	public static void nomalTetrominoDfs(int x, int y, int tetrominoSize, int total) {
		if (tetrominoSize > 4) {
			if(max < total) {
				max = total;
			}
			
			return;
		} else {
			total += map[y][x];

			if (y - 1 >= 0 && !visited[y - 1][x]) {
				visited[y - 1][x] = true;
				nomalTetrominoDfs(x, y - 1, tetrominoSize + 1, total);
				visited[y - 1][x] = false;
			}

			if (y + 1 < N && !visited[y + 1][x]) {
				visited[y + 1][x] = true;
				nomalTetrominoDfs(x, y + 1, tetrominoSize + 1, total);
				visited[y + 1][x] = false;
			}

			if (x - 1 >= 0 && !visited[y][x - 1]) {
				visited[y][x - 1] = true;
				nomalTetrominoDfs(x - 1, y, tetrominoSize + 1, total);
				visited[y][x - 1] = false;
			}

			if (x + 1 < M && !visited[y][x + 1]) {
				visited[y][x + 1] = true;
				nomalTetrominoDfs(x + 1, y, tetrominoSize + 1, total);
				visited[y][x + 1] = false;
			}
		}
	}
	
	public static void unNomalTetrominoDfs() {
		// 위쪽방향 모양
		for(int i=0;i+1<N;i++) {
			for(int j=0;j+2<M;j++) {
				int total = 0;
				total = total + map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i][j+2];
				
				if(total > max)
					max = total;
			}
		}
		
		// 아랫쪽방향 모양
		for(int i=N-1;i-1>=0;i--) {
			for(int j=M-1;j-2>=0;j--) {
				int total = 0;
				total = total + map[i][j] + map[i][j-1] + map[i-1][j-1] + map[i][j-2];
				
				if(total > max)
					max = total;
			}
		}
		
		// 좌측방향 모양
		for(int i=N-1;i-2>=0;i--) {
			for(int j=M-1;j-1>=0;j--) {
				int total = 0;
				total = total + map[i][j] + map[i-1][j] + map[i-1][j-1] + map[i-2][j];
				
				if(total > max)
					max = total;
			}
		}
		
		// 우측방향 모양
		for(int i=0;i+2<N;i++) {
			for(int j=0;j+1<M;j++) {
				int total = 0;
				total = total + map[i][j] + map[i+1][j] + map[i+1][j+1] + map[i+2][j];
				
				if(total > max)
					max = total;
			}
		}
	}
}
