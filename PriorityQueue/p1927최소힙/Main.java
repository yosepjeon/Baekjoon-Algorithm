package PriorityQueue.p1927최소힙;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)  {
		StringBuffer sb = new StringBuffer();
		Scanner scr = new Scanner(System.in);
		int x=0;
		int N=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1 > o2)
					return 1;
				else if(o1 < o2) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		N = scr.nextInt();
		
		for(int i=1;i<=N;i++) {
			x = scr.nextInt();
			
			if(x == 0) {
				if(pq.isEmpty())
					sb.append(0 + "\n");
				else
					sb.append(pq.poll() + "\n");
			}else {
				pq.add(x);
			}
		}
		
		System.out.print(sb.toString());
	}
}
