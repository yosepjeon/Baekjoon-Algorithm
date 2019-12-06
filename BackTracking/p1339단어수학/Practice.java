package BackTracking.p1339단어수학;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Practice {
	static Map<Character, Character> map = new HashMap<>();
	static List<Elem> elemList = new ArrayList<>();
	static List<String> resultElements = new ArrayList<>();
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	static int n;
	public static void main(String[] args) {
		char[] carr;
		
		String str;
		Scanner scr = new Scanner(System.in);

		n = scr.nextInt();

		for (int i = 0; i < n; i++) {
			str = scr.next();

			carr = str.toCharArray();
			resultElements.add(str);

			for (int j = 0; j < carr.length; j++) {
				if (map.getOrDefault(carr[j], null) == null) {
					map.put(carr[j], carr[j]);
					elemList.add(new Elem(map.get(carr[j]), -1));
				}
			}
		}

		Collections.sort(elemList,new Comparator<Elem>() {

			@Override
			public int compare(Elem o1, Elem o2) {
				// TODO Auto-generated method stub
				if(o1.alphabet > o2.alphabet) {
					return 1;
				}else if(o1.alphabet < o2.alphabet) {
					return -1;
				}else {
					return 0;
				}
			}
		});
		
		visited = new boolean[10];

//		for (int i = 9; i > 9 - elemList.size(); i--) {
//			visited[i] = true;
//			elemList.get(0).value = i;
//			dfs(0);
//			visited[i] = false;
//		}
		dfs(0);
		
		System.out.println(max);
	}

	public static void dfs(int start) {
		char[] carr;
		int result = 0;
		
		if (start >= elemList.size()) {
			for(int i=0;i<n;i++) {
				carr = resultElements.get(i).toCharArray();
				
				for(int j=0;j<carr.length;j++) {
					if(carr[j] == elemList.get(j).alphabet){
						carr[j] = Character.forDigit(elemList.get(j).value,10);
						System.out.print(carr[j]);
					}
				}
				System.out.println();
				String value = String.valueOf(carr);
				result += Integer.valueOf(value);
			}
			
			if(max < result)
				max = result;
		} else {
			for (int i = 9; i > 9 - elemList.size(); i--) {
				if (!visited[i]) {
					visited[i] = true;
					elemList.get(start).value = i;
					dfs(start + 1);
					visited[i] = false;
				}
			}
		}
	}
}

class Elem {
	char alphabet;
	int value;

	public Elem(char alphabet, int value) {
		this.alphabet = alphabet;
		this.value = value;
	}

}
