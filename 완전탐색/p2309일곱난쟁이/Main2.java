package 완전탐색.p2309일곱난쟁이;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		
		int[] dwarfs = new int[9];
		int total = 0;
		boolean flag = false;
		int num1=0,num2=0;
		
		for(int i=0;i<9;i++) {
			dwarfs[i] = scr.nextInt();
		}
		
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				num1 = i;
				num2 = j;
				for(int k=0;k<9;k++) {
					if(k == num1 || k == num2)
						continue;
					total += dwarfs[k];
				}
				if(total == 100){
					flag = true;
					break;
				}else {
					total = 0;
				}
			}
			if(flag)
				break;
		}
		
		for(int i=0;i<9;i++){
			if(i == num1 || i == num2)
				continue;
			list.add(dwarfs[i]);
		}
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
