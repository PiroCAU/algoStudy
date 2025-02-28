// 이건 됨...
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] nums = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 1) {
                    que.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && nums[nx][ny] == 0) {
                    nums[nx][ny] = nums[cx][cy] + 1;
                    que.offer(new int[]{nx, ny});
                }
            }
        }

        int days = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, nums[i][j]);
            }
        }

        System.out.println(days - 1);
    }
}