package BackTracking.p10597순열장난.legacy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static String permutation;
	static int[] elements;
	static Map<String, Integer> map = new HashMap<>();
	static StringBuffer sb = new StringBuffer();

	static boolean zeroFlag = false;

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);

		permutation = scr.nextLine();
		elements = new int[permutation.length()];

		for (int i = 0; i < permutation.length(); i++) {
			elements[i] = Integer.parseInt(permutation.substring(i, i + 1));
		}

		dfs(0, String.valueOf(elements[0]), "", "");

		System.out.println(sb.toString());

	}

	public static void dfs(int index, String mapElement, String prevElement, String result) {
		if (mapElement.equals("0")) {
			zeroFlag = true;
			map.remove(prevElement);
			return;
		}

		if (map.getOrDefault(mapElement, -1) == -1) {
			if (!zeroFlag) {

				map.put(mapElement, elements[index]);
				result += mapElement + " ";

				if (index == elements.length - 1) {
					sb.append(result);
					return;
				}

				dfs(index + 1, String.valueOf(elements[index + 1]), mapElement, result);
			}
			
			if(zeroFlag) {
				if(index == elements.length -2) {
					zeroFlag = false;
					dfs(index + 2, mapElement + String.valueOf(elements[index + 1]) + String.valueOf(elements[index + 2]), prevElement, result);
				}else {
					map.remove(prevElement);
					return;
				}
			}
			// dfs(index+1, elements[index+1]);
		} else {
			dfs(index + 1, mapElement + String.valueOf(elements[index + 1]), prevElement, result);
		}

	}
}

// public class Main {
// static String permutation;
// static int[] elements;
// static Map<String, Integer> map = new HashMap<>();
// static StringBuffer sb = new StringBuffer();
//
// static boolean zeroFlag = false;
//
// public static void main(String[] args) {
// Scanner scr = new Scanner(System.in);
//
// permutation = scr.nextLine();
// elements = new int[permutation.length()];
//
// for (int i = 0; i < permutation.length(); i++) {
// elements[i] = Integer.parseInt(permutation.substring(i, i + 1));
// }
//
// dfs(0, String.valueOf(elements[0]), "");
//
// System.out.println(sb.toString());
//
// }
//
// public static void dfs(int index, String mapElement, String result) {
// if (mapElement.equals("0"))
// return;
//
// if (map.getOrDefault(mapElement, -1) == -1) {
//
// map.put(mapElement, elements[index]);
// result += mapElement + " ";
//
// if (index == elements.length - 1) {
// sb.append(result);
// return;
// }
//
// dfs(index + 1, String.valueOf(elements[index + 1]), result);
// // dfs(index+1, elements[index+1]);
// } else {
// dfs(index + 1, mapElement + String.valueOf(elements[index + 1]), result);
// }
//
// }
// }
