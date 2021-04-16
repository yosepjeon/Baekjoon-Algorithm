package 그래프이론.mst.p1922네트워크연결.프림;

import java.util.*;

class Vertax {
    int id;
    boolean isVisited;
    List<Edge> linkedVertaxes;

    public Vertax(int id) {
        this.id = id;
        this.isVisited = false;
        this.linkedVertaxes = new ArrayList<>();
    }
}

class Edge {
    int toId;
    int value;

    public Edge(int toId, int value) {
        this.toId = toId;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        int N = scr.nextInt();
        int M = scr.nextInt();
        List<Vertax> vertaxes = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();

        for (int i = 0; i < N; i++) {
            vertaxes.add(new Vertax(i));
            edges.put(i, new HashMap<>());
        }

        for (int i = 0; i < M; i++) {
            int fromId = scr.nextInt() - 1;
            int toId = scr.nextInt() - 1;
            int value = scr.nextInt();

            Vertax from = vertaxes.get(fromId);
            Vertax to = vertaxes.get(toId);

            from.linkedVertaxes.add(new Edge(toId, value));
            to.linkedVertaxes.add(new Edge(fromId, value));

            edges.get(fromId).put(toId, value);
            edges.get(toId).put(fromId, value);
        }

        int answer = doAlgorithm(vertaxes, vertaxes.get(0), 0);

        System.out.println(answer);
    }

    public static int doAlgorithm(List<Vertax> vertaxes, Vertax start, int total) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((Edge e1, Edge e2) -> e1.value - e2.value);
        start.isVisited = true;
        start.linkedVertaxes.forEach((Edge e) -> {
            pq.add(e);
        });

        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            Vertax to = vertaxes.get(e.toId);
            if(to.isVisited) {
                continue;
            }

            to.isVisited = true;
            total += e.value;
            to.linkedVertaxes.forEach((Edge e1) -> {
                if(!vertaxes.get(e1.toId).isVisited) {
                    pq.add(e1);
                }
            });
        }

        return total;
    }
}
