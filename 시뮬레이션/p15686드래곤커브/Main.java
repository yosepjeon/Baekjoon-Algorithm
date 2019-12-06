package 시뮬레이션.p15686드래곤커브;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Stack<Integer> dragonStack = new Stack();
	static Stack<Integer> tempStack;
	static int N;
	static int x, y, d, g;
	static boolean[][] map = new boolean[101][101];
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();

		for (int i = 1; i <= N; i++) {
			tempStack = new Stack<>();
			dragonStack = new Stack<>();
			x = scr.nextInt();
			y = scr.nextInt();
			d = scr.nextInt();
			g = scr.nextInt();

			tempStack.push(d);
			dragonStack.push(d);
			
			moveByDirection(d);

			dragonCurveDfs(x,y,1);
		}
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
					count++;
				}
			}
		}
		
//		for(int i=0;i<=100;i++) {
//			for(int j=0;j<=100;j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(count);
	}

	public static void dragonCurveDfs(int dx, int dy, int generation) {
		int direction;
		x = dx;
		y = dy;
		if (g < generation) {
			return;
		} else {
			map[y][x] = true;

			Iterator<Integer> itr = tempStack.iterator();

//			while (itr.hasNext()) {
//				direction = itr.next();
//
//				dragonStack.push(direction);
//			}

			while (!tempStack.isEmpty()) {
//				System.out.println("tempStackSize: " + tempStack.size());
				direction = tempStack.pop();
//				System.out.println("direction: " + direction);
				direction = (direction + 1) % 4;
				
				moveByDirection(direction);
				
				dragonStack.push(direction);
			}
			
			itr = dragonStack.iterator();
//			System.out.println("dragonStackSize: " + dragonStack.size());
			
			while(itr.hasNext()) {
				direction = itr.next();
				
				tempStack.push(direction);
			}
			
			dragonCurveDfs(x,y,generation+1);
		}
	}

	public static void moveByDirection(int d) {
		map[y][x] = true;
//		System.out.println("call");
		switch (d) {
		case 0:
			map[y][x + 1] = true;
			x = x + 1;
			break;
		case 1:
			map[y - 1][x] = true;
			y = y - 1;
			break;
		case 2:
			map[y][x - 1] = true;
			x = x - 1;
			break;
		case 3:
			map[y + 1][x] = true;
			y = y + 1;
			break;
		}
	}
}