import java.util.*;

public class Main {

    static List<List<Node>> nodes;

    static class Node {
        int x;
        int w;
        public Node(int x, int w) {
            this.x = x;
            this.w = w;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        nodes = new ArrayList<>();
        for (int i = 0; i <= n; i++) nodes.add(new ArrayList<>());

        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];
        for (int g : gates)   isGate[g] = true;
        for (int s : summits) isSummit[s] = true;

        for (int[] path : paths) {
            int x = path[0], y = path[1], w = path[2];
            if (isGate[x] || isSummit[y]) {
                nodes.get(x).add(new Node(y, w));
            } else if (isGate[y] || isSummit[x]) {
                nodes.get(y).add(new Node(x, w));
            } else {
                nodes.get(x).add(new Node(y, w));
                nodes.get(y).add(new Node(x, w));
            }
        }

        return dijkstra(n, gates, summits, isSummit);
    }

    private static int[] dijkstra(int n, int[] gates, int[] summits, boolean[] isSummit) {
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE); // 일단 최대값으로 채우고 최솟값 비교하기

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.w));

        // 여러 출발지(게이트) 초기화
        for (int g : gates) {
            intensity[g] = 0;
            pq.offer(new Node(g, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int u = cur.x;
            int curInt = cur.w;

            if (curInt > intensity[u]) continue;   // 현재 가야할 비용이 이전 최솟값보다 크면 생략
            if (isSummit[u]) continue;             // 정상이면 끝

            for (Node nx : nodes.get(u)) {
                int v = nx.x;
                int cand = Math.max(intensity[u], nx.w); // 경로 내 최댓값 최소화
                if (cand < intensity[v]) {
                    intensity[v] = cand;
                    if (!isSummit[v]) {            // 정상은 넣지 않아도 됨(선택 최적화)
                        pq.offer(new Node(v, cand));
                    }
                }
            }
        }

        // 결과 선택: intensity 최소, 같으면 번호가 작은 정상
        Arrays.sort(summits);
        int bestSummit = -1, bestInt = Integer.MAX_VALUE;
        for (int s : summits) {
            if (intensity[s] < bestInt) {
                bestInt = intensity[s];
                bestSummit = s;
            }
        }
        return new int[]{bestSummit, bestInt};
    }
}