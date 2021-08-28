package bfs.p2660회장뽑기;

import java.util.*;

public class Main {
    static int N;
    static int[][] relationShipPointMap;

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        Map<Integer, Member> members = new HashMap<>();
        int min = Integer.MAX_VALUE;

        N = scr.nextInt();

        relationShipPointMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                relationShipPointMap[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) {
            Member member = new Member(i + 1);

            members.put(i + 1, member);
        }

        while (true) {
            int start = scr.nextInt();
            int end = scr.nextInt();

            if (start == -1 && end == -1) {
                break;
            }

            Member startMember = members.get(start);
            Member endMember = members.get(end);

            startMember.addFriend(endMember);
            endMember.addFriend(startMember);
        }

        PriorityQueue<Candidate> pq = new PriorityQueue<>((Candidate c1, Candidate c2) -> {
            if(c1.score > c2.score) {
                return 1;
            }else if(c1.score < c2.score) {
                return -1;
            }else {
                if(c1.id > c2.id) {
                    return 1;
                }else if(c1.id < c2.id) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        members.forEach((Integer id, Member member) -> {
            int score = member.getScore();

            pq.add(new Candidate(id, score));
        });

        Iterator<Integer> itr = members.keySet().iterator();

        while(itr.hasNext()) {
            int key = itr.next();

            Member member = members.get(key);
            int score = member.getScore();

            if(min > score) {
                min = score;
            }
        }

        List<Candidate> candidates = new ArrayList<>();
        while (!pq.isEmpty() && pq.peek().score == min) {
            Candidate c = pq.poll();

            candidates.add(c);
        }

        System.out.println(min + " " +  candidates.size());

        candidates.forEach((Candidate c) -> {
            System.out.print(c.id +" ");
        });
    }
}

class Candidate {
    int id;
    int score;

    public Candidate(int id, int score) {
        this.id = id;
        this.score = score;
    }
}

class Member {
    private final int id;
    private final List<Member> friends = new ArrayList<>();

    public Member(int id) {
        this.id = id;
    }

    public void addFriend(Member member) {
        this.friends.add(member);
    }

    public int getScore() {
        boolean[] isVisited = new boolean[Main.N];
        int[] scores = new int[Main.N];
        isVisited[id - 1] = true;
        scores[id - 1] = -1;
        int score = 1;

        Queue<Member> queue = new LinkedList<>();
        for (Member friend : friends) {
            isVisited[friend.id - 1] = true;
            scores[friend.id - 1] = 1;
            queue.add(friend);
        }

        while (!queue.isEmpty()) {
            Member friend = queue.poll();

            for (Member f : friend.friends) {
                if (!isVisited[f.id - 1]) {
                    scores[f.id - 1] = scores[friend.id - 1] + 1;
                    isVisited[f.id - 1] = true;
                    queue.add(f);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int s : scores) {
            if (max < s) {
                max = s;
            }
        }

        return max;
    }
}
