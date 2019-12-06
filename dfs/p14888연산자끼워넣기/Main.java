package dfs.p14888연산자끼워넣기;

import java.util.Scanner;

public class Main {
	static int N;
	static int[] operands;
	static int[] operators = new int[4];

	static boolean[] plusCheck;
	static boolean[] minusCheck;
	static boolean[] mulCheck;
	static boolean[] divCheck;

	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		N = scr.nextInt();
		operands = new int[N];
		int total = 0;

		plusCheck = new boolean[N - 1];
		minusCheck = new boolean[N - 1];
		mulCheck = new boolean[N - 1];
		divCheck = new boolean[N - 1];

		for (int i = 0; i < N; i++) {
			operands[i] = scr.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			operators[i] = scr.nextInt();
		}

		if (N == 2) {
			for (int i = 0; i < 4; i++) {
				if (operators[i] != 0) {
					switch (i) {
					case 0:
						total = operands[0] + operands[1];
						min = total;
						max = total;
						break;
					case 1:
						total = operands[0] - operands[1];
						min = total;
						max = total;
						break;
					case 2:
						total = operands[0] * operands[1];
						min = total;
						max = total;
						break;
					case 3:
						if(total < 0) {
						total = -(Math.abs(operands[0]) / operands[1]);
						}else {
							total = operands[0] / operands[1];
						}
						min = total;
						max = total;
						break;
					}
				}
			}
		} else {

			for (int i = 0; i < 4; i++) {
				if (operators[i] > 0) {
					// operators[i]--;
					calculateDFS(operands[0], 0, i, "");
					// operators[i]++;

				} else {
					continue;
				}
			}
		}

		System.out.println(max);
		System.out.println(min);
	}

	public static void calculateDFS(int total, int count, int operatorIndex, String str) {
		// System.out.println("call");
		// System.out.println(count);
		// System.out.println(oper);
		// System.out.println(total);
		// System.out.println(operators[0] +" " + operators[1]+" " +
		// operators[2]+" " + operators[3] );

		// if (count == N - 1) {
		// System.out.println("call");
		if (operators[0] == 0 && operators[1] == 0 && operators[2] == 0 && operators[3] == 0) {
			// System.out.println("call");
			// operators[3] == 0){
			if (total < min) {
				min = total;
				// System.out.println("min: "+ str);
				// System.out.println(operators[0] + " " + operators[1] + " " +
				// operators[2] + " " + operators[3]);

			}

			if (total > max) {
				max = total;

				// System.out.println("max: " + str);
				// System.out.println(operators[0] + " " + operators[1] + " " +
				// operators[2] + " " + operators[3]);

			}
			return;
		} else {
			// System.out.println("call");
			switch (operatorIndex) {
			case 0:
				plusCheck[count] = true;
				operators[0] -= 1;
				total = (total + operands[count + 1]);

				if (operators[0] == 0 && operators[1] == 0 && operators[2] == 0 && operators[3] == 0) {
					calculateDFS(total, count + 1, -1, str + "+");
					operators[0] += 1;
					return;
				}

				for (int i = 0; i < 4; i++) {
					if (operators[i] > 0) {
						// operators[i]--;
						calculateDFS(total, count + 1, i, str + "+");
						// operators[i]++;
					}
				}
				operators[0]++;
				break;
			case 1:
				minusCheck[count] = true;
				operators[1] -= 1;
				total = (total - operands[count + 1]);

				if (operators[0] == 0 && operators[1] == 0 && operators[2] == 0 && operators[3] == 0) {
					calculateDFS(total, count + 1, -1, str + "-");
					operators[1] += 1;
					return;
				}

				for (int i = 0; i < 4; i++) {
					if (operators[i] > 0) {
						// operators[i]--;
						calculateDFS(total, count + 1, i, str + "-");
						// operators[i]++;
					}
				}
				operators[1]++;
				break;
			case 2:
				mulCheck[count] = true;
				operators[2] -= 1;
				total = (total * operands[count + 1]);

				if (operators[0] == 0 && operators[1] == 0 && operators[2] == 0 && operators[3] == 0) {
					calculateDFS(total, count + 1, -1, str + "*");
					operators[2] += 1;
					return;
				}

				for (int i = 0; i < 4; i++) {
					if (operators[i] > 0) {
						// operators[i]--;
						calculateDFS(total, count + 1, i, str + "*");
						// operators[i]++;
					}
				}
				operators[2]++;
				break;
			case 3:
				divCheck[count] = true;
				operators[3] -= 1;
				if (total < 0) {
					total = -(Math.abs(total) / operands[count + 1]);
				} else {
					total = total / operands[count + 1];
				}
				if (operators[0] == 0 && operators[1] == 0 && operators[2] == 0 && operators[3] == 0) {
					calculateDFS(total, count + 1, -1, str + "/");
					operators[3] += 1;
					return;
				}

				for (int i = 0; i < 4; i++) {
					if (operators[i] > 0) {
						// operators[i]--;
						calculateDFS(total, count + 1, i, str + "/");
						// operators[i]++;
					}
				}
				operators[3]++;
				break;
			default:
				break;
			}
		}
	}
}
