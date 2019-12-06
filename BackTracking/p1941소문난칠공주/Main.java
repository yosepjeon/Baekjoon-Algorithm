package BackTracking.p1941소문난칠공주;

import java.util.Scanner;

public class Main {
	static char[][] map = new char[5][5];
	static boolean[][] visited = new boolean[5][5];;
	static boolean[][] checkVisited = new boolean[5][5];
	static int N = 7;
	static int CNT = 0;
	static int result = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			map[i] = scr.next().toCharArray();
		}
		
		for (int j = 0; j <= 25 - N; j++) {
			visited[j / 5][j % 5] = true;
			if (map[j / 5][j % 5] == 'S')
				choiceMember(j, j, 1, 1);
			else
				choiceMember(j, j, 1, 0);
			visited[j / 5][j % 5] = false;
		}

		System.out.println(result);
	}

	public static void choiceMember(int begin, int startNum, int count, int sCount) {
		if (count == 7) {
			if (sCount >= 4) {
				CNT = 1;
				checkVisited = new boolean[5][5];
				checkVisited[begin / 5][begin % 5] = true;

				checkIsCorrect(begin / 5, begin % 5);
			}
			return;
		}
		// System.out.println(count);
		for (int i = startNum + 1; i <= 25 - (N - count); i++) {
			visited[i / 5][i % 5] = true;
			if (map[i / 5][i % 5] == 'S') {
				choiceMember(begin, i, count + 1, sCount + 1);
			} else {
				choiceMember(begin, i, count + 1, sCount);
			}
			visited[i / 5][i % 5] = false;
		}
	}

	public static void checkIsCorrect(int y, int x) {
		if (CNT == 7) {
			result++;
			return;
		}

		if (y - 1 >= 0 && visited[y - 1][x] && !checkVisited[y - 1][x]) {
			CNT++;
			checkVisited[y - 1][x] = true;
			checkIsCorrect(y - 1, x);
		}

		if (y + 1 < 5 && visited[y + 1][x] && !checkVisited[y + 1][x]) {
			CNT++;
			checkVisited[y + 1][x] = true;
			checkIsCorrect(y + 1, x);
		}

		if (x - 1 >= 0 && visited[y][x - 1] && !checkVisited[y][x - 1]) {
			CNT++;
			checkVisited[y][x - 1] = true;
			checkIsCorrect(y, x - 1);
		}

		if (x + 1 < 5 && visited[y][x + 1] && !checkVisited[y][x + 1]) {
			CNT++;
			checkVisited[y][x + 1] = true;
			checkIsCorrect(y, x + 1);
		}
	}
}
