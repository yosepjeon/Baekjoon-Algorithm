package 수학.p10430나머지;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int A, B, C;

        Scanner scr = new Scanner(System.in);

        A = scr.nextInt();
        B = scr.nextInt();
        C = scr.nextInt();

        int result = (A+B) % C;

        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C) * (B%C))%C);
    }
}
