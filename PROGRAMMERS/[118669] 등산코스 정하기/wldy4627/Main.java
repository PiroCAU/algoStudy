package pro.p118669.wldy4627;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];

        ArrayList<Node>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            graph[path[0]].add(new Node(path[1], path[2]));
            graph[path[1]].add(new Node(path[0], path[2]));
        }

        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];
        for (int gate : gates) {
            isGate[gate] = true;
        }
        for (int summit : summits) {
            isSummit[summit] = true;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);

        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.weight > intensity[node.to]) continue;
            if (isSummit[node.to]) continue;  // 산봉우리 도달 시 탐색 중단

            for (Node next : graph[node.to]) {
                if (isGate[next.to]) continue;  // 출입구로 역진입 불가
                int nextIntensity = Math.max(intensity[node.to], next.weight);

                if (nextIntensity < intensity[next.to]) {
                    intensity[next.to] = nextIntensity;
                    pq.offer(new Node(next.to, nextIntensity));
                }
            }
        }

        int minSummit = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                minSummit = summit;
            }
        }

        answer[0] = minSummit;
        answer[1] = minIntensity;

        return answer;
    }
}
