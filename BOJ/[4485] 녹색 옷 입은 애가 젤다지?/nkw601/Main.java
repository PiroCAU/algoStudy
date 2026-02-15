
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, MAX = Integer.MAX_VALUE;
    static int[][] maps;
    static int[][] distance;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (N != 0) {

            // 초기화
            maps = new int[N][N];
            distance = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    maps[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = MAX;
                }
            }

            dijkstra();

            sb.append("Problem ").append(++cnt).append(": ").append(distance[N - 1][N - 1]).append('\n');
            N = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }

    static void dijkstra() {
        distance[0][0] = maps[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        pq.offer(new int[] { 0, 0, maps[0][0] });

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int cr = cur[0];
            int cc = cur[1];
            int dist = cur[2];

            if (cr == N - 1 && cc == N - 1)
                return;
            if (distance[cr][cc] < dist)
                continue;

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (!isIn(nr, nc))
                    continue;
                int nDist = distance[cr][cc] + maps[nr][nc];

                if (distance[nr][nc] > nDist) {
                    distance[nr][nc] = nDist;
                    pq.offer(new int[] { nr, nc, nDist });
                }
            }
        }
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
