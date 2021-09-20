package bfs.p2146다리만들기;

import java.util.*;

public class Main {
    static int N;
    static int groupCount = 0;
    static int[][] map;
    static boolean[][] isVisited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        N = scr.nextInt();
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scr.nextInt();
            }
        }

        divideGroup();

        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j] + " ");
                if(map[i][j] != 0) {
                    tiles.add(new Tile(i, j, map[i][j]));
                }
            }
//            System.out.println();
        }

        int tilesLen = tiles.size();
        for (int i = 0; i < tilesLen; i++) {
            Tile tile1 = tiles.get(i);

            for (int j = i + 1; j < tilesLen; j++) {
                Tile tile2 = tiles.get(j);

                if (tile1.groupId == tile2.groupId) {
                    continue;
                } else {
                    int len = Math.abs(tile1.row - tile2.row) + Math.abs(tile1.col - tile2.col);

                    if(len == 1) {
                        System.out.println("tile1");
                        System.out.println(tile1.row + ", " + tile1.col + ", " + tile1.groupId);

                        System.out.println("tile2");
                        System.out.println(tile2.row + ", " + tile1.col + ", " + tile2.groupId);
                    }

                    if(min > len) {
                        min = len;
                    }
                }
            }
        }

        System.out.println(min - 1);
    }

    public static void divideGroup() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !isVisited[i][j]) {
                    groupCount++;
                    bfs(i, j, groupCount);
                }
            }
        }
    }

    public static void bfs(int row, int col, int groupId) {
        Queue<Element> queue = new LinkedList<>();
        isVisited[row][col] = true;
        map[row][col] = groupId;
        queue.add(new Element(row, col));

        while (!queue.isEmpty()) {
            Element e = queue.poll();

            if (e.col + 1 < N && map[e.row][e.col + 1] != 0 && !isVisited[e.row][e.col + 1]) {
                isVisited[e.row][e.col + 1] = true;
                map[e.row][e.col + 1] = groupId;
                queue.add(new Element(e.row, e.col + 1));
            }
            if (e.col - 1 >= 0 && map[e.row][e.col - 1] != 0 && !isVisited[e.row][e.col - 1]) {
                isVisited[e.row][e.col - 1] = true;
                map[e.row][e.col - 1] = groupId;
                queue.add(new Element(e.row, e.col - 1));
            }
            if (e.row + 1 < N && map[e.row + 1][e.col] != 0 && !isVisited[e.row + 1][e.col]) {
                isVisited[e.row + 1][e.col] = true;
                map[e.row + 1][e.col] = groupId;
                queue.add(new Element(e.row + 1, e.col));
            }
            if (e.row - 1 >= 0 && map[e.row - 1][e.col] != 0 && !isVisited[e.row - 1][e.col]) {
                isVisited[e.row - 1][e.col] = true;
                map[e.row - 1][e.col] = groupId;
                queue.add(new Element(e.row - 1, e.col));
            }
        }
    }
}

class Element {
    int row, col;

    public Element(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Tile {
    int row, col;
    int groupId;

    public Tile(int row, int col, int groupId) {
        this.row = row;
        this.col = col;
        this.groupId = groupId;
    }
}
