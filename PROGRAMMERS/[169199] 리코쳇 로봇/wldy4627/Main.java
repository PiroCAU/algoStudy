package pro.p142085.wldy4627;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int x, y, count;
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        String[] board = new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        int answer = solution(board);
        System.out.println(answer);
    }

    public static int solution(String[] board) {
        int startX = 0;
        int startY = 0;

        char[][] grid = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            grid[i] = board[i].toCharArray();
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'R') {
                    startX = i;
                    startY = j;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (grid[node.x][node.y] == 'G') {
                return node.count;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = node.x;
                int ny = node.y;

                while (true) {
                    int tx = nx + dx[dir];
                    int ty = ny + dy[dir];

                    if (tx < 0 || tx >= grid.length || ty < 0 || ty >= grid[0].length) break;
                    if (grid[tx][ty] == 'D') break;
                    nx = tx;
                    ny = ty;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny, node.count + 1));
                }
            }
        }

        return -1;
    }
}
