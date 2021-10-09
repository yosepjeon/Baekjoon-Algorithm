package 이분탐색.이분탐색구현연습;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch1 {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int N = scr.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scr.nextInt();
        }

        System.out.println("[이분탐색] 시작");
        System.out.print("찾을 값 검색: ");
        int target = scr.nextInt();

        int binarySearchResult = binarySearch(0, N - 1, arr, target);
        int lowerBoundBinarySearch = lowerBoundBinarySearch(0, N, arr, target);
        int uppderBoundBinarySearch = upperBoundBinarySearch(0, N, arr, target);

        System.out.println("binary search result= " + binarySearchResult);
        System.out.println("lower bound result= " + lowerBoundBinarySearch);
        System.out.println("upper bound result= " + uppderBoundBinarySearch);
    }

    public static int binarySearch(int left, int right, int[] arr, int target) {
        int mid = 0;
        Arrays.sort(arr);

        while (left <= right) {
            mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -(mid + 1);
    }

    public static int lowerBoundBinarySearch(int left, int right, int[] arr, int target) {
        int mid = 0;
        Arrays.sort(arr);

        while (left < right) {
            mid = (left + right) / 2;

            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static int upperBoundBinarySearch(int left, int right, int[] arr, int target) {
        int mid = 0;
        Arrays.sort(arr);

        while (left < right) {
            mid = (left + right) / 2;

            if(arr[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return right;
    }
}


//10
//-5 -3 -1 1 1 1 3 5 7 7