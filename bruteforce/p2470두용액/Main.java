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
        StringBuilder sb = new StringBuilder();

        N = input.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;

        // i<N이 아닌 i < N-1인 이유는 왼쪽을 뽑았을 때 오른쪽값은 왼쪽 + 1부터 시작함
        // 하지만 왼쪽값이 N-1일 때 binarysearch를 하면 그대로 N-1반환하므로
        // arr[N-1], arr[N-1]의 잘못된 값 반환
        for (int i = 0; i < N - 1; i++) {
            int idx = binarySearchLowerBound(i + 1, N - 1, arr, -arr[i]);

            int abs1 = Math.abs(arr[i] + arr[idx - 1]);
            int abs2 = Math.abs(arr[i] + arr[idx]);

            if (i < idx - 1 && abs1 < min) {
//                System.out.println("##### ABS1 #####");
                min = abs1;
                v1 = arr[i];
                v2 = arr[idx - 1];
//                System.out.println(v1 + ", " + v2);
            }

            if(idx < N && abs2 < min) {
//                System.out.println("##### ABS2 #####");
                min = abs2;
                v1 = arr[i];
                v2 = arr[idx];
//                System.out.println(v1 + ", " + v2);
            }

        }

        sb.append(v1).append(" ").append(v2);
        System.out.println(sb.toString());
    }

    public static int binarySearchLowerBound(int left, int right, int[] arr, int target) {
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

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
