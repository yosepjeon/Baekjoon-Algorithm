package 시뮬레이션.p17143낚시왕;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
	// static Map<Integer, ArrayList<Shark>> map;
	static LinkedList<Shark> list = new LinkedList<>();
	static int R, C, M;
	static int fisherMan = 1;
	static Shark[][] sharkMap;
	static Shark[][] tempMap;
	static int result = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int r, c, s, d, z;

		R = scr.nextInt();
		C = scr.nextInt();
		M = scr.nextInt();

		sharkMap = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			r = scr.nextInt();
			c = scr.nextInt();
			s = scr.nextInt();
			d = scr.nextInt();
			z = scr.nextInt();

			Shark shark = new Shark(r, c, s, d, z);
			list.add(shark);
			sharkMap[r][c] = shark;
		}

		for (int i = fisherMan; i <= C; i++) {
			tempMap = new Shark[R + 1][C + 1];

			for (int j = 1; j <= R; j++) {
				if (sharkMap[j][i] != null) {
					result += sharkMap[j][i].z;
					break;
				}
			}
		}
	}

	public static void moveSharks() {
		Shark shark;
		int listSize = list.size();
		
		for(int i=0;i<listSize ;i++) {
			shark = list.poll();
			
			move(shark);
		}
	}
	
	public static void move(Shark shark) {
		if(shark.s == 0) {
			tempMap[shark.r][shark.c] = shark;
			return;
		}
		
		switch(shark.d) {
		case 1:
			if(shark.r-1 < shark.s) {
				shark.s -= shark.r-1;
			}else {
				
			}
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
	}
}

class Shark {
	int r, c, s, d, z;

	public Shark(int r, int c, int s, int d, int z) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.d = d;
		this.z = z;
	}

}

class Aqua {
	int r, c;
	final int HASH_PRIME = 31;

	public Aqua(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		int hashCode = HASH_PRIME * Integer.hashCode(this.r);
		hashCode = HASH_PRIME * Integer.hashCode(this.c);

		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub

		Aqua aqua = (Aqua) obj;

		if (this.r == aqua.r && this.c == aqua.c) {
			return true;
		} else {
			return false;
		}
	}

}