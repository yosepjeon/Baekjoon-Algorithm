package 시뮬레이션.p14503로봇청소기;

import java.util.Scanner;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] isClean;
	static Robot robot;

	static boolean condition1 = true, condition2 = false, condition3 = false, condition4 = false;

	// 서:3 남:2 동:1 북:0

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int r, c, direction;

		N = scr.nextInt();
		M = scr.nextInt();

		map = new int[N + 1][M + 1];
		isClean = new boolean[N + 1][M + 1];

		r = scr.nextInt();
		c = scr.nextInt();
		direction = scr.nextInt();

		robot = new Robot(r+1, c+1, direction);

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = scr.nextInt();
			}
		}

		run();

		System.out.println(robot.count);
	}

	public static void run() {
		int checkRobotCircle;
		boolean endFlag = false;
		robot: while (true) {
			if (!isClean[robot.r][robot.c]) {
				isClean[robot.r][robot.c] = true;
				robot.count += 1;
			}

			int leftDirection = robot.direction;
			checkRobotCircle = robot.direction - 1;

			leftDirection -= 1;

			if (leftDirection == -1) {
				leftDirection = 3;
			}

			if ((map[robot.r - 1][robot.c] == 1 || isClean[robot.r - 1][robot.c])
					&& (map[robot.r + 1][robot.c] == 1 || isClean[robot.r + 1][robot.c])
					&& (map[robot.r][robot.c - 1] == 1 || isClean[robot.r][robot.c - 1])
					&& (map[robot.r][robot.c + 1] == 1 || isClean[robot.r][robot.c + 1])) {			
				switch (robot.direction) {
				case 0: // 북
					if (map[robot.r + 1][robot.c] == 1) {
						endFlag = true;
						break;
					}
					robot.r += 1;
					break;
				case 1: // 동
					if (map[robot.r][robot.c - 1] == 1) {
						endFlag = true;
						break;
					}
					robot.c -= 1;
					break;
				case 2: // 남
					if (map[robot.r - 1][robot.c] == 1) {
						endFlag = true;
						break;
					}
					robot.r -= 1;
					break;
				case 3: // 서
					if (map[robot.r][robot.c + 1] == 1) {
						endFlag = true;
						break;
					}
					robot.c += 1;
					break;
				}
			} else {
				switch (leftDirection) {
				case 0: // 북
					if (robot.r - 1 >= 1 && map[robot.r - 1][robot.c] != 1 && !isClean[robot.r - 1][robot.c]) {
						robot.direction = 0;
						robot.r -= 1;
					}
					robot.direction = 0;
					break;
				case 1: // 동
					if (robot.c + 1 <= M && map[robot.r][robot.c + 1] != 1 && !isClean[robot.r][robot.c + 1]) {
						robot.direction = 1;
						robot.c += 1;
					}
					robot.direction = 1;
					break;
				case 2: // 남
					if (robot.r + 1 <= N && map[robot.r + 1][robot.c] != 1 && !isClean[robot.r + 1][robot.c]) {
						robot.direction = 2;
						robot.r += 1;
					}
					robot.direction = 2;
					break;
				case 3: // 서
					if (robot.c - 1 >= 1 && map[robot.r][robot.c - 1] != 1 && !isClean[robot.r][robot.c - 1]) {
						robot.direction = 3;
						robot.c -= 1;
					}
					robot.direction = 3;
					break;
				}
			}

			if (endFlag)
				break;

		}
	}
}

// 현재 위치
// 바라보는 방향

class Robot {
	int r, c;
	int direction;
	int count;

	public Robot(int r, int c, int direction) {
		this.r = r;
		this.c = c;
		this.direction = direction;
		this.count = 0;
	}
}

// public static void run() {
//
// robot:
// while (true) {
// if (condition1) {
// isClean[robot.r][robot.c] = true;
// robot.count += 1;
// condition1 = false;
// }
//
// robot.direction -= 1;
//
// if (robot.direction % 4 == -1)
// robot.direction = 3;
//
// switch (robot.direction) {
// case 0:
// if (robot.c - 1 >= 1 && map[robot.r][robot.c - 1] != 1 &&
// !isClean[robot.r][robot.c - 1]) {
// robot.c -= 1;
// } else {
//
// }
// break;
// case 1:
// if (robot.r + 1 <= N && map[robot.r + 1][robot.c] == 0 && !isClean[robot.r +
// 1][robot.c - 1]) {
// robot.r += 1;
// condition1 = true;
// continue;
// } else {
// if (robot.r + 1 > N) {
// continue;
// }
//
// if (((isClean[robot.r + 1][robot.c] || map[robot.r + 1][robot.c] == 1)
// && (isClean[robot.r - 1][robot.c] || map[robot.r - 1][robot.c] == 1)
// && (isClean[robot.r][robot.c + 1] || map[robot.r][robot.c + 1] == 1)
// && (isClean[robot.r][robot.c - 1] || map[robot.r][robot.c - 1] == 1)) ==
// true) {
//
//
// switch(robot.direction) {
// case 0: //북
// if(map[robot.r+1][robot.c] == 1)
// break robot;
// robot.r += 1;
// break;
// case 1: //동
// if(map[robot.r][robot.c-1] == 1)
// break robot;
// break;
// case 2: // 남
// if(map[robot.r-1][robot.c] == 1)
// break robot;
// break;
// case 3: // 서
// if(map[robot.r][robot.c+1] == 1)
// break robot;
// break;
// }
//
//
// }
// }
// break;
// case 2:
// if (robot.c + 1 <= M && map[robot.r][robot.c + 1] == 0 &&
// !isClean[robot.r][robot.c + 1]) {
// robot.c += 1;
// } else {
//
// }
// break;
// case 3:
// if (robot.r - 1 >= 1 && map[robot.r - 1][robot.c] == 0 && !isClean[robot.r -
// 1][robot.c]) {
// robot.r -= 1;
// } else {
//
// }
// break;
// }
// }
// }
