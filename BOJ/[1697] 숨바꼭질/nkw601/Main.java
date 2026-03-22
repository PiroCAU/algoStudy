import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[200000];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[] { start, 0 });
        visited[start] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] == end) {
                System.out.println(cur[1]);
                break;
            }

            if (cur[0] - 1 >= 0) {
                int next = cur[0] - 1;
                if (!visited[next]) {
                    visited[next] = true;
                    pq.offer(new int[] { next, cur[1] + 1 });
                }
            }
            if (cur[0] + 1 < 200000) {
                int next = cur[0] + 1;
                if (!visited[next]) {
                    visited[next] = true;
                    pq.offer(new int[] { next, cur[1] + 1 });
                }
            }

            if (cur[0] * 2 < 200000) {
                int next = cur[0] * 2;
                if (!visited[next]) {
                    visited[next] = true;
                    pq.offer(new int[] { next, cur[1] + 1 });
                }
            }
        }
    }
}
