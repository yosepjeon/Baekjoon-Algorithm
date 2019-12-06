package Greedy.p4796캠핑;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Element> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int L=0,P=0,V=0;
		
		while(true) {
			L = scr.nextInt();
			P = scr.nextInt();
			V = scr.nextInt();
			
			if(L == 0 && P == 0 && V == 0)
				break;
			
			list.add(new Element(L,P,V));
		}
		
		for(int i=0;i<list.size();i++) {
			greedy(list.get(i),i+1);
		}
	}
	
	public static void greedy(Element element,int caseNum) {
		int n = element.V / element.P;
		int rest = element.V % element.P;
		
		System.out.println("Case " + caseNum + ": " + (element.L >=rest ? element.L*n+rest : element.L*n+element.L));
	}
}

class Element {
	int L,P,V;
	
	public Element(int L,int P, int V) {
		this.L = L;
		this.P = P;
		this.V = V;
	}
}
