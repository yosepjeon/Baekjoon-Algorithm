package 시뮬레이션.p15683감시;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static LinkedList<Camera> cctv;
	static int[][] initMap;
	static boolean[][] initVisited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		M = scr.nextInt();

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		cctv = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				int value = scr.nextInt();

				if (value >= 1 && value <= 5) {
					cctv.add(new Camera(i, j, value, -1));
					map[i][j] = value;
				} else {
					map[i][j] = value;
				}
			}
		}
		setCamerasDirect(0);
		
		System.out.println(min);
	}

	// 0:동 1:남 2:서 3:북
	public static void setCamerasDirect(int index) {
		if (index >= cctv.size()) {
			move();
			return;
		} else {
			switch (cctv.get(index).type) {
			case 1:
				for (int i = 0; i < 4; i++) {
					cctv.get(index).direct = i;
					setCamerasDirect(index+1);
				}
				break;
			case 2:
				for (int i = 0; i < 2; i++) {
					cctv.get(index).direct = i;
					setCamerasDirect(index+1);
				}
				break;
			case 3:
				for (int i = 0; i < 4; i++) {
					cctv.get(index).direct = i;
					setCamerasDirect(index+1);
				}
				break;
			case 4:
				for (int i = 0; i < 4; i++) {
					cctv.get(index).direct = i;
					setCamerasDirect(index+1);
				}
				break;
			case 5:
//				cctv.get(index).direct = 0;
				setCamerasDirect(index+1);
				break;
			}
		}
	}

	public static void move() {
//		System.out.println("move call");
		initMap = new int[N + 1][M + 1];
		initVisited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				initMap[i][j] = map[i][j];
				initVisited[i][j] = visited[i][j];
			}
		}

		for (Camera camera : cctv) {
			switch (camera.type) {
			case 1:
				Type1(camera);
				break;
			case 2:
				Type2(camera);
				break;
			case 3:
				Type3(camera);
				break;
			case 4:
				Type4(camera);
				break;
			case 5:
				Type5(camera);
				break;
			}
		}
		int count = 0;
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
//				System.out.print(initMap[i][j] + "  ");
				if(initMap[i][j] == 0)
					count++;
			}
//			System.out.println();
		}
//		System.out.println("count = " + count);
		
		if(min > count ) {
			min = count;
		}
	}

	public static void Type1(Camera camera) {
		if (camera.direct == 0) {
			right(camera.y,camera.x+1);
		}

		if (camera.direct == 1) {
			down(camera.y+1,camera.x);
		}

		if(camera.direct == 2) {
			left(camera.y,camera.x-1);
		}
		
		if(camera.direct == 3) {
			up(camera.y-1,camera.x);
		}
	}

	public static void Type2(Camera camera) {
		if(camera.direct == 0) {
			left(camera.y,camera.x-1);
			right(camera.y,camera.x+1);
		}
		
		if(camera.direct == 1) {
			up(camera.y-1,camera.x);
			down(camera.y+1,camera.x);
		}
	}

	public static void Type3(Camera camera) {
		if(camera.direct == 0) {
			up(camera.y-1,camera.x);
			right(camera.y,camera.x+1);
		}
		
		if(camera.direct == 1) {
			right(camera.y,camera.x+1);
			down(camera.y+1,camera.x);
		}
		
		if(camera.direct == 2) {
			left(camera.y,camera.x-1);
			down(camera.y+1,camera.x);
		}
		
		if(camera.direct == 3) {
			left(camera.y,camera.x-1);
			up(camera.y-1,camera.x);
		}
	}

	public static void Type4(Camera camera) {
		if(camera.direct == 0) {
			right(camera.y,camera.x+1);
			up(camera.y-1,camera.x);
			left(camera.y,camera.x-1);
		}
		
		if(camera.direct == 1) {
			down(camera.y+1,camera.x);
			right(camera.y,camera.x+1);
			up(camera.y-1, camera.x);
		}
		
		if(camera.direct == 2) {
			left(camera.y,camera.x-1);
			down(camera.y+1,camera.x);
			right(camera.y,camera.x+1);
		}
		
		if(camera.direct == 3) {
			up(camera.y-1, camera.x);
			left(camera.y,camera.x-1);
			down(camera.y+1,camera.x);
		}
	}

	public static void Type5(Camera camera) {
		up(camera.y-1,camera.x);
		right(camera.y,camera.x+1);
		down(camera.y+1,camera.x);
		left(camera.y,camera.x-1);
	}

	/////////////////////////////////
	public static void up(int y, int x) {
		if (y < 1 || map[y][x] == 6) {
			return;
		} else {
			initMap[y][x] = 9;
			up(y - 1, x);
		}
	}

	public static void down(int y, int x) {
		if (y > N || map[y][x] == 6) {
			return;
		} else {
			initMap[y][x] = 9;
			down(y + 1, x);
		}
	}

	public static void left(int y, int x) {
		if (x < 1 || map[y][x] == 6) {
			return;
		} else {
			initMap[y][x] = 9;
			left(y, x - 1);
		}
	}

	public static void right(int y, int x) {
		if (x > M || map[y][x] == 6) {
			return;
		} else {
			initMap[y][x] = 9;
			right(y, x + 1);
		}
	}
}

class Camera {
	int y, x;
	int type;
	int direct;

	public Camera(int y, int x, int type, int direct) {
		this.y = y;
		this.x = x;
		this.type = type;
		this.direct = direct;
	}
}

class Element {
	int y, x;

	public Element(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
