package BackTracking.p2580스도쿠.version1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] map = new int[9][9];
	static boolean endFlag = false;
	static List<Element> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				int value = scr.nextInt();
				
				if(value == 0) {
					list.add(new Element(i,j));
				}
				
				map[i][j] = value;
			}
		}
		
		doLogic(0);
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void doLogic(int index) {
		
		if(index == list.size()) {
			endFlag = true;
			return;
		}
		
		Element element = list.get(index);
		
		for(int i=1;i<=9;i++) {
			if(check(element.row, element.col,i)) {
				map[element.row][element.col] = i;
				doLogic(index+1);
			}
			
			if(endFlag)
				return;
		}
		
	}

	public static boolean check(int row, int col, int value) {
		if (rowCheck(col, value) && colCheck(row, value) && areaCheck(row, col, value)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean rowCheck(int col, int value) {
		for (int i = 0; i < 9; i++) {
			if (map[col][i] == value) {
				System.out.println("row fail");
				return false;
			}
		}

		return true;
	}

	public static boolean colCheck(int row, int value) {
		for (int i = 0; i < 9; i++) {
			if (map[i][row] == value) {
				System.out.println("col fail");
				return false;
			}
		}

		return true;
	}

	public static boolean areaCheck(int row, int col, int value) {
		int x = col / 3;
		int y = row / 3;

		for (int i = 3 * y; i < 3 * y + 3; i++) {
			for (int j = 3 * x; j < 3 * x + 3; j++) {
				if (map[i][j] == value) {
					System.out.println("area fail");
					return false;
				}
			}
		}

		return true;
	}
}

class Element {
	int row,col;
	
	public Element(int row,int col) {
		this.col = col;
		this.row = row;
	}
}
