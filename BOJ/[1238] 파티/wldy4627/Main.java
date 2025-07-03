package boj.b1238.wldy4627;

import java.util.*;

class Node implements Comparable<Node> {
    int to, cost;
    Node (int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node that) {
        return this.cost - that.cost;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> road, reverse_road;
    static int N, M, X;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();

        road = new ArrayList<>();
        reverse_road = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            road.add(new ArrayList<>());
            reverse_road.add(new ArrayList<>());
        }

        int from, to, cost;
        for (int i = 0; i < M; i++) {
            from = sc.nextInt();
            to = sc.nextInt();
            cost = sc.nextInt();

            road.get(from).add(new Node(to, cost));
            reverse_road.get(to).add(new Node(from, cost));
        }

        int[] dist1 = dijkstra(road);  // X에서 시작점의 최간거리
        int[] dist2 = dijkstra(reverse_road);  // 시작점에서 X의 최단거리

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        System.out.println(ans);
    }

    public static int[] dijkstra(ArrayList<ArrayList<Node>> road) {
        boolean[] check = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.to;

            if (!check[cur]) {
                check[cur] = true;
                for (Node n : road.get(cur)) {
                    if (!check[n.to] && dist[n.to] > dist[cur] + n.cost) {
                        dist[n.to] = dist[cur] + n.cost;
                        pq.add(new Node(n.to, dist[n.to]));
                    }
                }
            }
        }
        return dist;
    }
}
