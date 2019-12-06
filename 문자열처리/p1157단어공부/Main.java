package 문자열처리.p1157단어공부;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String input = null;
		Scanner scr = new Scanner(System.in);
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Queue<Element> pq = new PriorityQueue<Element>(new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				if(o1.count < o2.count) {
					return 1;
				}else if(o1.count == o2.count) {
					return 0;
				}else {
					return -1;
				}
			}
		});
		
		input = scr.next();

		String topic = input.toUpperCase();
		char[] carr = topic.toCharArray();

		for (char c : carr) {
			if(map.getOrDefault(c, -1) == -1) {
				map.put(c, 1);
			}else {
				map.replace(c, map.get(c)+1);
			}
		}
		
		if(map.size() == 1) {
			System.out.println(carr[0]);
			return;
		}
		
		Iterator<Character> itr = map.keySet().iterator();
		
		while(itr.hasNext()) {
			char c = itr.next();
			pq.add(new Element(c,map.get(c)));
		}
		
		Element e1 = pq.poll();
		Element e2 = pq.poll();
		
		if(e1.count == e2.count) {
			System.out.println("?");
		}else {
			System.out.println(e1.alphabet);
		}
	}
}

class Element {
	char alphabet;
	int count;

	public Element(char alphabet, int count) {
		this.alphabet = alphabet;
		this.count = count;
	}
}