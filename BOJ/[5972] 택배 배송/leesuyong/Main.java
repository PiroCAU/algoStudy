package BOJ_5972_택배배송;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int to, w;
        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int N, M;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, w));
            graph[b].add(new Node(a, w));  // 무향
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dij(1);

        System.out.println(dist[N]);
    }

    static void dij(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        dist[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int cost = cur[1];

            if (cost > dist[now]) continue; // 이미 더 좋은 경로 있음

            for (Node next : graph[now]) {
                int nc = cost + next.w;
                if (nc < dist[next.to]) {
                    dist[next.to] = nc;
                    pq.offer(new int[]{next.to, nc});
                }
            }
        }
    }
}