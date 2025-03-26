package pro.p159993.wldy4627;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    private static char[][] maze;
    private static int row;
    private static int col;
    // 이동할 네 방향 정의 (상, 하, 좌, 우)
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static int solution(String[] maps) {
        row = maps.length;
        col = maps[0].length();
        maze = new char[row][col];

        for (int i = 0; i < row; i++) {
            maze[i] = maps[i].toCharArray();
        }

        int startRow = -1, startCol = -1;
        int leverRow = -1, leverCol = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maze[i][j] == 'S') {  // 만약 미로의 시작 지점이라면
                    startRow = i;
                    startCol = j;
                }
                if (maze[i][j] == 'L') {
                    leverRow = i;
                    leverCol = j;
                }
            }
            if (startRow != -1 && leverRow != -1) break;
        }

        // 먼저 레버가 있는 칸으로 이동
        int toLever = bfs(startRow, startCol, 'L');
        if (toLever == -1) return -1;

        int toExit = bfs(leverRow, leverCol, 'E');
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    private static int bfs(int x, int y, char target) {
        int[][] dist = new int[row][col];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            if (maze[r][c] == target) return dist[r][c];

            for (int i = 0; i < 4; i++) {
                int nextRow = r + dx[i];
                int nextCol = c + dy[i];

                if (nextRow >= 0 && nextRow < row && nextCol >= 0 && nextCol < col && maze[nextRow][nextCol] != 'X') {
                    if (dist[nextRow][nextCol] > dist[r][c] + 1) {
                        dist[nextRow][nextCol] = dist[r][c] + 1;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
        }

        return -1;  // 도달 불가
    }

    public static void main(String[] args) {
        String[] maps = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        int result = solution(maps);
        System.out.println(result);
    }
}