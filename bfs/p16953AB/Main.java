package bfs.p16953AB;

import java.util.Scanner;

public class Main {
    static boolean isGet = false;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        long A = scr.nextInt();
        long B = scr.nextInt();

        multiplyTwo(A, B, 1);
        if (isGet) {
            return;
        }
        appendOne(A, B, 1);
        if (isGet) {
            return;
        }

        System.out.println(-1);

    }

    public static void multiplyTwo(long value, long B, long count) {
        if (isGet || value > B) {
            return;
        }

        if (value == B) {
            System.out.println(count);
            isGet = true;
            return;
        }

        value *= 2;

        multiplyTwo(value, B, count + 1);
        appendOne(value, B, count + 1);
    }

    public static void appendOne(long value, long B, long count) {
        if (isGet || value > B) {
            return;
        }

        if (value == B) {
            System.out.println(count);
            isGet = true;
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(value);
        sb.append(1);

        value = Long.parseLong(sb.toString());
        multiplyTwo(value, B, count + 1);
        appendOne(value, B, count + 1);
    }
}
