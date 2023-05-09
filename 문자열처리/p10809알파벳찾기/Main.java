package 문자열처리.p10809알파벳찾기;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String S = scanner.nextLine();
		char[] carr = S.toCharArray();

		int[] alphabetCountArray = new int[26];
		Arrays.fill(alphabetCountArray, -1);

		int sLen = S.length();
		for (int idx=0;idx<sLen;idx++) {
			int alphabetNum = carr[idx] % 97;

			if(alphabetCountArray[alphabetNum] == -1) {
				alphabetCountArray[alphabetNum] = (char) idx;
			}
		}

		for(int result : alphabetCountArray) {
			System.out.print(result + " ");
		}
	}
}
