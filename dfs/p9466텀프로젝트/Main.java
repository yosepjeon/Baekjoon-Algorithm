package dfs.p9466텀프로젝트;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		int T;
		int n;
		Student[] students;
		StringBuffer sb = new StringBuffer();
		int count = 0;

		T = scr.nextInt();
		for (int i = 0; i < T; i++) {
			n = scr.nextInt();
			students = new Student[n + 1];
			count = 0;

			for (int j = 1; j <= n; j++) {
				int want = scr.nextInt();
				students[j] = new Student(j, want);
			}

			for (int j = 1; j <= n; j++) {
				if (!students[j].isVisited) {
					students[j].isVisited = true;
					if (dfs(j, j, students[j].want, students, n)) {
						students[j].result = 1;
					} else {
						students[j].result = -1;
					}
				}
			}

			for (int j = 1; j <= n; j++) {
//				System.out.print(students[j].result + " ");
				if (students[j].result == -1)
					count++;
			}
//			System.out.println();

			 sb.append(count + "\n");
		}

		 System.out.println(sb.toString());
	}

	public static boolean dfs(int root, int start, int end, Student[] students, int totalStudents) {
//		System.out.println("root: " + root + "start: " + start + " end: " + end);

		if (root == end) {
			return true;
		}

		if (students[end].isVisited) {
			return false;
		}

		if (start == end) {
			return false;
		}

		// for (int i = 1; i <= totalStudents; i++) {
		if (!students[end].isVisited) {
			students[end].isVisited = true;
			if (dfs(root, students[end].id, students[end].want, students, totalStudents)) {
				students[end].result = 1;
				return true;
			} else {
				students[end].result = -1;
				students[end].isVisited = false;
				return false;
			}
		}
		// }
		return false;
	}
}

class Student {
	int id;
	int want;
	int result;
	boolean isVisited;

	public Student(int id, int want) {
		this.id = id;
		this.want = want;
		this.result = 0;
		this.isVisited = false;
	}
}