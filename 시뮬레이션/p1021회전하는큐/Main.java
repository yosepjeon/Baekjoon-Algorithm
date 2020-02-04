package 시뮬레이션.p1021회전하는큐;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static int count = 0;

	public static void main(String[] args) {
		LinkedList<Integer> circularQueue = new LinkedList<>();

		Scanner scr = new Scanner(System.in);

		int N = scr.nextInt();
		int M = scr.nextInt();
		boolean[] values = new boolean[N + 1];

		for (int i = 0; i < N; i++) {
			circularQueue.add(i + 1);
		}

		for (int i = 1; i <= M; i++) {
			int checkValue = scr.nextInt();
			count += doIt(circularQueue, circularQueue.size(), checkValue);
		}

		System.out.println(count);
	}

	public static int doIt(LinkedList<Integer> circularQueue, int queueSize, int checkValue) {
		int leftValue = checkLeft(circularQueue, queueSize, checkValue);
		int rightValue = checkRight(circularQueue, queueSize, checkValue);

		boolean direction = leftValue < rightValue ? true : false;

		if (direction) {
			return rotateRight(circularQueue, leftValue);
		} else {
			return rotateLeft(circularQueue, rightValue);
		}
	}

	public static int checkLeft(LinkedList<Integer> circularQueue, int queueSize, int checkValue) {
		int count = 1;

		if (circularQueue.get(0) == checkValue)
			return 0;

		for (int i = queueSize - 1; i >= 0; i--) {
			if (circularQueue.get(i) == checkValue)
				return count;

			count++;
		}

		return -1;
	}

	public static int checkRight(LinkedList<Integer> circularQueue, int queueSize, int checkValue) {
		int count = 0;

		for (int i = 0; i < queueSize; i++) {
			if (circularQueue.get(i) == checkValue)
				return count;

			count++;
		}

		return -1;
	}

	public static int rotateLeft(LinkedList<Integer> circularQueue, int value) {
		for (int i = 0; i < value; i++) {
			int v = circularQueue.pollFirst();
			circularQueue.addLast(v);
		}
		
		circularQueue.poll();
		
		return value;
	}

	public static int rotateRight(LinkedList<Integer> circularQueue, int value) {
		for (int i = 0; i < value; i++) {
			int v = circularQueue.pollLast();
			circularQueue.addFirst(v);
		}
		
		circularQueue.poll();
		
		return value;
	}
}