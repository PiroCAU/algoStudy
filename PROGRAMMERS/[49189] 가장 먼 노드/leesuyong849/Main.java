package BOJ_49189_가장먼노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

}

class Solution {
    public int solution(int n, int[][] edge) {

        ArrayList<Integer>[] map = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            map[a].add(b);
            map[b].add(a);
        }

        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        //얼마나 떨어져 있는지 저장
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : map[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    queue.add(next);
                }
            }
        }

        //저장된 데이터 찾아서 얼마나 떨어졌는지 확ㅇ니
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                answer++;
            }
        }
        return answer;
    }
}