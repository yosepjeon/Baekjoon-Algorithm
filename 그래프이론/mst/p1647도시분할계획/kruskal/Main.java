package 그래프이론.mst.p1647도시분할계획.kruskal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vertax {
    Vertax parent;
    int id;
    boolean isVisited;

    public Vertax(int id) {
        parent = this;
        this.id = id;
        this.isVisited = false;
    }

    private Vertax findParent(Vertax p) {
        if (p.id == p.parent.id) {
            return p;
        }

        return findParent(p.parent);
    }

    public int merge(Vertax to, int total, int cost) {
        parent = findParent(parent);
        Vertax toParent = findParent(to.parent);

        if (parent.id == toParent.id)
            return total;

        toParent.parent = parent;
        Main.linkCount++;
        return total + cost;
    }
}

class Edge {
    Vertax from;
    Vertax to;
    int cost;

    public Edge(Vertax from, Vertax to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {
    static int linkCount = 0;
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        List<Vertax> vertaxes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        N = scr.nextInt();
        M = scr.nextInt();

        for (int i = 0; i < N; i++) {
            Vertax vertax = new Vertax(i);
            vertaxes.add(vertax);
        }

        for (int i = 0; i < M; i++) {
            int fromId = scr.nextInt() - 1;
            int toId = scr.nextInt() - 1;
            int cost = scr.nextInt();

            Vertax from = vertaxes.get(fromId);
            Vertax to = vertaxes.get(toId);

            edges.add(new Edge(from, to, cost));
        }

        edges.sort((Edge e1, Edge e2) -> {
            return e1.cost - e2.cost;
        });

        System.out.println(doAlgorithm(edges));
    }

    public static int doAlgorithm(List<Edge> edges) {
        int edgesLen = edges.size();
        int total = 0;

        for (int i = 0; i < edgesLen; i++) {
            if(linkCount == N-2) {
                break;
            }

            Edge edge = edges.get(i);
            Vertax from = edge.from;
            Vertax to = edge.to;
            int cost = edge.cost;

            total = from.merge(to, total, cost);
//            System.out.println(total);
        }

        return total;
    }
}
