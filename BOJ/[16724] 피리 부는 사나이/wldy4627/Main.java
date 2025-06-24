package boj.b16724.wldy4627;

import java.util.Scanner;

public class Main {
    static String[][] map;
    static boolean[][] visited;
    static boolean[][] finished;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        map = new String[N][M];
        visited = new boolean[N][M];
        finished = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    public static void dfs(int currentX, int currentY) {
        visited[currentX][currentY] = true;

        int nextX = currentX;
        int nextY = currentY;

        if (map[currentX][currentY].equals("U")) {
            nextX = currentX - 1;
        } else if (map[currentX][currentY].equals("D")) {
            nextX = currentX + 1;
        } else if (map[currentX][currentY].equals("L")) {
            nextY = currentY - 1;
        } else if (map[currentX][currentY].equals("R")) {
            nextY = currentY + 1;
        }

        if (!visited[nextX][nextY]) {
            dfs(nextX, nextY);
        } else if (!finished[nextX][nextY]) {
            cnt++;
        }
        finished[currentX][currentY] = true;
    }
}
