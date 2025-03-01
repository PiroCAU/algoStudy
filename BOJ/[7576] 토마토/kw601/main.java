//진짜 못찾겠는데 이건 안되고

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
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
                // 토마토가 있으면 주변에 영향 -> 전부 행렬에 넣음
                if (nums[i][j] == 1) {
                    que.offer(new int[]{i, j});
                }
            }
        }


        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while(!que.isEmpty()) {
            // 하나 꺼내서
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cx + dy[i];
                // # 옆에 토마토 있고 안 익었으면
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && nums[nx][ny] == 0){
                    // # 토마토 익음!
                    nums[nx][ny] = nums[cx][cy] + 1;
                    // # 이제 다음 차례엔 얘도 영향을 줆
                    que.offer(new int[]{nx, ny});
                }
            }
        }
        
        int days = -1;

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (nums[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, nums[i][j]);
            }
        }
        System.out.println(days - 1); //  # 처음부터 익어있던 토마토가 1
    }
}