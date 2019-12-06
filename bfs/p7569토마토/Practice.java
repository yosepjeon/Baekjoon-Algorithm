package bfs.p7569토마토;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice {
	static Map<String, ArrayList<Elem>> map = new HashMap<>();
	static String input;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		ArrayList<Elem> arr;
		while(true) {
			input = scr.next();
			
			if(input.equals("*"))
				break;
			
			if(map.getOrDefault(input, null) == null) {
				arr = new ArrayList<>();
				arr.add(new Elem(input,0));
				map.put(input, arr);
			}else {
				arr = map.get(input);
//				arr.add(new Elem)
			}
		}
	}
}

class Elem {
	String str;
	int place;
	
	public Elem(String str, int place) {
		this.str = str;
		this.place = place;
	}
}
