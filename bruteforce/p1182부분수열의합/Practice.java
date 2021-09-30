package bruteforce.p1182부분수열의합;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Practice {
    public static void main(String[] args) {
//        Scanner scr = new Scanner(System.in);
        YoggaebReader scr = new YoggaebReader();

        int n = scr.nextInt();
        String str = scr.nextLine();

        System.out.println("n= " + n);
        System.out.println("str= " + str);
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
