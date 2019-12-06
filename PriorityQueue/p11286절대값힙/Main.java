package PriorityQueue.p11286절대값힙;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner scr= new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				if(o1.absNum > o2.absNum) {
					return 1;
				}else if(o1.absNum < o2.absNum) {
					return -1;
				}else {
					if(o1.num > o2.num){
						return 1;
					}else if(o1.num < o2.num) {
						return -1;
					}else {
						return 0;
					}
				}
			}

			
		});
		
		int N,x;
		
		N = scr.nextInt();
		
		for(int i=1;i<=N;i++) {
			x = scr.nextInt();
			
			
			if(x == 0) {
				if(pq.isEmpty()){
					sb.append(0 + "\n");
				}else{
				Element element = pq.poll();
				sb.append(element.num + "\n");
				}
			}else {
				int absNum =  Math.abs(x);
				pq.add(new Element(x,absNum));
			}
		}
		
		System.out.print(sb.toString());
	}
}

class Element {
	int num;
	int absNum;
	
	public Element(int num,int absNum) {
		this.num = num;
		this.absNum = absNum;
	}
}