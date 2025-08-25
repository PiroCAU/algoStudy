package boj.b3190.wldy4627;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] apple = new int[N][N];
        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            apple[x-1][y-1] = 1;
        }

        int L = sc.nextInt();
        Map<Integer, Character> dir = new HashMap<>();
        for (int i = 0; i < L; i++) {
            int X = sc.nextInt();
            char C = sc.next().charAt(0);
            dir.put(X, C);
        }

        Deque<int[]> body = new ArrayDeque<>();
        body.addLast(new int[]{0, 0});

        boolean[][] occ = new boolean[N][N];
        occ[0][0] = true;

        int sec = 0;
        int curDir = 0;  // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3: 위
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (true) {
            sec++;

            int[] head = body.peekLast();
            int nx = head[0] + dx[curDir];
            int ny = head[1] + dy[curDir];

            // 벽 충돌
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

            if (occ[nx][ny]) break;

            if (apple[nx][ny] == 1) {
                // 사과 있음 -> 꼬리 유지, 머리만 추가
                if (occ[nx][ny]) break;
                body.addLast(new int[]{nx, ny});
                occ[nx][ny] = true;
                apple[nx][ny] = 0;
            } else {
                // 사과 없음 -> 꼬리 먼저 제거
                int[] tail = body.pollFirst();
                occ[tail[0]][tail[1]] = false;

                if (occ[nx][ny]) break;
                body.addLast(new int[]{nx, ny});
                occ[nx][ny] = true;
            }

            if (dir.containsKey(sec)) {
                char d = dir.get(sec);
                if (d == 'L') {
                    curDir = (curDir + 3) % 4;
                } else if (d == 'D') {
                    curDir = (curDir + 1) % 4;
                }
            }
        }

        System.out.println(sec);
    }
}
