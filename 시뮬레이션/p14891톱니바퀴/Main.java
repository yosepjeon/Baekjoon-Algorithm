package 시뮬레이션.p14891톱니바퀴;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] gears = new int[4][8];
	static int K;
	static int gearNum,direct;
	static int[] turnState = new int[4];
	static boolean[] isTurn = new boolean[4];
	static int result = 0;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		for(int i=0;i<4;i++) {
			String number = scr.next();
			char[] carr = new char[8];
			
			carr = number.toCharArray();
			
			for(int j=0;j<8;j++) {
				gears[i][j] = (int)(carr[j] - '0');
//				System.out.print(gears[i][j]);
			}
//			System.out.println();
		}
		
		K = scr.nextInt();
		
		for(int i=0;i<K;i++) {
			gearNum = scr.nextInt();
			direct = scr.nextInt();
			for(int j=0;j<4;j++) {
				turnState[j] = 0;
				isTurn[j] = false;
			}
			
			changeTurnStateBFS(gearNum-1,direct);
			changeGears();
		}
		
		if(gears[0][0] == 1) {
			result += 1;
		}
		
		if(gears[1][0] == 1) {
			result += 2;
		}
		
		if(gears[2][0] == 1) {
			result += 4;
		}
		
		if(gears[3][0] == 1) {
			result += 8;
		}
		
//		for(int i=0;i<4;i++) {
//			for(int j=0;j<8;j++) {
//				System.out.print(gears[i][j]);
//			}
//			System.out.println();
//		}
		
		System.out.println(result);
	}
	
	public static void changeTurnStateBFS(int gearNum, int direct) {
		Queue<Integer> queue = new LinkedList<>();
		turnState[gearNum] = direct;
		isTurn[gearNum] = true;
		queue.add(gearNum);
		
		while(!queue.isEmpty()) {
			int element = queue.poll();
			
			if(element-1>=0 && !isTurn[element-1] && turnState[element] != 0) {
				if(gears[element][6] != gears[element-1][2]) {
					turnState[element-1] = turnState[element] * -1;
				}else {
					turnState[element-1] = 0;
				}
				
				isTurn[element-1] = true;
				queue.add(element-1);
			}
			
			if(element+1<4 && !isTurn[element+1] && turnState[element] != 0) {
				if(gears[element][2] != gears[element+1][6]) {
					turnState[element+1] = turnState[element] * -1;
				}else {
					turnState[element+1] = 0;
				}
				
				isTurn[element+1] = true;
				queue.add(element+1);
			}
		}
	}
	
	public static void changeGears() {
		for(int i=0;i<4;i++) {
			if(turnState[i] == 1) {
				int num = gears[i][7];
				
				for(int j=7;j>0;j--) {
					gears[i][j] = gears[i][j-1];
				}
				
				gears[i][0] = num;
			}else if(turnState[i] == -1) {
				int num = gears[i][0];
				
				for(int j=0;j<7;j++) {
					gears[i][j] = gears[i][j+1];
				}
				
				gears[i][7] = num;
			}else if(turnState[i] == 0){
				
			}
		}
	}
}
