package 그래프이론.이분매칭.p2188축사배정;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cow {
    int id;
    List<Integer> preferences;

    public Cow(int id) {
        this.id = id;
        this.preferences = new ArrayList<>();
    }
}

public class Main {
    public static int[] barns;
    public static boolean[] isProccesed;
    public static List<Cow> cows;
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        N = scr.nextInt();
        M = scr.nextInt();

        barns = new int[M];
        isProccesed = new boolean[M];
        cows = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            barns[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            Cow cow = new Cow(i);
            int preferenceCount = scr.nextInt();

            for (int j = 0; j < preferenceCount; j++) {
                int preferenceId = scr.nextInt() - 1;
                cow.preferences.add(preferenceId);
            }

            cows.add(cow);
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            isProccesed = new boolean[M];
            Cow cow = cows.get(i);
            if(doBipartiteMatching(cow, 0)) answer++;
        }

        System.out.println(answer);
    }

    public static boolean doBipartiteMatching(Cow cow, int count) {
        int size = cow.preferences.size();

        for (int i = 0; i < size; i++) {
            int barnId = cow.preferences.get(i);
            if (!isProccesed[barnId]) {
                isProccesed[barnId] = true;

                if (barns[barnId] == -1 || doBipartiteMatching(cows.get(barns[barnId]), count + 1)) {
                    barns[barnId] = cow.id;
                    return true;
                }
            }
        }

        return false;
    }
}
