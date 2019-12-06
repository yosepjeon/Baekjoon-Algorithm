package PriorityQueue.p1715카드정렬;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int N;
		int result = 0;
		Scanner scr = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1 > o2) {
					return 1;
				} else if (o1 < o2) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		N = scr.nextInt();

		for (int i = 1; i <= N; i++) {
			int card = scr.nextInt();
			pq.add(card);
		}

		if (pq.size() == 1) {
			result = 0;
		} else {

			while (pq.size() >= 2) {
				int card1 = pq.poll();
				int card2 = pq.poll();
				int combinedCard = card1 + card2;
				
				result += combinedCard;

				pq.add(combinedCard);
			}

			pq.poll();
		}

		System.out.println(result);
	}
}
