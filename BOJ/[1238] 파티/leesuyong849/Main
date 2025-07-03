import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Road {
        int to, time;
        public Road(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 도시 개수
        int M = Integer.parseInt(st.nextToken()); // 도로 개수
        int X = Integer.parseInt(st.nextToken()); // 파티가 열리는 도시

        // 인접 리스트 초기화 (1번부터 N번까지 도시)
        List<Road>[] graph = new ArrayList[N + 1];
        List<Road>[] reverseGraph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        // 도로 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new Road(to, time));
            reverseGraph[to].add(new Road(from, time));
        }

        int[] list1 = dij(X, graph, N);
        int[] list2 = dij(X, reverseGraph, N);

        int result = 0;

        for (int i = 1; i <= N; i++) {
            int townI = list1[i] + list2[i];
            if (townI > result) {
                result = townI;
            }
        }
        System.out.println(result);

    }

    static int[] dij(int start, List<Road>[] graph, int n) {
        PriorityQueue<Road> pq = new PriorityQueue<>(Comparator.comparingInt(r -> r.time));
        int[] dist = new int[n + 1];        //해당 위치까지 가는데 필요한 거리의 최솟값
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n + 1];
        dist[start] = 0;
        pq.add(new Road(start, 0));

        while (!pq.isEmpty()) {
            Road current = pq.poll();
            if (dist[current.to] < current.time) continue;

            for (Road next : graph[current.to]) {
                int newDis = dist[current.to] + next.time;
                if (newDis < dist[next.to]) {
                    dist[next.to] = newDis;
                    pq.add(new Road(next.to, newDis));
                }
            }
        }

        return dist;
    }
}
