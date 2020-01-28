package 완전탐색.p2573빙산;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	// public static NorthPole[][] northPole;
	public static int height;
	public static int width;
	public static int iceArea = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		int y, x;

		y = scr.nextInt();
		x = scr.nextInt();
		height = y;
		width = x;

		NorthPole[][] map = new NorthPole[y+1][x+1];
		LinkedList<NorthPole> list = new LinkedList<>();

		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				int height = scr.nextInt();

				if (height == 0) {
					map[i][j] = new NorthPole(0, i, j, 0, height);
				} else {
					map[i][j] = new NorthPole(1, i, j, 0, height);
					list.add(map[i][j]);
				}
			}
		}

		int year = 0;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (map[i][j].id == 1 && !map[i][j].isVisited) {
					iceArea++;
					map[i][j].isVisited = true;
					countIceArea(map, i, j);
				}
			}
		}
		
		if(iceArea >= 2) {
			System.out.println(year);
			return;
		}

		while (true) {
			iceArea = 0;
			setVisitAttributeToFalse(map);
			checkCountAroundSea(list, map);
			doMelt(list);
			
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					if(!map[i][j].isVisited && map[i][j].id == 1) {
						iceArea++;
						map[i][j].isVisited = true;
						countIceArea(map, i, j);
					}
				}
			}
			year++;
			
//			for(int i=0;i<height;i++) {
//				for(int j=0;j<width;j++) {
//					System.out.print(map[i][j].height + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("year: " + year + " iceArea: " + iceArea);
			if(list.isEmpty()){
				System.out.println(0);
				return;
			}
			
			if(iceArea >= 2)
				break;
		}
		
//		for(int i=0;i<height;i++) {
//			for(int j=0;j<width;j++) {
//				System.out.print(map[i][j].height + " ");
//			}
//			System.out.println();
//		}
		
		if(iceArea < 2) {
			System.out.println(0);
		}else {
			System.out.println(year);
		}
	}
	
	public static void setVisitAttributeToFalse(NorthPole[][] map) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (map[i][j].id == 1) {
					map[i][j].isVisited = false;
				}
			}
		}
	}

	public static void checkCountAroundSea(List<NorthPole> list, NorthPole[][] map) {
		for (NorthPole northPole : list) {
			northPole.checkSea(map);
		}
	}

	public static void doMelt(LinkedList<NorthPole> list) {
		for (NorthPole northPole : list) {
			northPole.melt();
		}

		int listSize = list.size();
		
		for (int i = 0; i < listSize; i++) {
			NorthPole northPole = list.poll();

			if (northPole.id != 0) {
				list.add(northPole);
			}
		}
	}
	
	public static void countIceArea(NorthPole[][] map, int y, int x) {
		Queue<NorthPole> queue = new LinkedList<>();
		queue.add(map[y][x]);

		while (!queue.isEmpty()) {
			NorthPole element = queue.poll();

			// 동
			if (element.x + 1 < Main.width && !map[element.y][element.x + 1].isVisited && map[element.y][element.x + 1].id == 1) {
				map[element.y][element.x+1].isVisited = true;
				queue.add(map[element.y][element.x+1]);
			}

			// 서
			if (element.x - 1 >= 0 && !map[element.y][element.x - 1].isVisited && map[element.y][element.x - 1].id == 1) {
				map[element.y][element.x-1].isVisited = true;
				queue.add(map[element.y][element.x-1]);
			}
			// 남
			if (element.y + 1 < Main.height && !map[element.y + 1][element.x].isVisited && map[element.y + 1][element.x].id == 1) {
				map[element.y+1][element.x].isVisited = true;
				queue.add(map[element.y+1][element.x]);
			}

			// 북
			if (element.y - 1 >= 0 && !map[element.y - 1][element.x].isVisited && map[element.y - 1][element.x].id == 1) {
				map[element.y-1][element.x].isVisited = true;
				queue.add(map[element.y-1][element.x]);
			}
		}
	}
}

class NorthPole {
	int id; // 0 바다 1 빙산
	int x, y;
	int countSea; // 동서남북 바다 갯수
	int height; // 높이
	boolean isVisited;

	public NorthPole(int id, int y, int x, int countSea, int height) {
		this.id = id;
		this.y = y;
		this.x = x;
		this.countSea = countSea;
		this.height = height;
	}

	public void checkSea(NorthPole[][] map) {
		// 동
		if (this.x + 1 < Main.width && map[this.y][this.x + 1].id == 0) {
			this.countSea++;
		}

		// 서
		if (this.x - 1 >= 0 && map[this.y][this.x - 1].id == 0) {
			this.countSea++;
		}
		// 남
		if (this.y + 1 < Main.height && map[this.y + 1][this.x].id == 0) {
			this.countSea++;
		}

		// 북
		if (this.y - 1 >= 0 && map[this.y - 1][this.x].id == 0) {
			this.countSea++;
		}
	}

	public void melt() {
		this.height -= this.countSea;
		this.countSea = 0;
		if (this.height <= 0) {
			this.id = 0;
			this.height = 0;
		}
	}
}
