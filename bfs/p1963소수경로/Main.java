package bfs.p1963소수경로;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static StringBuffer sb = new StringBuffer();
	public static int result = Integer.MAX_VALUE;
	public static boolean[] fix = new boolean[10000];
	public static boolean flag;
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		boolean[] notPrimeList = new boolean[10000];
		
		notPrimeList[1] = true;

		for (int i = 2; i <= 9999; i++) {
			if (notPrimeList[i])
				continue;

			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0)
					notPrimeList[i] = true;
			}

			for (int j = 2; j <= 9999; j++) {
				if (i * j >= 10000)
					break;
				notPrimeList[i * j] = true;
			}
		}

		List<PrimeNumber> list = new ArrayList<PrimeNumber>();

		for (int i = 1000; i < 10000; i++) {
			if (!notPrimeList[i]) {
				list.add(new PrimeNumber(String.valueOf(i)));
//				System.out.println(i);
			}
		}

		int T = scr.nextInt();
		scr.nextLine();

		for (int i = 0; i < T; i++) {
			String prime1 = scr.next();
			String prime2 = scr.next();
			result = Integer.MAX_VALUE;

//			for(PrimeNumber pn : list) {
//				if(pn.value.equals(prime1)) {
//					pn.isVisited = true;
//					dfs(pn.value, prime2, list, 0);
//					pn.isVisited = false;
//					break;
//				}
//			}
			
			for(PrimeNumber pn : list) {
				if(pn.value.equals(prime1)) {
					pn.isVisited = true;
					bfs(pn.value, prime2, pn);
					pn.isVisited = false;
					break;
				}
			}
			
			if(result == Integer.MAX_VALUE) 
				sb.append("Impossible");
			else
				sb.append(result);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(String prime1, String prime2,PrimeNumber primeNumber) {
		Queue<PrimeNumber> queue = new LinkedList<>();
		
		queue.add(primeNumber);
		
		while(!queue.isEmpty()) {
			PrimeNumber pn = queue.poll();
			
			
		}
	}

	public static void dfs(String prime1, String prime2, List<PrimeNumber> list, int count) {
		if(result <= count)
			return;
		
		if (prime1.equals(prime2)) {
			System.out.println(count);
			if(result > count)
				result = count;
			flag = true;
			return;
		}
		
		for(PrimeNumber pn : list) {
			if(!pn.isVisited && pn.matchingOtherPrimeNumber(prime1) >= 3) {
				pn.isVisited = true;
				dfs(pn.value,prime2,list,count+1);
				pn.isVisited = false;
			}
		}
	}
}

class PrimeNumber {
	String value;
	boolean isVisited;

	public PrimeNumber(String value) {
		this.value = value;
		this.isVisited = false;
	}

	public int matchingOtherPrimeNumber(String primeNumber) {
//		System.out.println("p1: " +this.value);
//		System.out.println("p2: " + primeNumber);
//		char[] pn1 = this.value.toCharArray();
//		char[] pn2 = primeNumber.toCharArray();
		int count = 0;
		for(int i=0;i<4;i++) {
			if(this.value.charAt(i) == primeNumber.charAt(i)) 
				count++;
		}
		
		return count;
	}
}
