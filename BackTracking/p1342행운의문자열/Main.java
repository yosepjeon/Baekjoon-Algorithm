package BackTracking.p1342행운의문자열;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static boolean[] visited;
	static String str;
	static int strLen;
	static int result = 0;
	static Set<String> resultSet = new HashSet<String>();
	static char[] carr;
	static Map<Character,Integer> map =new HashMap<>();

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		str = scr.next();
		carr = str.toCharArray();
		strLen = str.length();
		visited = new boolean[strLen];
		
		for(int i=0;i<strLen;i++) {
			if(map.getOrDefault(carr[i], null) == null) {
				map.put(carr[i], 1);
			}else {
				int getValue = map.get(carr[i]);
				map.replace(carr[i], getValue+1);
			}
		}

		for (int i = 0; i < strLen; i++) {
			visited[i] = true;
			findLuckyString("" + carr[i]);
			visited[i] = false;
		}
		
		Iterator<Character> itr = map.keySet().iterator();
		while(itr.hasNext()) {
			char value = itr.next();
			int v = map.get(value);
			int factorial = 1;
			for(int i=1;i<=v;i++) {
				factorial *= i;
			}
			
			result /= factorial;
		}
		
		System.out.println(result);
	}
	
	public static void findLuckyString(String s) {
		if(s.length() == strLen) {
			result++;
		}
		
		for(int i=0;i<strLen;i++) {
			if(visited[i])
				continue;
			if(s.charAt(s.length()-1) == carr[i]) {
				continue;
			}
			visited[i] = true;
			findLuckyString(s + carr[i]);
			visited[i] = false;
		}
	}
}