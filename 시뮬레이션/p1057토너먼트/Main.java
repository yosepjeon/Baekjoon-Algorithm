package 시뮬레이션.p1057토너먼트;

import java.util.Scanner;

public class Main {
	static int N;
	static Person[] person;
	static Person[] temp;
	static int round = 1;
	static int kim, lim;
	static int curKim, curLim;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		kim = scr.nextInt();
		lim = scr.nextInt();
		person = new Person[N + 1];

		for (int i = 1; i <= N; i++) {
			person[i] = new Person(i);
		}

		if (N == 1) {
			System.out.println(0);
			return;
		}

		if (Math.ceil((double) kim / 2) == Math.ceil((double) lim / 2)) {
			System.out.println(1);
			return;
		}

		int index = 1;

		if (N % 2 != 0) {
			temp = new Person[N / 2 + 2];
			for (int i = 1; i < N; i += 2) {
				if (person[i].originNum == kim) {
					temp[index] = new Person(person[i].originNum, index);
					curKim = index++;
					continue;
				} else if (person[i + 1].originNum == kim) {
					temp[index] = new Person(person[i + 1].originNum, index);
					curKim = index++;
					continue;
				} else if ((person[i].originNum == lim)) {
					temp[index] = new Person(person[i].originNum, index);
					curLim = index++;
					continue;
				} else if ((person[i + 1].originNum == lim)) {
					temp[index] = new Person(person[i + 1].originNum, index);
					curLim = index++;
					continue;
				} else {
					temp[index] = new Person(person[i].originNum, index++);
				}
			}

			if (person[N].originNum == kim) {
				// System.out.println("kim");
				temp[N / 2 + 1] = new Person(person[N].originNum, index++);
				curKim = N / 2 + 1;
			} else if (person[N].originNum == lim) {
				// System.out.println("lim");
				temp[N / 2 + 1] = new Person(person[N].originNum, index++);
				curLim = N / 2 + 1;
			} else {
				// System.out.println("other");
				temp[N / 2 + 1] = new Person(person[N].originNum, index++);
			}

			person = new Person[N / 2 + 2];

			for (int i = 1; i <= (N / 2 + 1); i++) {
				// System.out.println("temp-len: "+temp.length);
				// System.out.println("i: " +i);
				// System.out.println("N/2+1: " + (N/2+1));
				// System.out.println("temp[" + i+"]"+": " + temp[i].originNum);
				person[i] = new Person(temp[i].originNum, temp[i].currentNum);
			}

			run(N / 2 + 1);

		} else {
			temp = new Person[N / 2 + 1];

			for (int i = 1; i < N; i += 2) {
				if (person[i].originNum == kim) {
					temp[index] = new Person(person[i].originNum, index);
					curKim = index++;
					continue;
				} else if (person[i + 1].originNum == kim) {
					temp[index] = new Person(person[i + 1].originNum, index);
					curKim = index++;
					continue;
				} else if ((person[i].originNum == lim)) {
					temp[index] = new Person(person[i].originNum, index);
					curLim = index++;
					continue;
				} else if ((person[i + 1].originNum == lim)) {
					temp[index] = new Person(person[i + 1].originNum, index);
					curLim = index++;
					continue;
				} else {
					temp[index] = new Person(person[i].originNum, index++);
				}
			}

			person = new Person[N / 2 + 1];

			for (int i = 1; i <= N / 2; i++) {
				person[i] = new Person(temp[i].originNum, temp[i].currentNum);
			}

			run(N / 2);
		}

		System.out.println(round);
	}

	public static void run(int N) {
		round++;

//		System.out.println(curKim + " : " + curLim);
//		System.out.println(person.length);
//		System.out.println(Math.ceil((double) curKim / 2) + " : " + Math.ceil((double) curLim / 2));

		if (Math.ceil((double) curKim / 2) == Math.ceil((double) curLim / 2)) {

			return;
		}

		int index = 1;

		if (N % 2 != 0) {
			temp = new Person[N / 2 + 2];
//			System.out.println(temp.length);
			for (int i = 1; i < N; i += 2) {
				if (person[i].originNum == kim) {
					temp[index] = new Person(person[i].originNum, index);
					curKim = index++;
					continue;
				} else if (person[i + 1].originNum == kim) {
					temp[index] = new Person(person[i + 1].originNum, index);
					curKim = index++;
					continue;
				} else if ((person[i].originNum == lim)) {
					temp[index] = new Person(person[i].originNum, index);
					curLim = index++;
					continue;
				} else if ((person[i + 1].originNum == lim)) {
					temp[index] = new Person(person[i + 1].originNum, index);
					curLim = index++;
					continue;
				} else {
					temp[index] = new Person(person[i].originNum, index++);
				}
			}

			if (person[N].originNum == kim) {
				// System.out.println("kim");
				temp[N / 2 + 1] = new Person(person[N].originNum, N);
				curKim = N / 2 + 1;
			} else if (person[N].originNum == lim) {
				// System.out.println("lim");
				temp[N / 2 + 1] = new Person(person[N].originNum, N);
				curLim = N / 2 + 1;
			} else {
				temp[N / 2 + 1] = new Person(person[N].originNum, N);
			}

			person = new Person[N / 2 + 2];

			// System.out.println("N : " + N);

			for (int i = 1; i <= (N / 2 + 1); i++) {
				// System.out.println(temp[i].currentNum);
				person[i] = new Person(temp[i].originNum, temp[i].currentNum);
			}

			run(N / 2 + 1);

		} else {
			// System.out.println("호출");
			temp = new Person[N / 2 + 1];

			for (int i = 1; i < N; i += 2) {
				if (person[i].originNum == kim) {
					temp[index] = new Person(person[i].originNum, index);
					curKim = index++;
					continue;
				} else if (person[i + 1].originNum == kim) {
					temp[index] = new Person(person[i + 1].originNum, index);
					curKim = index++;
					continue;
				} else if ((person[i].originNum == lim)) {
					temp[index] = new Person(person[i].originNum, index);
					curLim = index++;
					continue;
				} else if ((person[i + 1].originNum == lim)) {
					temp[index] = new Person(person[i + 1].originNum, index);
					curLim = index++;
					continue;
				} else {
					temp[index] = new Person(person[i].originNum, index++);
				}
			}

			person = new Person[N / 2 + 1];

			for (int i = 1; i <= N / 2; i++) {
				person[i] = new Person(temp[i].originNum, temp[i].currentNum);
			}

			run(N / 2);
		}

	}

}

class Person {
	int originNum;
	int currentNum;

	public Person(int originNum) {
		this.originNum = originNum;
		this.currentNum = originNum;
	}

	public Person(int originNum, int currentNum) {
		this.originNum = originNum;
		this.currentNum = currentNum;
	}
}
