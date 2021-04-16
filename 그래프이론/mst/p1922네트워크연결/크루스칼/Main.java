package 그래프이론.mst.p1922네트워크연결.크루스칼;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vertax {
    Vertax parent;
    int id;
    boolean isVisted;

    public Vertax(int id, boolean isVisted) {
        this.parent = this;
        this.id = id;
        this.isVisted = isVisted;
    }

    public Vertax findParent(Vertax p) {
//        System.out.println(this.id + ", " + p.id);
        if(p.id == p.parent.id) {
//            System.out.println(p.parent.id + ", " + p.id);
            return p;
        }

        return p = findParent(p.parent);
    }

    public int merge(Vertax v,int total ,int cost) {
        Vertax u = findParent(parent);
        v = findParent(v.parent);

        if(u.id == v.id) {
            return total;
        }

        v.parent = parent;
        return total + cost;
    }
}

class Edge {
    Vertax from;
    Vertax to;
    boolean isVisted;
    int value;

    public Edge(Vertax from, Vertax to, boolean isVisted, int value) {
        this.from = from;
        this.to = to;
        this.isVisted = isVisted;
        this.value = value;
    }
}

public class Main {
    public static List<Vertax> vertaxes = new ArrayList<>();
    public static List<Edge> edges = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int N = scr.nextInt();
        int M = scr.nextInt();

        for (int i = 0; i <= N; i++) {
            Vertax vertax = new Vertax(i, false);
            vertaxes.add(vertax);
        }

        for (int i = 0; i < M; i++) {
            int from = scr.nextInt() - 1;
            int to = scr.nextInt() - 1;
            int value = scr.nextInt();

            Edge edge = new Edge(
                    vertaxes.get(from),
                    vertaxes.get(to),
                    false,
                    value);

            edges.add(edge);
        }

        edges.sort((Edge edge1, Edge edge2) -> edge1.value - edge2.value);

        int total = 0;

        for(int i=0;i<M;i++) {
            Edge edge = edges.get(i);
//            System.out.println("from= " + edge.from.id + " to= " + edge.to.id + " value= " + edge.value);
            total = edge.from.merge(edge.to, total, edge.value);
        }

        System.out.println(total);
    }
}
