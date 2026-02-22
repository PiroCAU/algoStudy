import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static int N, D;
    private static int[] dist;
    private static ArrayList<int[]>[] arrList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 지름길 개수
        D = Integer.parseInt(st.nextToken()); // 도착 거리

        dist = new int[D + 1];
        arrList = new ArrayList[D + 1];

        for (int i = 0; i <= D; i++) {
            arrList[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        // 원래 도로 추가
        for (int i = 0; i < D; i++) {
            arrList[i].add(new int[] { i + 1, 1 });
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 볼 가치 확인
            if (to > D)
                continue;
            if (cost >= to - from)
                continue;

            arrList[from].add(new int[] { to, cost });
        }

        dijkstra(arrList, dist);

        System.out.println(dist[D]);
    }

    private static void dijkstra(ArrayList<int[]>[] adjList, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));

        dist[0] = 0;
        pq.offer(new int[] { 0, 0 });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curV = cur[0];
            int curD = cur[1];

            if (curD > dist[curV])
                continue;

            for (int[] edge : adjList[curV]) {
                int next = edge[0];
                int nextDist = curD + edge[1];

                if (nextDist < dist[next]) {
                    dist[next] = nextDist;
                    pq.offer(new int[] { next, nextDist });
                }
            }
        }
    }
}