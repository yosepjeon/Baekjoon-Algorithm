package BackTracking.p2580스도쿠;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static int[][] map = new int[9][9];
	static Deque<Element> queue = new LinkedList<Element>();
	static Stack<Element> stack = new Stack<>();
	static Element[] table = new Element[81];
	static int curX, curY;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int cnt = 0;
		int emptyCount = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int num = scr.nextInt();
				if (num == 0) {
					queue.add(new Element(j, i));
					table[j * (i + 1) + i] = new Element(j, i);
					emptyCount++;
				}
				map[i][j] = num;
			}
		}

		 putNumberIntoMap();

		// while (!queue.isEmpty()) {
		// Element element = queue.poll();
		//
		// checkLogic(element);
		// boolean result = putNumberIntoMap(element);
		// }

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static boolean putNumberIntoMap() {
		if (queue.isEmpty()) {
			return true;
		}
		
		Element e = queue.pollFirst();
		
		if (!checkLogic(e)) {
//			System.out.println("!!");
			return false;
		}

		for (int i = 0; i < 9; i++) {
			if(!e.checkAvailableNum[i]) {
				map[e.y][e.x] = i;
				
				if(putNumberIntoMap()) {
					return true;
				}
				
				queue.addFirst(e);
				map[e.y][e.x] = 0;
			}
		}

		return false;
	}

	public static boolean findEmpty() {
		// for(int i=0;i<=9;i++) {
		// for(int j=0;j<=9;j++) {
		// if(map[i][j] == 0) {
		// curX = j;
		// curY = i;
		// return true;
		// }
		// }
		// }

		return false;
	}

	public static boolean checkLogic(Element element) {
		// checkHeight(element);
		// checkWidth(element);
		// checkCircle(element);
		if (checkHeight(element) && checkWidth(element) && checkCircle(element)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkHeight(Element element) {
		boolean flag = false;

		for (int i = 0; i < 9; i++) {
			if (map[i][element.x] == 0) {
				element.checkAvailableNum[map[i][element.x]] = true;
				flag = true;
			}
		}

		return flag;
	}

	public static boolean checkWidth(Element element) {
		boolean flag = false;

		for (int i = 0; i < 9; i++) {
			if (map[element.y][i] == 0) {
				element.checkAvailableNum[map[element.y][i]] = true;
				flag = true;
			}
		}
		return flag;
	}

	public static boolean checkCircle(Element element) {
		int x = element.x / 3;
		int y = element.y / 3;
		boolean flag = false;

		for (int i = 3 * y; i < 3 * y + 3; i++) {
			for (int j = 3 * x; j < 3 * x + 3; j++) {
				if (map[i][j] == 0) {
					element.checkAvailableNum[map[i][j]] = true;
					flag = true;
				}
			}
		}

		return flag;
	}
}

class Element {
	int x, y;
	boolean[] checkAvailableNum;

	public Element(int x, int y) {
		this.x = x;
		this.y = y;
		this.checkAvailableNum = new boolean[10];
	}
}