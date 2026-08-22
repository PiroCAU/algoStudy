import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        List<Integer>[] map = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] road : roads) {
            map[road[0]].add(road[1]);
            map[road[1]].add(road[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> que = new ArrayDeque<>();
        que.offer(destination);
        dist[destination] = 0;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : map[cur]) {
                if (dist[next] != -1)
                    continue;

                dist[next] = dist[cur] + 1;
                que.offer(next);
            }
        }

        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}

// 오 최단거리... 가중치 1...
// 도착지 -> 모든 노드 bfs