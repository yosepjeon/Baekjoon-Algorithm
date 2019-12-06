package 문자열처리.p1475방번호;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Map<String, Integer> map = new HashMap<String, Integer>();
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		String n = scr.next();

		for (int i = 0; i < 10; i++) {
			map.put(String.valueOf(i), 0);
		}

		String[] sarr = n.split("");
		
		for (String element : sarr) {
			makeNumber(element);
		}
		
//		for (int i = 0; i < 10; i++) {
//			System.out.print(map.get(String.valueOf(i)) + " ");
//		}
//		System.out.println();

		System.out.println(count);
	}
	
	public static void makeNumber(String element) {
		if (map.get(element) == 0) {
			if (element.equals("9")) {
				if(map.get("6") != 0) {
					map.replace("6",map.get("6")-1);
					return;
				}
			}

			if (element.equals("6")) {
				if(map.get("9") != 0) {
					map.replace("9",map.get("9")-1);
					return;
				}
			}
			
			count++;

			plusNumberSet();
			map.replace(element, map.get(element) - 1);
		}else {
			map.replace(element, map.get(element)-1);
		}
	}

	public static void plusNumberSet() {
		for (int i = 0; i < 10; i++) {
			map.replace(String.valueOf(i), map.get(String.valueOf(i))+1);
		}
	}
}
