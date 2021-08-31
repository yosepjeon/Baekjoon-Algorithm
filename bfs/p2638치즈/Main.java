package bfs.p2638치즈;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        Scanner scr = new Scanner(System.in);
        int cheeseCnt = 0;

        row = scr.nextInt();
        col = scr.nextInt();

        int[][] map = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int airCount = scr.nextInt();
                map[i][j] = airCount;

                if (airCount == 1) {
                    cheeseCnt++;
                }
            }
        }

        int time = doAlgorithm(cheeseCnt, map);

        System.out.println(time);
    }

    public static int doAlgorithm(int cheeseCnt, int[][] map) {
        if (cheeseCnt == 0) {
            return 0;
        }

        int count = cheeseCnt;
        int time = 0;

        while(count > 0) {
//            System.out.println(count);
            Queue<Element> queue = new LinkedList<>();
            boolean[][] isVisited = new boolean[row][col];

            Element element = new Element(0, 0);
            isVisited[0][0] = true;

            queue.add(element);
//            System.out.println(count);

            while (!queue.isEmpty()) {
//                System.out.println(queue.size());
                Element e = queue.poll();
//                System.out.println(queue.size());

                if (e.col + 1 < col && !isVisited[e.row][e.col + 1] && map[e.row][e.col + 1] == 0) {
                    queue.add(new Element(e.row, e.col + 1));
                    isVisited[e.row][e.col + 1] = true;
                }
                if (e.col - 1 >= 0 && !isVisited[e.row][e.col - 1] && map[e.row][e.col - 1] == 0) {
                    queue.add(new Element(e.row, e.col - 1));
                    isVisited[e.row][e.col - 1] = true;
                }
                if (e.row + 1 < row && !isVisited[e.row + 1][e.col] && map[e.row + 1][e.col] == 0) {
                    queue.add(new Element(e.row + 1, e.col));
                    isVisited[e.row + 1][e.col] = true;
                }
                if (e.row - 1 >= 0 && !isVisited[e.row - 1][e.col] && map[e.row - 1][e.col] == 0) {
                    queue.add(new Element(e.row - 1, e.col));
                    isVisited[e.row - 1][e.col] = true;
                }

                if (e.col + 1 < col && map[e.row][e.col + 1] > 0) {
                    map[e.row][e.col + 1] += 1;
//                    System.out.println(map[e.row][e.col + 1]);
                }
                if (e.col - 1 >= 0 && map[e.row][e.col - 1] > 0) {
                    map[e.row][e.col - 1] += 1;
                }
                if (e.row + 1 < row && map[e.row + 1][e.col] > 0) {
                    map[e.row + 1][e.col] += 1;
                }
                if (e.row - 1 >= 0 && map[e.row - 1][e.col] > 0) {
                    map[e.row - 1][e.col] += 1;
                }
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (map[i][j] >= 3) {
                        map[i][j] = 0;
                        count--;
                    }
                    if (0 < map[i][j] && map[i][j] < 3) {
                        map[i][j] = 1;
                    }
//                    System.out.print(map[i][j] + " ");
                }
//                System.out.println();
            }
//            System.out.println();

            time++;
        }

        return time;
    }
}

class Element {
    int row;
    int col;

    public Element(int row, int col) {
        this.row = row;
        this.col = col;
    }
}