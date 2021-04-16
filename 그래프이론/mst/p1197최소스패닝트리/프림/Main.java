package 그래프이론.mst.p1197최소스패닝트리.프림;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Vertax {
    int id;
    boolean isVisited;
    List<Edge> edges;

    public Vertax(int id) {
        this.id = id;
        this.isVisited = false;
        this.edges = new ArrayList<>();
    }
}

class Edge {
    int from;
    int to;
    int value;

    public Edge(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        int V =  scr.nextInt();
        int E = scr.nextInt();
        List<Vertax> vertaxes = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        for(int i=0;i<V;i++ ) {
            vertaxes.add(new Vertax(i));
        }

        for(int i=0;i<E;i++) {
            int fromId = scr.nextInt() - 1;
            int toId = scr.nextInt() - 1;
            int value = scr.nextInt();

            Vertax fromVertax = vertaxes.get(fromId);
            Vertax toVertax = vertaxes.get(toId);

            fromVertax.edges.add(new Edge(fromId, toId, value));
            toVertax.edges.add(new Edge(toId, fromId, value));
        }

        long answer = doAlgorithm(vertaxes.get(0), vertaxes, edges);

        System.out.println(answer);
    }

    public static long doAlgorithm(Vertax start, List<Vertax> vertaxes, List<Edge> edges) {
        long total = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((Edge e1, Edge e2) -> e1.value - e2.value);
        start.isVisited = true;
        start.edges.forEach((Edge edge) -> {
            pq.add(edge);
        });

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            Vertax toVertax = vertaxes.get(edge.to);

            if(toVertax.isVisited) {
                continue;
            }

            toVertax.isVisited = true;
            total += edge.value;
            toVertax.edges.forEach((Edge e) -> {
                if(!vertaxes.get(e.to).isVisited) {
                    pq.add(e);
                }
            });
        }

        return total;
    }
}
