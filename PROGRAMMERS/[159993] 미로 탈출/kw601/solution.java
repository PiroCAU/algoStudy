import java.util.*;

class Solution {
    // BFS 함수
    private int bfs(int[] start, int[] end, String[] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];

        int sx = start[0], sy = start[1];
        int ex = end[0], ey = end[1];

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == ex && y == ey) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = true;
                        que.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return -1;
    }

    public int solution(String[] maps) {
        // 1. 입구S -> 레버L
        // 2. 레버L -> 출구E
        // S 출발해서 갈 수 있는 길 없으면 -1
        // 최단거리 -> bfs? dp?

        int[] start = {-1, -1};
        int[] lever = {-1, -1};
        int[] end = {-1, -1};
        int answer = 0;

        for (int x = 0; x < maps.length; x++) {
            for (int y = 0; y < maps[0].length(); y++) {
                char c = maps[x].charAt(y);
                if (c == 'S') {
                    start = new int[]{x, y};
                } else if (c == 'L') {
                    lever = new int[]{x, y};
                } else if (c == 'E') {
                    end = new int[]{x, y};
                }
            }
        }

        int toL = bfs(start, lever, maps);
        if (toL == -1) return -1;
        answer += toL;

        int toE = bfs(lever, end, maps);
        if (toE == -1) return -1;
        answer += toE;

        return answer;
    }
}