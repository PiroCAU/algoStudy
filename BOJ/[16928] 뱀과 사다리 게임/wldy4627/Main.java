package boj.b16928.wldy4627;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int N, M;
    public static int[] map;
    public static boolean[] visited;

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int moveCnt = current[1];

            if (pos == 100) {
                System.out.println(moveCnt);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > 100) continue;

                int dest = map[next];
                if (!visited[dest]) {
                    visited[dest] = true;
                    queue.offer(new int[]{dest, moveCnt + 1});
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[101];
        visited = new boolean[101];

        for (int i = 1; i <= 100; i++) {
            map[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            map[from] = to;
        }

        sc.close();

        bfs();
    }
}