package boj.b13549.wldy4627;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Deque<Integer> dq = new ArrayDeque<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;
        dq.add(N);

        while (!dq.isEmpty()) {
            int curr = dq.pollFirst();
            if (curr == K) break;

            // 순간이동 (가중치 0)
            int next = curr * 2;
            if (next < 100001 && dist[next] > dist[curr]) {
                dist[next] = dist[curr];
                dq.addFirst(next);
            }

            // 걷기 (가중치 1)
            for (int dir : new int[]{curr - 1, curr + 1}) {
                if (dir >= 0 && dir < 100001 && dist[dir] > dist[curr] + 1) {
                    dist[dir] = dist[curr] + 1;
                    dq.addLast(dir);
                }
            }
        }

        System.out.println(dist[K]);
    }
}
