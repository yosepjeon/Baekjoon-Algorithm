package 그래프이론.mst.p1197최소스패닝트리.크루스칼;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vertax {
    Vertax parent;
    int id;
    boolean isVisited;

    public Vertax(int id) {
        this.id = id;
        parent = this;
        isVisited = false;
    }

    public Vertax findParent(Vertax v) {
        if (v.id == v.parent.id) {
            return v;
        }

        return v = findParent(v.parent);
    }

    public long merge(Vertax to, long total, int cost) {
        Vertax from = findParent(parent);
        to = findParent(to.parent);
        int a = 3;
        long b = 0;

        if (from.id == to.id) {
            return total;
        }

        to.parent = parent;
        return total + cost;
    }
}

class Edge {
    Vertax from;
    Vertax to;
    int value;

    public Edge(Vertax from, Vertax to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int V = scr.nextInt();
        int E = scr.nextInt();
        List<Vertax> vertaxes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            vertaxes.add(new Vertax(i));
        }

        for (int i = 0; i < E; i++) {
            int fromId = scr.nextInt() - 1;
            int toId = scr.nextInt() - 1;
            int value = scr.nextInt();

            edges.add(new Edge(vertaxes.get(fromId), vertaxes.get(toId), value));
        }

        edges.sort((Edge e1, Edge e2) -> e1.value - e2.value);
        int size = edges.size();
        long answer = 0;

        for (int i = 0; i < size; i++) {
            Edge edge = edges.get(i);
            Vertax from = edge.from;
            Vertax to = edge.to;
            int cost = edge.value;

            answer = from.merge(to, answer, cost);
        }

        System.out.println(answer);
    }
}
