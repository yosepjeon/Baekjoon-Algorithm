package 시뮬레이션.p17143낚시왕;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
	public static FisherMan fisherMan = new FisherMan(0, 0);
	public static int R, C, M;
	public static Aqua[][] map;
	public static Map<Integer, Shark> sharks; 

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		R = scr.nextInt();
		C = scr.nextInt();
		M = scr.nextInt();

		map = new Aqua[R + 1][C + 1];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = new Aqua();
			}
		}

		sharks = new HashMap<>();

		for (int i = 0; i < 8; i++) {
			int r = scr.nextInt();
			int c = scr.nextInt();
			int s = scr.nextInt();
			int d = scr.nextInt();
			int z = scr.nextInt();

			Shark shark = new Shark(i, r, c, s, d, z);
			sharks.put(i, shark);
			map[r][c].shark = shark;
		}
		
		while(fisherMan.c < C) {
			doFish();
			moveSharks();
			setMap();
		}
		
		System.out.println(fisherMan.score);
	}

	public static void doFish() {
		fisherMan.c++;

		for (int i = 1; i <= R; i++) {
			Shark shark = map[i][fisherMan.c].shark;
//			List<Shark> list = map[i][fisherMan.c].list;
//			if (list.size() != 0) {
//				Shark shark = list.get(0);
//				fisherMan.score += shark.z;
//				list.remove(0);
//				sharks.remove(shark.id);
//				return;
//			}
			
			fisherMan.score += shark.z;
			sharks.remove(shark.id);
		}
	}

	public static void moveSharks() {
		Iterator<Integer> itr = sharks.keySet().iterator();

		while (itr.hasNext()) {
			int key = itr.next();

			Shark shark = sharks.get(key);
			shark.move();
		}
	}
	
	public static void setMap() {
		map = new Aqua[R][C];
		
		Iterator<Integer> itr = sharks.keySet().iterator();
		
		while(itr.hasNext()) {
			Integer key = itr.next();
			
			Shark shark = sharks.get(key);
			
			if(map[shark.r][shark.c] == null) {
				map[shark.r][shark.c] = new Aqua(shark);
			}else {
				Shark legacyShark = map[shark.r][shark.c].shark;
				
				if(shark.z > legacyShark.z) {
					map[shark.r][shark.c].shark = shark;
					sharks.remove(legacyShark.id);
				}else {
					sharks.remove(shark.id);
				}
			}
		}
	}
}

class Aqua {
//	List<Shark> list;
//
//	public Aqua() {
//		list = new LinkedList<>();
//	}
	
	Shark shark;
	
	public Aqua() {
		
	}
	
	public Aqua(Shark shark) {
		this.shark = shark;
	}
}

class FisherMan {
	int c;
	int score;

	public FisherMan(int c, int score) {
		this.c = c;
		this.score = score;
	}
}

class Shark {
	int id;
	int r, c; // 위치
	int s; // 속력
	int d; // 이동 방향 [1,2] 상하 [3,4] 우좌
	int z; // 크기

	public Shark(int id, int r, int c, int s, int d, int z) {
		this.id = id;
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

	public void move() {
		int divideNum;
		int rest;

		if (this.d == 1) {
			divideNum = this.s / r;
			rest = this.s % r;

			if (divideNum % 2 == 0) {
				this.r -= rest;
			} else {
				this.d = 2;
				this.r += rest;
			}
		} else if (this.d == 2) {
			divideNum = this.s / r;
			rest = this.s % r;

			if (divideNum % 2 == 0) {
				this.r += rest;
			} else {
				this.d = 1;
				this.r -= rest;
			}
		} else if (this.d == 3) {
			divideNum = this.s / c;
			rest = this.s % c;
			
			if (divideNum % 2 == 0) {
				this.c -= rest;
			} else {
				this.d = 4;
				this.c += rest;
			}
		} else if (this.d == 4) {
			divideNum = this.s / c;
			rest = this.s % c;
			
			if (divideNum % 2 == 0) {
				this.c += rest;
			} else {
				this.d = 3;
				this.c -= rest;
			}
		}
		
	}
}