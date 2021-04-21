package 그래프이론.강한결합요소.p2150scc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vertax {
    int id;
    int areaId;
    boolean isVisited;
    List<Vertax> linkedVertaxes;

    public Vertax(int id) {
        this.id = id;
        this.areaId = -1;
        this.isVisited = false;
        this.linkedVertaxes = new ArrayList<>();
    }
}

public class Main {
    static int V;
    static int E;
    static StringBuffer sb = new StringBuffer();
    static boolean isScc = false;
    static List<Vertax> vertaxes;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        vertaxes = new ArrayList<>();

        V = scr.nextInt();
        E = scr.nextInt();

        for (int i = 0; i < V; i++) {
            Vertax vertax = new Vertax(i);
            vertaxes.add(vertax);
        }

        for (int i = 0; i < E; i++) {
            int fromId = scr.nextInt() - 1;
            int toId = scr.nextInt() - 1;

            Vertax from = vertaxes.get(fromId);
            Vertax to = vertaxes.get(toId);

            from.linkedVertaxes.add(to);
        }

        int areaId = 0;
        int vertaxesSize = vertaxes.size();

        for (int i = 0; i < vertaxesSize; i++) {
            areaId++;
            if(scc(i, vertaxes.get(i), areaId)) {
                sb.append(-1 + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static boolean scc(int startId, Vertax vertax, int areaId) {
        if(startId == vertax.id && vertax.areaId != -1) {
            System.out.println(vertax.id);
            return true;
        }

//        if(vertax.isVisited) {
//            return false;
//        }

        vertax.isVisited = true;
        vertax.areaId = areaId;
        int linkedVertaxSize = vertax.linkedVertaxes.size();

        for(int i=0;i<linkedVertaxSize;i++) {
            if(scc(startId, vertaxes.get(i), areaId)) {
                System.out.println("@@");
                return true;
            }else {
                vertaxes.get(i).isVisited = false;
            }
        }

        return false;
    }

//    public static void scc(Vertax vertax, int areaId) {
//        if(vertax.isVisited || vertax.areaId != -1) {
//            return;
//        }
//
//        vertax.areaId = areaId;
//        vertax.isVisited = true;
//        sb.append((vertax.id + 1) + " ");
//
//        vertax.linkedVertaxes.forEach((Vertax v) -> {
//            scc(v, areaId);
//        });
//    }
}
