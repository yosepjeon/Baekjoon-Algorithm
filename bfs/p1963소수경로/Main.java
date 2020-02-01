package bfs.p1963소수경로;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
		Map<String, PrimeNumber> primeMap = new HashMap<String, PrimeNumber>();
		
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
				String prime = String.valueOf(i);
				list.add(new PrimeNumber(String.valueOf(i)));
				primeMap.put(prime, new PrimeNumber(prime));
//				System.out.println(i);
			}
		}

		int T = scr.nextInt();
		scr.nextLine();

		for (int i = 0; i < T; i++) {
			String prime1 = scr.next();
			String prime2 = scr.next();
			result = Integer.MAX_VALUE;
			
			PrimeNumber pn = primeMap.get(prime1);
			bfs(prime1, prime2, pn,list);
			
//			for(PrimeNumber pn : list) {
//				if(pn.value.equals(prime1)) {
//					pn.isVisited = true;
//					bfs(pn.value, prime2, pn);
//					pn.isVisited = false;
//					break;
//				}
//			}
			
			if(result == Integer.MAX_VALUE) 
				sb.append("Impossible\n");
			else
				sb.append(result + "\n");
			
			initPrimeList(list);
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(String prime1, String prime2,PrimeNumber primeNumber,List<PrimeNumber> pnList) {
		Queue<PrimeNumber> queue = new LinkedList<>();
		primeNumber.isVisited = true;
		queue.add(primeNumber);
		
		while(!queue.isEmpty()) {
			PrimeNumber element = queue.poll();
//			System.out.println("prime{value: " + element.value + " count: " + element.count);
			if(element.value.equals(prime2)) {
//				result = pn.
				result = element.count;
				return;
			}
			
			for(PrimeNumber pn : pnList) {
				if(pn.isVisited)
					continue;
				int count = element.matchingOtherPrimeNumber(pn.value);
				
				if(count < 3) {
					continue;
				}else {
					pn.isVisited = true;
					pn.count = element.count + 1;
					queue.add(pn);
				}
			}
		}
	}
	
	public static void initPrimeList(List<PrimeNumber> list) {
		for(PrimeNumber element : list) {
			element.isVisited = false;
		}
	}
}

class PrimeNumber {
	String value;
	boolean isVisited;
	int count;

	public PrimeNumber(String value) {
		this.value = value;
		this.isVisited = false;
		this.count = 0;
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
