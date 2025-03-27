package src.week6.미로탈출;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    static int maxRow;
    static int maxCol;
    static String[][] map;
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, 1, 0, -1};

    public int solution(String[] maps) {
        maxRow = maps.length;
        maxCol = maps[0].length();
        map = new String[maxRow][maxCol];

        Map<String, int[]> marks = new HashMap<>(); // <Mark, [row][col][dist]>
        for (int i = 0; i < maxRow; i++) {
            map[i] = maps[i].split("");
            for (int j = 0; j < maxCol; j++) {
                if (!map[i][j].equals("X") && !map[i][j].equals("O")) {
                    // Start, Lever, Exit 좌표 찾기
                    marks.put(map[i][j], new int[]{i, j});
                }
            }
        }

        // 시작점
        int[] start = marks.get("S");
        int[] lever = marks.get("L");
        int[] exit = marks.get("E");

        int toLever = bfs(start, lever);
        if (toLever == -1) return -1;

        int toExit = bfs(lever, exit);
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    public int bfs(int[] start, int[] dest) {
        boolean[][] visited = new boolean[maxRow][maxCol];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int r = tmp[0];
            int c = tmp[1];
            int dist = tmp[2];

            if (r == dest[0] && c == dest[1]) { // 목표지점 도달 시 거리 반환
                return dist;
            }

            // row, column 상하좌우 이동 케이스 모두 살펴보기
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (nr < 0 || nr >= maxRow || nc < 0 || nc >= maxCol) continue;
                if (visited[nr][nc] || map[nr][nc].equals("X")) continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc, dist + 1});
            }
        }

        return -1; // 목표 도달 실패
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        int result = sol.solution(maps); // 예상 result: 16
        System.out.println("결과: " + result);
    }
}