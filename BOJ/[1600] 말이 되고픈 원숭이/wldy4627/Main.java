package boj.b1600.wldy4627;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();

        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[] horseDx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] horseDy = {1, 2, 2, 1, -1, -2, -2, -1};

        int[] monkeyDx = {-1, 1, 0, 0};
        int[] monkeyDy = {0, 0, -1, 1};

        boolean[][][] visited = new boolean[H][W][K+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == H-1 && now[1] == W-1) {
                System.out.println(now[3]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + monkeyDx[i];
                int ny = now[1] + monkeyDy[i];
                if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                    if (map[nx][ny] == 0 && !visited[nx][ny][now[2]]) {
                        visited[nx][ny][now[2]] = true;
                        queue.add(new int[]{nx, ny, now[2], now[3] + 1});
                    }
                }
            }

            if (now[2] < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = now[0] + horseDx[i];
                    int ny = now[1] + horseDy[i];
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
                        if (map[nx][ny] == 0 && !visited[nx][ny][now[2] + 1]) {
                            visited[nx][ny][now[2] + 1] = true;
                            queue.add(new int[]{nx, ny, now[2] + 1, now[3] + 1});
                        }
                    }
                }
            }
        }
        System.out.println("-1");
    }
}
