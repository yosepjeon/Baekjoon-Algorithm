package bruteforce.p1182부분수열의합;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int count = 0;
    static int[] arr;

    public static void main(String[] args) {
        YoggaebReader scr = new YoggaebReader();

        N = scr.nextInt();
        S = scr.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scr.nextInt();
        }

        for (int i = 0; i < N; i++) {
            doAlgorithm(i, arr[i]);
        }

        System.out.print(count);
    }

    public static void doAlgorithm(int idx, int value) {
        if (idx == N) {
            return;
        }

        if (value == S) {
            count++;
        }

        for (int i = idx + 1; i < N; i++) {
                doAlgorithm(i, value + arr[i]);
        }

    }

    static class YoggaebReader {
        BufferedReader br;
        StringTokenizer st;

        public YoggaebReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public YoggaebReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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
