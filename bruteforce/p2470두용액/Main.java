package bruteforce.p2470두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) {
        YoggaebReader input = new YoggaebReader();

        N = input.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 0; i < N; i++) {
            int idx = binarySearch(arr, i + 1, N - 1, -arr[i]);

            int abs = Math.abs(0 - Math.abs(arr[i] + arr[idx]));

            if (min > abs) {
                min = abs;
                result = new int[2];
                result[0] = arr[i] > arr[idx] ? arr[idx] : arr[i];
                result[1] = arr[i] < arr[idx] ? arr[idx] : arr[i];
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        int mid;

        int result = end + 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] >= target) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;

    }
//5
//-5 -4 -3 -2 -1

//    5
//    -1 0 1 2 3

    static class YoggaebReader {
        BufferedReader br;
        StringTokenizer st;

        public YoggaebReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
