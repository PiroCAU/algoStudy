import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] numberList;
    static boolean[][] visited;
    static int maxVal = Integer.MIN_VALUE;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numberList = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                numberList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, numberList[i][j]);
                visited[i][j] = false;
                dfs_u(i, j);
            }
        }

        System.out.println(maxVal);
    }

    static void dfs(int x, int y, int count, int sum) {
        if (count == 4) {
            maxVal = Math.max(maxVal, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, count + 1, sum + numberList[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    static void dfs_u(int x, int y) {
        int[][][] shapes = {
                {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // ㅗ
                {{0, 1}, {1, 0}, {1, 1}, {2, 1}}, // ㅓ
                {{1, 0}, {1, 1}, {1, 2}, {0, 1}}, // ㅜ
                {{0, 0}, {1, 0}, {2, 0}, {1, 1}}  // ㅏ
        };

        for (int[][] shape : shapes) {
            int sum = 0;
            boolean valid = true;

            for (int[] block : shape) {
                int nx = x + block[0];
                int ny = y + block[1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    valid = false;
                    break;
                }

                sum += numberList[nx][ny];
            }

            if (valid) {
                maxVal = Math.max(maxVal, sum);
            }
        }
    }
}