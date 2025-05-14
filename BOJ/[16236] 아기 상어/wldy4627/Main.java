package boj.b16236.wldy4627;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int N;
    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static int sharkX;
    public static int sharkY;
    public static int sharkSize = 2;
    public static int eatCount = 0;
    public static int time = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int[] result = bfs(); // [x, y, dist]
            if (result == null) break;

            sharkX = result[0];
            sharkY = result[1];
            time += result[2];  // 이동 시간 누적
            map[sharkX][sharkY] = 0;  // 물고기 먹기 처리

            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }
        System.out.println(time);
    }

    public static int[] bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> fishes = new LinkedList<>();

        queue.offer(new int[]{sharkX, sharkY, 0});
        visited[sharkX][sharkY] = true;
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (dist > minDist) break;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

                int target = map[nx][ny];
                if (target <= sharkSize) {
                    visited[nx][ny] = true;
                    if (target > 0 && target < sharkSize) {
                        fishes.add(new int[]{nx, ny, dist + 1});
                        minDist = dist + 1;
                    }
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        if (fishes.isEmpty()) return null;

        fishes.sort((a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];  // 왼쪽
        });

        return fishes.get(0);
    }
}