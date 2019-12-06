package BackTracking.p1339단어수학;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int N;
	static List<String> list = new ArrayList<>();
	static List<Element> elementsList = new ArrayList<>();
	static Map<Character, Integer> map = new HashMap<>();
	static String str;
	static char[] carr;
	static int result = 0;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();

		for (int i = 0; i < N; i++) {
			str = scr.next();
			list.add(str);
			carr = str.toCharArray();

			for (int j = 0; j < carr.length; j++) {
				if (map.getOrDefault(carr[j], 0) == 0) {
					map.put(carr[j], (int) Math.pow(10, carr.length-j));
				} else {
					int num = map.get(carr[j]);
					num += (int) Math.pow(10, carr.length-j);
					map.replace(carr[j], num);
				}
			}
		}

		Iterator<Character> itr = map.keySet().iterator();
		while (itr.hasNext()) {
			char key = itr.next();

			elementsList.add(new Element(key, map.get(key)));
		}

		Collections.sort(elementsList, new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				// TODO Auto-generated method stub
				if (o1.value < o2.value) {
					return 1;
				} else if (o1.value > o2.value) {
					return -1;
				} else {
					return 0;
				}
			}

		});
		
		for(int i=0;i<elementsList.size();i++) {
			elementsList.get(i).priority = 9-i;
			Element element = elementsList.get(i);
			map.replace(element.alphabet, element.priority);
//			System.out.println("alphabet: " + elementsList.get(i).alphabet +" value: " + elementsList.get(i).value +" priority: " + elementsList.get(i).priority);
		}
		
		int[] iarr;
		String toString;
		
		for(int i=0;i<list.size();i++) {
			toString = "";
			
			carr = list.get(i).toCharArray();
			iarr = new int[carr.length];
			
			for(int j=0;j<carr.length;j++) {
				iarr[j] = map.get(carr[j]);
				toString += iarr[j];
//				System.out.print(iarr[j]);
			}
//			System.out.println();
//			System.out.println(toString);
//			System.out.println(Integer.valueOf(toString));
			result += Integer.parseInt(toString);
		}
		
		System.out.println(result);
	}
}

class Element {
	char alphabet;
	int value;
	int priority;

	public Element(char alphabet, int value) {
		this.alphabet = alphabet;
		this.value = value;
	}
}