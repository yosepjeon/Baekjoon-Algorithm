package bruteforce.p7795먹을것인가먹힐것인가;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int[] A;
    static int[] B;

    public static void main(String[] args) {
        YoggaebReader input = new YoggaebReader();

        T = input.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int t=0;t<T;t++) {
//            System.out.println("test case " + t);
            int aLen = input.nextInt();
            int bLen = input.nextInt();

            A = new int[aLen];
            B = new int[bLen];

            for (int i = 0; i < aLen; i++) {
                A[i] = input.nextInt();
            }

            for (int i = 0; i < bLen; i++) {
                B[i] = input.nextInt();
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int count = 0;
            for(int i=0;i<aLen;i++) {
                int findIdx = binarySearch(B,A[i]);
                if(findIdx >= 0)
                    count += (findIdx);
                else {
                    count += (findIdx+1) * -1;
                }
            }

            sb.append(count + "\n");
        }

        System.out.print(sb.toString());
    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    static class YoggaebReader {
        private BufferedReader br;
        private StringTokenizer st;

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
