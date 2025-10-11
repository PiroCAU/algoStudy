package BOJ_13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        bfs(N);
    }

    static void bfs(int x) {
        Deque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, 0});       //시작점 세팅
        visited[x] = true;

        while (!que.isEmpty()) {
            int[] p = que.poll();

            //목적지 도착 시 종료
            if (p[0] == K) {
                System.out.println(p[1]);
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next;
                int cnt;
                if (i == 0) {
                    next = p[0] * 2;
                    cnt = p[1];

                    if (0 <= next && next <= 100000 && !visited[next]) {
                        que.offerFirst(new int[]{next, cnt});
                        visited[next] = true;
                    }
                } else if (i == 1) {
                    next = p[0] - 1;
                    cnt = p[1] + 1;

                    if (0 <= next && next <= 100000 && !visited[next]) {
                        que.offerLast(new int[]{next, cnt});
                        visited[next] = true;
                    }
                } else {
                    next = p[0] + 1;
                    cnt = p[1] + 1;

                    if (0 <= next && next <= 100000 && !visited[next]) {
                        que.offerLast(new int[]{next, cnt});
                        visited[next] = true;
                    }
                }
            }
        }
    }
}
