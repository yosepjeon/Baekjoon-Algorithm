package bfs.p16953AB;

import java.util.Scanner;

public class Main {
    static boolean isGet = false;
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int A = scr.nextInt();
        int B = scr.nextInt();

        multiplyTwo(A, B, 1);
        appendOne(A, B, 1);

        if(!isGet) {
            System.out.println(-1);
        }
    }

    public static void multiplyTwo(int value, int B, int count) {
        if(isGet || value > B) {
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

    public static void appendOne(int value, int B, int count) {
        if(isGet || value > B) {
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

        value = Integer.parseInt(sb.toString());
        multiplyTwo(value, B, count + 1);
        appendOne(value, B, count + 1);
    }
}
