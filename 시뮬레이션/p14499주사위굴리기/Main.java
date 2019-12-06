package 시뮬레이션.p14499주사위굴리기;

import java.util.Scanner;

public class Main {
	static int N; // 지도의 세로 크기
	static int M; // 지도의 가로 크기
	static int x, y; // 주사위를 놓은 곳의 좌표
	static int K; // 명령의 개수
	static int[][] map;
	static int[] instruction;
	static int[] dice = new int[7];

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		M = scr.nextInt();
		y = scr.nextInt();
		x = scr.nextInt();
		K = scr.nextInt();

		x++;
		y++;

		map = new int[N + 1][M + 1];
		instruction = new int[K + 1];

		for (int i = 1; i <= 6; i++) {
			dice[i] = 0;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = scr.nextInt();
			}
		}

		map[y][x] = 0;

		for (int i = 1; i <= K; i++) {
			instruction[i] = scr.nextInt();
		}

		for (int i = 1; i <= K; i++) {
			move(i);
		}

		System.out.print(sb.toString());
	}

	public static void move(int index) {
		int direction = instruction[index];
		int[] tempDice = new int[7];

		if (direction == 1) { // 동
			if (x + 1 <= M) {
				tempDice[1] = dice[4];
				tempDice[2] = dice[2];
				tempDice[3] = dice[1];
				tempDice[4] = dice[6];
				tempDice[5] = dice[5];
				tempDice[6] = dice[3];

				for (int i = 1; i <= 6; i++) {
					dice[i] = tempDice[i];
				}
				
				if (map[y][x+1] == 0) {
					map[y][x+1] = dice[6];
					x++;
				} else {
					dice[6] = map[y][x+1];
					map[y][x+1] = 0;
					x++;
				}

				sb.append(dice[1] + "\n");
			}
		} else if (direction == 2) { // 서
			if (x - 1 >= 1) {
				tempDice[1] = dice[3];
				tempDice[2] = dice[2];
				tempDice[3] = dice[6];
				tempDice[4] = dice[1];
				tempDice[5] = dice[5];
				tempDice[6] = dice[4];

				for (int i = 1; i <= 6; i++) {
					dice[i] = tempDice[i];
				}
				
				if (map[y][x-1] == 0) {
					map[y][x-1] = dice[6];
					x--;
				} else {
					dice[6] = map[y][x-1];
					map[y][x-1] = 0;
					x--;
				}

				sb.append(dice[1] + "\n");
			}
		} else if (direction == 3) { // 북
			if (y - 1 >= 1) {
				tempDice[1] = dice[5];
				tempDice[2] = dice[1];
				tempDice[3] = dice[3];
				tempDice[4] = dice[4];
				tempDice[5] = dice[6];
				tempDice[6] = dice[2];

				for (int i = 1; i <= 6; i++) {
					dice[i] = tempDice[i];
				}
				
				if (map[y-1][x] == 0) {
					map[y-1][x] = dice[6];
					y--;
				} else {
					dice[6] = map[y-1][x];
					map[y-1][x] = 0;
					y--;
				}

				sb.append(dice[1] + "\n");
			}
		} else if (direction == 4) { // 남
			if (y + 1 <= N) {
				tempDice[1] = dice[2];
				tempDice[2] = dice[6];
				tempDice[3] = dice[3];
				tempDice[4] = dice[4];
				tempDice[5] = dice[1];
				tempDice[6] = dice[5];

				for (int i = 1; i <= 6; i++) {
					dice[i] = tempDice[i];
				}
				
				if (map[y+1][x] == 0) {
					map[y+1][x] = dice[6];
					y++;
				} else {
					dice[6] = map[y+1][x];
					map[y+1][x] = 0;
					y++;
				}

				sb.append(dice[1] + "\n");
			}
		}
	}
}
