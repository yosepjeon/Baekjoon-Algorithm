package 그래프이론.p6118숨바꼭질;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N,M;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		
		N = scr.nextInt();
		M = scr.nextInt();
		
		Barn[] barns = new Barn[N];
		
		for(int i=0;i<N;i++) {
			barns[i] = new Barn(i);
		}
		
		for(int i=0;i<M;i++) {
			int start = scr.nextInt();
			int end = scr.nextInt();
			
			barns[start-1].connectedBarns.add(end-1);
			barns[end-1].connectedBarns.add(start-1);
		}
		
		LinkedList<Barn> queue = new LinkedList<>();
		
		barns[0].isVisited = true;
		queue.add(barns[0]);
		
		while(!queue.isEmpty()) {
			Barn barn = queue.poll();
			if(max < barn.distance)
				max = barn.distance;
			
			barn.connectedBarns.forEach(b -> {
				if(!barns[b].isVisited) {
					barns[b].isVisited = true;
					barns[b].distance = barn.distance+1;
					queue.add(barns[b]);
				}
			});
		}
		
		List<Barn> filteredBarn = new ArrayList<>();
		
		for(Barn barn : barns) {
			if(barn.distance == max) 
				filteredBarn.add(barn);
		}
		
		filteredBarn.sort((b1,b2) -> b1.id - b2.id);
		
		System.out.println((filteredBarn.get(0).id + 1) + " " + max + " " + filteredBarn.size());
	}
}

class Barn {
	int id;
	int distance=0;
	boolean isVisited=false;
	List<Integer> connectedBarns = new ArrayList<>();
	
	public Barn(int id) {
		this.id = id;
	}
}
