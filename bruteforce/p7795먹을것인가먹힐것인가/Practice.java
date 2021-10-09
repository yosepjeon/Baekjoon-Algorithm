package bruteforce.p7795먹을것인가먹힐것인가;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[] A = {1, 1, 3, 8};
        int[] B = {-2, 4, -99, -1, 98};

        Arrays.sort(A);
        Arrays.sort(B);

//        int idx = Arrays.binarySearch(B, 99);
        int idx = binarySearch(B, 99);

        System.out.println(idx);
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        boolean isExist = false;

        while (start <= end) {
            mid = (start + end) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else {
                if(target == arr[mid]) {
                    isExist = true;
                }
                end = mid - 1;
            }
        }

        return isExist? start : -(start + 1);
    }
}
