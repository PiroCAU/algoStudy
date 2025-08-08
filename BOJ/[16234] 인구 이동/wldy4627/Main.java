package boj.b16234.wldy4627;

import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] land;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static boolean[][] visited;
    static ArrayList<int[]> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        land = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] = sc.nextInt();
            }
        }

        int day = 0;
        while (true) {
            boolean isMoved = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = dfs(i, j);
                        if (list.size() > 1) {
                            int avg = sum / list.size();
                            for (int[] pos : list) {
                                land[pos[0]][pos[1]] = avg;
                            }
                            isMoved = true;
                        }
                    }
                }
            }
            if (!isMoved) {
                System.out.println(day);
                return;
            }
            day++;
        }
    }

    static int dfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        list = new ArrayList<>();
        list.add(new int[]{x, y});

        visited[x][y] = true;
        int sum = land[x][y];

        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    int diff = Math.abs(land[temp[0]][temp[1]] - land[nx][ny]);
                    if (!visited[nx][ny] && L <= diff && diff <= R) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                        sum += land[nx][ny];
                    }
                }
            }
        }
        return sum;
    }
}
