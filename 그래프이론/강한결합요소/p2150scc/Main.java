package 그래프이론.강한결합요소.p2150scc;

import java.util.*;
import java.io.*;

class Vertax {
    Vertax parent;
    int id;
    boolean isVisited;
    boolean completeScc;
    List<Vertax> linkedVertax;

    public Vertax(int id) {
        this.parent = this;
        this.id = id;
        this.isVisited = false;
        this.completeScc = false;
        linkedVertax = new ArrayList<>();
    }
}

public class Main {
    public static int V;
    public static int E;
    public static Vertax[] vertaxes;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        V = scr.nextInt();
        E = scr.nextInt();

        vertaxes = new Vertax[V];

        for (int i = 0; i < V; i++) {
            vertaxes[i] = new Vertax(i);
        }

        for (int i = 0; i < E; i++) {
            int startId = scr.nextInt() - 1;
            int endId = scr.nextInt() - 1;

            vertaxes[startId].linkedVertax.add(vertaxes[endId]);
        }

        for (int i = 0; i < V; i++) {
            Vertax vertax = vertaxes[i];

            Stack<Vertax> stack = new Stack<>();

            if (vertax.parent.id != i || vertax.completeScc) {
                continue;
            }

            scc(vertax, stack);
        }


        Map<Integer, List<Integer>> sccMap = new HashMap<>();
        for (int i = 0; i < V; i++) {
            Vertax v = vertaxes[i];
            int parentId = v.parent.id;

            if(sccMap.getOrDefault(parentId, null) == null) {
                sccMap.put(parentId, new ArrayList<>());
                sccMap.get(parentId).add(v.id);
            }else {
                sccMap.get(parentId).add(v.id);
            }
        }

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((List<Integer> l1, List<Integer> l2) -> l1.get(0) - l2.get(0));
        Iterator<Integer> keyItr = sccMap.keySet().iterator();

        while(keyItr.hasNext()) {
            int key = keyItr.next();
            sccMap.get(key).sort((Integer n1, Integer n2) -> n1 - n2);
            List<Integer> scc = sccMap.get(key);
            pq.add(scc);
        }

        System.out.println(sccMap.size());
        while(!pq.isEmpty()) {
            List<Integer> scc = pq.poll();

            scc.forEach((Integer n) -> {
                System.out.print((n + 1) + " ");
            });
            System.out.println(-1);
        }
    }

    public static void scc(Vertax vertax, Stack<Vertax> stack) {
        if (vertax.isVisited) {
            while (!stack.isEmpty()) {
                Vertax popedVertax = stack.peek();
                if (popedVertax.id == vertax.id) {
                    return;
                }
                popedVertax = stack.pop();

                popedVertax.completeScc = true;
                popedVertax.isVisited = false;
                popedVertax.parent = vertax;
            }
        } else {
            stack.push(vertax);
            vertax.isVisited = true;
            int linkedVertaxSize = vertax.linkedVertax.size();
            for (int i = 0; i < linkedVertaxSize; i++) {
                Vertax linkedVertax = vertax.linkedVertax.get(i);
                if (linkedVertax.id != linkedVertax.parent.id || linkedVertax.completeScc) {
                    continue;
                }

                scc(linkedVertax, stack);
            }

            // completeScc 부분 이해 후 정리해서 블로깅
            vertax.completeScc = true;
            vertax.isVisited = false;
        }
    }
}

//public class Main {
//    static ArrayList<ArrayList<Integer>> digraph; // 방향 그래프
//    static ArrayList<ArrayList<Integer>> rdigraph; // 역방향 그래프
//    static ArrayList<ArrayList<Integer>> res;
//    static boolean[] visited;
//    static Stack<Integer> stack;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int V = Integer.valueOf(st.nextToken()); // 정점의 개수
//        int E = Integer.valueOf(st.nextToken()); // 간선의 개수
//
//        digraph = new ArrayList<>();
//        rdigraph = new ArrayList<>();
//        res = new ArrayList<>();
//
//        for (int i = 0; i <= V; i++) {
//            digraph.add(new ArrayList<>());
//            rdigraph.add(new ArrayList<>());
//            res.add(new ArrayList<>());
//        }
//
//        // 단방향 인접리스트 구현 (방향 그래프, 역방향 그래프)
//        for (int i = 0; i < E; i++) {
//            st = new StringTokenizer(br.readLine());
//
//            int A = Integer.parseInt(st.nextToken());
//            int B = Integer.parseInt(st.nextToken());
//
//            digraph.get(A).add(B);
//            rdigraph.get(B).add(A);
//        }
//
//        visited = new boolean[V + 1];
//        stack = new Stack<>();
//
//        // 방향 그래프에 대하여 dfs를 수행하고,
//        // 탐색이 종료되는 점부터 스택에 push함.
//        for (int i = 1; i <= V; i++) {
//            if (!visited[i]) {
//                dfs(i);
//            }
//        }
//
//        Arrays.fill(visited, false);
//        int groupNum = 0;
//
//        // 역방향 그래프에 대하여 dfs룰 수행.
//        // 이때,
//        while (!stack.isEmpty()) {
//            int start = stack.pop();
//
//            // 방문 체크된 것은 이미 start가
//            // 하나의 SCC 그룹에 속해 있다는 뜻.
//            if (visited[start]) {
//                continue;
//            }
//
//            redfs(start, groupNum);
//            groupNum++;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(groupNum + "\n"); // SCC 그룹의 개수 출력.
//
//        TreeMap<Integer, Integer> map = new TreeMap<>(); // key를 기준으로 오름차순 정렬.
//        for (int i = 0; i < groupNum; i++) {
//            Collections.sort(res.get(i)); // 각각의 SCC 그룹에 대해 오름차순 정렬.
//            map.put(res.get(i).get(0), i); // key : SCC 그룹의 첫번째 항, value : 인덱스.
//        }
//
//        // map의 value를 이용하여
//        // 첫번째 항이 작은 순서대로 출력.
//        map.keySet().forEach(key -> {
//            int value = map.get(key);
//
//            for (int now : res.get(value)) {
//                sb.append(now + " ");
//            }
//            sb.append("-1\n"); // 끝에 -1 붙여주는 것 잊지 말기.
//        });
//
//        bw.write(sb.toString());
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    // 전형적인 dfs
//    // 다만 끝나는 점에 대해서는 stack에 push.
//    public static void dfs (int start) {
//        visited[start] = true;
//
//        for (int now : digraph.get(start)) {
//            if (!visited[now]) {
//                dfs(now);
//            }
//        }
//
//        stack.push(start);
//    }
//
//    // 전형적인 dfs
//    // 다만 결과값을 담는 res 코드가 추가됨.
//    public static void redfs(int start, int groupNum) {
//        visited[start] = true;
//        res.get(groupNum).add(start);
//
//        for (int now : rdigraph.get(start)) {
//            if (!visited[now]) {
//                redfs(now, groupNum);
//            }
//        }
//    }
//}


//        11 14
//        1 2
//        2 3
//        3 1
//        4 2
//        4 5
//        5 7
//        6 5
//        7 6
//        8 5
//        8 9
//        9 10
//        10 11
//        11 3
//        11 8


//7 9
//        1 4
//        4 5
//        5 1
//        1 6
//        6 7
//        2 7
//        7 3
//        3 7
//        7 2

//3 4
//        1 2
//        2 3
//        3 2
//        3 1