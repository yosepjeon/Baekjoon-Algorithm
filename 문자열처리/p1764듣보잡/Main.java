package 문자열처리.p1764듣보잡;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N,M;
	static List<String> result = new ArrayList<String>();
	
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		Map<String,String> noHear = new HashMap<>();
		Map<String,String> noSee = new HashMap<>();
		
		
		N = scr.nextInt();
		M = scr.nextInt();
		scr.nextLine();
		
		for(int i=0;i<N;i++) {
			String value = scr.next();
			
			noHear.put(value, value);
		}
		
		for(int i=0;i<M;i++) {
			String value = scr.next();
			noSee.put(value, value);
		}
		
		if(N>=M) {
			check(noHear,noSee);
		}else {
			check(noSee,noHear);
		}
		
		System.out.println(result.size());
		Collections.sort(result);
		for(String element : result) {
			System.out.println(element);
		}
	}
	
	public static void check(Map<String,String> greater, Map<String,String> smaller) {
		Queue<String> queue = new LinkedList<String>();
		Iterator<String> itr = smaller.keySet().iterator();
		
		while(itr.hasNext()) {
			String element = itr.next();
			queue.add(element);
		}
		
		while(queue.size() != 0) {
			String element = queue.poll();
			if(!greater.getOrDefault(element, "").equals("")) {
				greater.remove(element);
				result.add(element);
			}
		}
	}
}
