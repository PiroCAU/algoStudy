import java.util.LinkedList;
import java.util.Queue;

public class Main {

    class Node{
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public int solution(String[] maps) {

        int n = maps.length;
        int m = maps[0].length();

        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;
        int exitX = 0, exitY = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    leverX = i;
                    leverY = j;
                } else if (c == 'E') {
                    exitX = i;
                    exitY = j;
                }
            }
        }

        // BFS 1: S -> L
        int toLever = bfs(maps, startX, startY, 'L');
        if (toLever == -1) return -1;

        // BFS 2: L -> E
        int toExit = bfs(maps, leverX, leverY, 'E');
        if (toExit == -1) return -1;

        return toLever + toExit;


    }

    private int bfs(String[] maps, int startX, int startY, char targetChar) {
        int n = maps.length;
        int m = maps[0].length();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (maps[cur.x].charAt(cur.y) == targetChar) {
                return cur.time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                        !visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, cur.time + 1));
                }
            }
        }

        return -1;
    }
}
