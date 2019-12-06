package dfs.p16346아기상어;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static Fish[][] map;
	static boolean[][] isEat;
	static Queue<Fish> feedableFish;
	static Fish shark;
	static int time = 0;
	static int feedable = 0;
	static int[][] distanceFromShark;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		map = new Fish[N + 1][N + 1];
		isEat = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int size = scr.nextInt();
				if (size == 9) {
					map[i][j] = new Fish(i, j, 2, 0);
					shark = new Fish(i, j, 2, 0);
					isEat[i][j] = true;
				} else {
					map[i][j] = new Fish(i, j, size, 0);
				}

			}
		}

		while (true) {
			distanceFromShark = new int[N + 1][N + 1];
			feedableFish = new LinkedList<>();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					distanceFromShark[i][j] = Integer.MAX_VALUE;
				}
			}

			findFeedableFish();
			// System.out.println("feedableFish: " + feedableFish.size());
			if (feedableFish.size() == 0) {
				break;
			}
			findMinAndLeftFeed();
		}

		// System.out.println();
		System.out.println(time);
		System.out.println();

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(map[i][j].size + " ");
//			}
//			System.out.println();
//		}
	}

	public static void findFeedableFish() {
		boolean[][] visited = new boolean[N + 1][N + 1];
		Queue<Fish> sharkMoving = new LinkedList<>();
		sharkMoving.add(shark);
		visited[shark.y][shark.x] = true;

		while (!sharkMoving.isEmpty()) {
			Fish sharkMove = sharkMoving.poll();

			if (sharkMove.y - 1 >= 1 && shark.size >= map[sharkMove.y - 1][sharkMove.x].size
					&& !visited[sharkMove.y - 1][sharkMove.x]) {
				// System.out.println("u");
				visited[sharkMove.y - 1][sharkMove.x] = true;
				if (map[sharkMove.y - 1][sharkMove.x].size == 0
						|| map[sharkMove.y - 1][sharkMove.x].size == shark.size) {
					sharkMoving.add(new Fish(sharkMove.y - 1, sharkMove.x, map[sharkMove.y - 1][sharkMove.x].size,
							sharkMove.distanceFromShark + 1));
				} else {
					// sharkMoving.add(map[sharkMove.y - 1][sharkMove.x]);
					feedableFish.add(new Fish(sharkMove.y - 1, sharkMove.x, map[sharkMove.y - 1][sharkMove.x].size,
							sharkMove.distanceFromShark + 1));
				}
			}

			if (sharkMove.y + 1 <= N && shark.size >= map[sharkMove.y + 1][sharkMove.x].size
					&& !visited[sharkMove.y + 1][sharkMove.x]) {
				// System.out.println("d");
				visited[sharkMove.y + 1][sharkMove.x] = true;
				if (map[sharkMove.y + 1][sharkMove.x].size == 0
						|| map[sharkMove.y + 1][sharkMove.x].size == shark.size) {
					sharkMoving.add(new Fish(sharkMove.y + 1, sharkMove.x, map[sharkMove.y + 1][sharkMove.x].size,
							sharkMove.distanceFromShark + 1));
				} else {
					// sharkMoving.add(map[sharkMove.y + 1][sharkMove.x]);
					feedableFish.add(new Fish(sharkMove.y + 1, sharkMove.x, map[sharkMove.y + 1][sharkMove.x].size,
							sharkMove.distanceFromShark + 1));
				}
			}

			if (sharkMove.x - 1 >= 1 && shark.size >= map[sharkMove.y][sharkMove.x - 1].size
					&& !visited[sharkMove.y][sharkMove.x - 1]) {
				// System.out.println("l");
				visited[sharkMove.y][sharkMove.x - 1] = true;
				if (map[sharkMove.y][sharkMove.x - 1].size == 0
						|| map[sharkMove.y][sharkMove.x - 1].size == shark.size) {
					sharkMoving.add(new Fish(sharkMove.y, sharkMove.x - 1, map[sharkMove.y][sharkMove.x - 1].size,
							sharkMove.distanceFromShark + 1));
				} else {
					// sharkMoving.add(map[sharkMove.y][sharkMove.x - 1]);
					feedableFish.add(new Fish(sharkMove.y, sharkMove.x - 1, map[sharkMove.y][sharkMove.x - 1].size,
							sharkMove.distanceFromShark + 1));
				}
			}

			if (sharkMove.x + 1 <= N && shark.size >= map[sharkMove.y][sharkMove.x + 1].size
					&& !visited[sharkMove.y][sharkMove.x + 1]) {
				// System.out.println("r");
				visited[sharkMove.y][sharkMove.x + 1] = true;
				if (map[sharkMove.y][sharkMove.x + 1].size == 0
						|| map[sharkMove.y][sharkMove.x + 1].size == shark.size) {
					sharkMoving.add(new Fish(sharkMove.y, sharkMove.x + 1, map[sharkMove.y][sharkMove.x + 1].size,
							sharkMove.distanceFromShark + 1));
				} else {
					// sharkMoving.add(map[sharkMove.y][sharkMove.x + 1]);
					feedableFish.add(new Fish(sharkMove.y, sharkMove.x + 1, map[sharkMove.y][sharkMove.x + 1].size,
							sharkMove.distanceFromShark + 1));
				}
			}
		}

	}

	public static void findMinAndLeftFeed() {
		int min = Integer.MAX_VALUE;
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int index = -1;
		int min_fish = -1;
		List<Fish> minFishs = new LinkedList<>();

		for (Fish fish : feedableFish) {
			if (min > fish.distanceFromShark) {
				min_fish = fish.size;
				min = fish.distanceFromShark;
			}

			index++;
		}

		for (Fish fish : feedableFish) {
			if (min == fish.distanceFromShark) {
				minFishs.add(fish);
			}
		}

		for (Fish fish : minFishs) {
			if (minY > fish.y) {
				minY = fish.y;
			}
		}

		for (Fish fish : minFishs) {
			if (minY == fish.y) {
				if (minX > fish.x) {
					minX = fish.x;
				}
			}
		}

//		System.out.println("x= " + minX + " y=" + minY);

		time += min;
		map[minY][minX].size = 0;
		// isEat[minY][minX] = true;
		map[shark.y][shark.x].size = 0;
		shark.x = minX;
		shark.y = minY;

		feedable++;
		if (feedable == shark.size) {
			shark.size++;
			feedable = 0;
		}

	}
}

class Fish {
	int x, y, size, distanceFromShark;

	public Fish(int y, int x, int size, int distanceFromShark) {
		this.y = y;
		this.x = x;
		this.size = size;
		this.distanceFromShark = distanceFromShark;
	}
}

// import java.util.LinkedList;
// import java.util.List;
// import java.util.Scanner;
//
// public class Main {
// static Fish[][] map;
// static int N;
// static int count = 0;
// static int time = 0;
// static int sharkFeed = 0;
// static Fish shark;
// static boolean[][] visited;
// static int x, y;
// static List<Fish> fishs = new LinkedList<>();
//
// public static void main(String[] args) {
// Scanner scr = new Scanner(System.in);
// N = scr.nextInt();
//
// map = new Fish[N + 1][N + 1];
// visited = new boolean[N + 1][N + 1];
//
// for (int i = 1; i <= N; i++) {
// for (int j = 1; j <= N; j++) {
// int fish = scr.nextInt();
// if (fish != 0 && fish != 9) {
// count++;
// fishs.add(new Fish(j, i, fish));
// }
// if (fish == 9) {
// shark = new Fish(j, i, 2);
// // y = i;
// // x = j;
// // visited[i][j] = true;
// }
//
// map[i][j] = new Fish(j, i, fish);
// }
// }
// // System.out.println(fishs.size());
// while (true) {
// if (fishs.isEmpty())
// break;
// if (count == 0)
// break;
// if (y - 1 < 1 && y + 1 > N && x - 1 < 1 && x + 1 > N) {
// break;
// }
//
// if ((y - 1 >= 1 && map[y - 1][x].size > shark.size) && (y + 1 <= N && map[y +
// 1][x].size > shark.size)
// && (x - 1 >= 1 && map[y][x - 1].size > shark.size)
// && (x + 1 <= N && map[y][x + 1].size > shark.size)) {
// break;
// }
//
// int min = Integer.MAX_VALUE;
// int min_index = 0;
// int index = 0;
// int minFishSize = 0;
// while (index < fishs.size()) {
// int value = Math.abs(shark.y - fishs.get(index).y) + Math.abs(shark.x -
// fishs.get(index).x);
//
// if (min > value && shark.size >
// map[fishs.get(index).y][fishs.get(index).x].size) {
// min = value;
// minFishSize = fishs.get(index).size;
// min_index = index;
// }
// index++;
// }
// System.out.println("minFishSize: " + minFishSize);
// index = 0;
// List<Fish> minFish = new LinkedList<>();
//
// while (index < fishs.size()) {
// if (minFishSize == fishs.get(index).size) {
// minFish.add(fishs.get(index));
// }
// index++;
// }
//
// int minX = Integer.MAX_VALUE;
// int minY = 0;
// index = 0;
// while (index < minFish.size()) {
// // System.out.println("minFish.x=" + minFish.get(index).x);
// if (minX > minFish.get(index).x) {
// minX = minFish.get(index).x;
// minY = minFish.get(index).y;
// }
// index++;
// }
//
//// if (shark.size > map[minY][minX].size) {
// System.out.println("shark.x=" + shark.x + " minX=" + minX);
// System.out.println("shark.y=" + shark.y + " minY=" + minY);
// time += Math.abs(shark.x - minX) + Math.abs(shark.y - minY);
// shark.x = minX;
// shark.y = minY;
// sharkFeed += 1;
// fishs.remove(min_index);
// System.out.println("shark.x=" + shark.x + " minX=" + minX);
// System.out.println("shark.y=" + shark.y + " minY=" + minY);
//
// if (sharkFeed == shark.size) {
// shark.size += 1;
// sharkFeed = 0;
// }
//// }
// }
//
// System.out.println(time);
// }
// }
//
// class Fish {
// int x, y;
// int size;
//
// public Fish(int x, int y, int size) {
// this.x = x;
// this.y = y;
// this.size = size;
// }
// }
