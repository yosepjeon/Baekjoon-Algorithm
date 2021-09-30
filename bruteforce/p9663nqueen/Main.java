package bruteforce.p9663nqueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int result = 0;
    static List<Tile> queenTiles = new ArrayList<>();

    public static void main(String[] args) {
        YoggaebReader input = new YoggaebReader();

        N = input.nextInt();

        doAlgorithm(0, 0);

        System.out.println(result);
    }

    public static void doAlgorithm(int queenCount, int row) {
        if(queenTiles.size() == N) {
            result++;
            return;
        }

        if (row == 0) {
            for (int i = 0; i < N; i++) {
                Tile tile = new Tile(row, i);
                queenTiles.add(tile);
                doAlgorithm(queenCount + 1, row + 1);
                queenTiles.remove(queenCount);
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (isAttackable(row, i)) {
                    continue;
                } else {
                    Tile tile = new Tile(row, i);
                    queenTiles.add(tile);
                    doAlgorithm(queenCount + 1, row + 1);
                    queenTiles.remove(queenCount);
                }
            }
        }
    }

    // 1 1 1
    // 1 1 1
    // 1 1 1
    public static boolean isAttackable(int row, int col) {
        for (Tile t : queenTiles) {
            if(t.row == row || t.col == col) return true;
            if (t.row - t.col == row - col) return true; // 대각선
            if ((t.row + t.col) == (row + col)) return true; // 역대각선
        }

        return false;
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

class Tile {
    int row, col;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
//public class Main {
//    static int N;
//    static int result = 0;
//    static int[] queenTile;
//
//    public static void main(String[] args) {
//        YoggaebReader input = new YoggaebReader();
//
//        N = input.nextInt();
//        queenTile = new int[N];
//        for(int i=0;i<N;i++) {
//            queenTile[i] = -1;
//        }
//
//        doAlgorithm(0, 0);
//
//        System.out.println(result);
//    }
//
//    public static void doAlgorithm(int queenCount, int row) {
//        if(queenCount == N) {
//            result++;
//            return;
//        }
//
//        if (row == 0) {
//            for (int i = 0; i < N; i++) {
//                queenTile[row] = i;
//                doAlgorithm(queenCount + 1, row + 1);
//                queenTile[row] = -1;
//            }
//        } else {
//            for (int i = 0; i < N; i++) {
//                if (isAttackable(row, i)) {
//                    continue;
//                } else {
//                    queenTile[row] = i;
//                    doAlgorithm(queenCount + 1, row + 1);
//                    queenTile[row] = -1;
//                }
//            }
//        }
//    }
//
//    public static boolean isAttackable(int row, int col) {
//        for(int i=0;i<row;i++) {
//            if(i == row || queenTile[i] == col) return true;
//            if (i - queenTile[i] == row - col) return true; // 대각선
//            if ((i + queenTile[i]) == (row + col)) return true; // 역대각선
//        }
//
//        return false;
//    }
//
//    static class YoggaebReader {
//        private BufferedReader br;
//        private StringTokenizer st;
//
//        public YoggaebReader() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        String next() {
//            while (st == null || !st.hasMoreElements()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            return st.nextToken();
//        }
//
//        int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        String nextLine() {
//            String str = "";
//            try {
//                str = br.readLine();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//}