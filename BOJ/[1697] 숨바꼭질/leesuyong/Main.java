package BOJ_1697_숨바꼭질;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Arrays.fill(visited, -1);

        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{N, 0});

        while (!que.isEmpty()) {
            int[] poll = que.poll();

            int x = poll[0];
            int q = poll[1];
            if (x == K) {
                System.out.println(q);
                break;
            } else if (x < 0 || x > 100000) {
                continue;
            }

            if (x - 1 >= 0 && visited[x - 1] == -1) {
                que.add(new int[]{x - 1, q + 1});
                visited[x - 1] = q + 1;

            }  if (x + 1 < 100001 && visited[x + 1] == -1) {
                que.add(new int[]{x + 1, q + 1});
                visited[x + 1] = q + 1;

            } if (x * 2 < 100001 && visited[ x * 2] == -1) {
                que.add(new int[]{x * 2, q + 1});
                visited[x * 2] = q + 1;
            }
        }
    }
}
