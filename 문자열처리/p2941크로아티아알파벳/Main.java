package 문자열처리.p2941크로아티아알파벳;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		int count =0;
		
		String input = scr.next();
		int len = input.length();
		char[] carr = input.toCharArray();
		boolean[] visited = new boolean[len];
		Map<String, String> map = new HashMap<String, String>();
		map.put("c=", "c=");
		map.put("c-", "c-");
		map.put("dz=", "dz=");
		map.put("d-", "d-");
		map.put("lj", "lj");
		map.put("nj", "nj");
		map.put("s=", "s=");
		map.put("z=", "z=");
		
		for(int i=0;i<len-2;i++) {
			if(visited[i] || visited[i+1] || visited[i+2])
				continue;
			
			if(map.getOrDefault(input.substring(i,i+3), "-1").equals("-1")) {
				continue;
			}else {
				visited[i] = true;
				visited[i+1] = true;
				visited[i+2] = true;
				count++;
				continue;
			}
		}
		
		for(int i=0;i<len-1;i++) {
			if(visited[i] || visited[i+1])
				continue;
			
			if(map.getOrDefault(input.substring(i,i+2), "-1").equals("-1")) {
				continue;
			}else {
				visited[i] = true;
				visited[i+1] = true;
				count++;
				continue;
			}
		}
		
		for(int i=0;i<len;i++) {
			if(visited[i])
				continue;
			
			visited[i] = true;
			count++;
		}
		
		System.out.println(count);
	}
}
