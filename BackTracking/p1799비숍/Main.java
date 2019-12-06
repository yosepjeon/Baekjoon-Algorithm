package BackTracking.p1799비숍;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static LinkedList<AvailableBlock> whiteQueue = new LinkedList<AvailableBlock>();
	static LinkedList<AvailableBlock> blackQueue = new LinkedList<>();
	static int whiteCount = Integer.MIN_VALUE;
	static int blackCount = Integer.MIN_VALUE;
	static int maxCount = 0;
	static int result = 0;
	static int max = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();

		map = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = scr.nextInt();
				if (map[i][j] == 1) {
					if (i % 2 == 1 && j % 2 == 1) {
						// System.out.println("w");
						whiteQueue.add(new AvailableBlock(i, j));
					} else if (i % 2 == 1 && j % 2 == 0) {
						// System.out.println("b");
						blackQueue.add(new AvailableBlock(i, j));
					} else if (i % 2 == 0 && j % 2 == 1) {
						// System.out.println("b");
						blackQueue.add(new AvailableBlock(i, j));
					} else if (i % 2 == 0 && j % 2 == 0) {
						// System.out.println("w");
						whiteQueue.add(new AvailableBlock(i, j));
					}
				}
			}
		}

		// System.out.println(whiteQueue.size());
		// System.out.println(blackQueue.size());

		// System.out.println("white");
		for (int i = 0; i < whiteQueue.size(); i++) {
			LinkedList<AvailableBlock> cloneList = new LinkedList<>();
			Iterator<AvailableBlock> itr = whiteQueue.iterator();
			while (itr.hasNext()) {
				AvailableBlock e = itr.next();
				cloneList.add(new AvailableBlock(e.y, e.x));
			}
			
			dfs(0, cloneList, cloneList.size());
		}
		result += maxCount;
		maxCount = 0;
		// System.out.println("black");
		for (int i = 0; i < blackQueue.size(); i++) {
			LinkedList<AvailableBlock> cloneList = new LinkedList<>();
			Iterator<AvailableBlock> itr = blackQueue.iterator();
			while (itr.hasNext()) {
				AvailableBlock e = itr.next();
				cloneList.add(new AvailableBlock(e.y, e.x));
			}
			System.out.println(cloneList.equals(blackQueue));

//			dfs(0, cloneList, cloneList.size());
		}
		
		result += maxCount;

		System.out.println(result);
	}

	public static void dfs(int count, LinkedList<AvailableBlock> queue, int size) {
		// System.out.println(count + " : " + queue.size());
		if (queue.size() <= count) {
			// System.out.println(queue.size()+"!");
			if (maxCount <= queue.size())
				maxCount = max;
			max = 0;
			return;
		}

		compare: for (int i = 0; i < queue.size(); i++) {
			// System.out.println(queue.peek().x +" : "+ queue.peek().y);
			AvailableBlock element = queue.poll();
			element.isChecked = true;

			Iterator<AvailableBlock> itr = queue.iterator();
			while (itr.hasNext()) {
				AvailableBlock compElem = itr.next();

				if ((element.x - element.y) == (compElem.x - compElem.y) && compElem.isChecked) {
					// element.isChecked = false;
					// queue.add(element);
					queue.remove(compElem);
					// continue compare;
				}

				if ((element.x + element.y) == (compElem.x + compElem.y) && compElem.isChecked) {
					// element.isChecked = false;
					// queue.add(element);
					queue.remove(compElem);
					// continue compare;
				}
			}

			element.isChecked = true;
			queue.add(element);
			dfs(count + 1, queue, size);
			element.isChecked = false;

		}
	}
}

class AvailableBlock {
	int x, y;
	boolean isChecked;

	public AvailableBlock(int y, int x) {
		this.x = x;
		this.y = y;
		this.isChecked = false;
	}
}

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;
//
// public class Main {
// static int[][] map;
// static int size;
// static int blackMax = Integer.MIN_VALUE, whiteMax = Integer.MIN_VALUE;
// static boolean[] visitedBlack = new boolean[100];
// static boolean[] visitedWhite = new boolean[100];
//
// public static void main(String[] args) {
// Scanner scr = new Scanner(System.in);
// Element[] whiteBishop;
// Element[] blackBishop;
// List<Element> blackElements = new ArrayList<>();
// List<Element> whiteElements = new ArrayList<>();
//
// size = scr.nextInt();
// map = new int[size + 1][size + 1];
//
// for (int i = 1; i <= size; i++) {
// for (int j = 1; j <= size; j++) {
// map[i][j] = scr.nextInt();
// }
// }
//
// for (int i = 1; i <= size; i++) {
// for (int j = 1; j <= size; j++) {
// if (map[i][j] == 1) {
// if (i % 2 == 1) {
// if (j % 2 == 1) {
// whiteElements.add(new Element(i, j));
// }
//
// if (j % 2 == 0) {
// blackElements.add(new Element(i, j));
// }
// }
//
// if (i % 2 == 0) {
// if (j % 2 == 1) {
// blackElements.add(new Element(i, j));
// }
//
// if (j % 2 == 0) {
// whiteElements.add(new Element(i, j));
// }
// }
// }
// }
// }
//
// System.out.println("white: " + whiteElements.size());
// System.out.println("black: " + blackElements.size());
//
// for (int i = 0; i < blackElements.size()-1; i++) {
// visitedBlack[blackElements.get(i).absValue] = true;
// blackDFS(i, blackElements, 1);
// visitedBlack[blackElements.get(i).absValue] = false;
// }
//
// for (int i = 0; i < whiteElements.size()-1; i++) {
// visitedWhite[whiteElements.get(i).absValue] = true;
// whiteDFS(i,whiteElements,1);
// visitedWhite[whiteElements.get(i).absValue] = false;
// }
//
// System.out.println(blackMax);
// System.out.println(whiteMax);
//
// int result = whiteMax + blackMax;
//
// System.out.println(result);
// }
//
// public static void blackDFS(int index, List<Element> blackElements, int
// count) {
// if (index >= blackElements.size()-1) {
// if(blackMax < count) {
// blackMax = count;
// }
// } else {
// for(int i = index+1;i<=blackElements.size()-1;i++) {
// if(visitedBlack[blackElements.get(i).absValue] == false){
// visitedBlack[blackElements.get(i).absValue] = true;
// blackDFS(i,blackElements,count+1);
// visitedBlack[blackElements.get(i).absValue] = false;
// }
// }
// }
// }
//
// public static void whiteDFS(int index, List<Element> whiteElements, int
// count) {
// if (index >= whiteElements.size()-1) {
// if(whiteMax < count ) {
// whiteMax = count;
// }
// } else {
// for(int i = index+1;i<=whiteElements.size()-1;i++) {
// if(visitedWhite[whiteElements.get(i).absValue] == false){
// visitedWhite[whiteElements.get(i).absValue] = true;
// whiteDFS(i,whiteElements,count+1);
// visitedWhite[whiteElements.get(i).absValue] = false;
// }
// }
// }
// }
// }
//
// class Element {
// int y, x;
// int absValue = 0;
//
// public Element(int y, int x) {
// this.y = y;
// this.x = x;
// absValue = Math.abs(y - x);
// }
// }

// public class Main {
// static int[][] map;
// static boolean[] visited;
// static int n;
// static Scanner scr;
// static int max = Integer.MIN_VALUE;
// static List<Element> vector = new ArrayList<>();
//
// public static void main(String[] args ) {
// int count = 0;
// scr = new Scanner(System.in);
// n = scr.nextInt();
// Element element;
//
// map = new int[n+1][n+1];
//
// for(int i=1;i<=n;i++) {
// for(int j=1;j<=n;j++) {
// map[i][j] = scr.nextInt();
// }
// }
//
// for(int i=1;i<=n;i++) {
// for(int j=1;j<=n;j++) {
// if(map[i][j] == 1) {
// vector.add(new Element(j,i));
// }
// }
// }
//
// visited = new boolean[vector.size()];
//
// for(int i=0;i<vector.size();i++) {
// element = vector.get(i);
// visited[i] = true;
// dfs(element.x, element.y,i+1,1);
// visited[i] = false;
// }
//
// System.out.println(max);
//
//// for(int i=1;i<=n;i++) {
//// for(int j=1;j<=n;j++) {
//// count = 0;
//// }
//// }
// }
//
// public static void dfs(int x,int y,int index,int count) {
// if(index >= vector.size()) {
// if(max < count )
// max = count;
// return;
// }else {
// Element prevElement,curElement;
// curElement = vector.get(index);
// for(int i = 0;i<index;i++) {
// prevElement = vector.get(i);
// if(curElement.abs == prevElement.abs && !visited[i]) {
// visited[index] = true;
// dfs(curElement.x,curElement.y,index+1,count+1);
// visited[index] = false;
// }
// }
// }
// }
// }
//
// class Element {
// int x,y;
// int abs;
//
// public Element(int x, int y){
// this.x = x;
// this.y = y;
// this.abs = Math.abs(x-y);
// }
// }