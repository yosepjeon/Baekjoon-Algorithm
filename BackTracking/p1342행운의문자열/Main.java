package BackTracking.p1342행운의문자열;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Map<Character, Character>[] memoizations;
	static int strLen;
	static char[] carr;
	static int[] countAlphabet;
	static int result = 0;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		String str = scr.next();
		carr = str.toCharArray();
		countAlphabet = new int[26];
		strLen = str.length();
		for(int i=0;i<26;i++) {
			countAlphabet[i] = 0;
		}
		
		for(int i=0;i<strLen;i++) {
			countAlphabet[carr[i]-97]++;
		}
		
//		for(int i=0;i<26;i++) {
//			System.out.print(countAlphabet[i] + " ");
//		}
//		System.out.println();
//		System.out.println("#########################");
	
		memoizations = new HashMap[strLen];

		memoizations[0] = new HashMap<>();
		for (int i = 0; i < strLen; i++) {
			if (memoizations[0].getOrDefault(carr[i], null) == null) {
				memoizations[0].put(carr[i], carr[i]);
				dfs(0, "" + carr[i],i);
			}
		}
		System.out.println(result);
	}

	public static void dfs(int index, String string,int choiceIndex) {
		if (string.length() >= strLen) {
			if (checkIsLuckyString(string) && checkIsLuckyStringAboutCount(string)) {
				result++;
			}
			return;
		}

		if (index > 0 && string.charAt(index) == string.charAt(index - 1)) {
			return;
		} else {
			
			memoizations[index + 1] = new HashMap<>();
			for (int i = 0; i < strLen; i++) {
				if (memoizations[index + 1].getOrDefault(carr[i], null) == null) {
					memoizations[index + 1].put(carr[i], carr[i]);
					dfs(index + 1, string + carr[i],choiceIndex);
				}
			}
		}
	}

	public static boolean checkIsLuckyString(String string) {
		char[] checkCarr = string.toCharArray();

		for (int i = 0; i < strLen - 1; i++) {
			if (checkCarr[i] == checkCarr[i + 1]) {
				return false;
			}
		}

		return true;
	}
	
	public static boolean checkIsLuckyStringAboutCount(String string) {
		char[] checkCarr = string.toCharArray();
		int[] countCheckCarrAlphabet = new int[26];
		for (int i = 0; i < 26; i++) {
			countCheckCarrAlphabet[i]=0;
		}

		for (int i = 0; i < strLen; i++) {
			countCheckCarrAlphabet[checkCarr[i]-97]++;
		}
		
		for(int i=0;i<26;i++) {
			if(countAlphabet[i] != countCheckCarrAlphabet[i]) {
				return false;
			}
		}
		
//		for(int i=0;i<26;i++) {
//			System.out.print(countCheckCarrAlphabet[i] + " ");
//		}
//		System.out.println();

		return true;
	}
}