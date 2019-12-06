package 문자열처리.p11656접미사배열;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args ) {
		String S;
		Scanner scr = new Scanner(System.in);
		List<String> strList = new ArrayList<String>();
		S = scr.next();
		
		for(int i=0;i<S.length();i++) {
			strList.add(S.substring(i,S.length()));
		}
		
		Collections.sort(strList,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
		
		for(String str : strList) {
			System.out.println(str);
		}
	}
}
