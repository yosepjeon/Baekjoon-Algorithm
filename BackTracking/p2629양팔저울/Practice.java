package BackTracking.p2629양팔저울;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Practice {
	public static void main(String[] args ) {
		Scanner scr = new Scanner(System.in);
		
		
		TreeSet<TreeSet<Integer>> trees = new TreeSet<>(new Comparator<TreeSet<Integer>>() {

			@Override
			public int compare(TreeSet<Integer> o1, TreeSet<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.size() - o2.size();
			}
		});
		
		TreeSet<Integer> tree = new TreeSet<>();
		TreeSet<Integer> tree2 = new TreeSet<>();

		for(int i=0;i<3;i++) {
			tree.add(scr.nextInt());
		}
		trees.add(tree);
		
		for(int i=0;i<3;i++) {
			tree2.add(scr.nextInt());
		}
		
//		if(tree.equals(tree2)) {
//			System.out.println("@");
//		}
		
		for(TreeSet<Integer> t : trees) {
			if(t.equals(tree2)) {
				System.out.println("중복");
			}
		}
		
//		for(int i=0;i<2;i++) {
//			for(int j=0;j<3;j++) {
//				tree.add(scr.nextInt());
//			}
//			
//			if(trees.containsAll(tree)) {
//				System.out.println("이미 같은 값이 있음...");
//			}else {
//				trees.add(tree);
//				System.out.println("insert seccess");
//			}
//		}
	}
}
