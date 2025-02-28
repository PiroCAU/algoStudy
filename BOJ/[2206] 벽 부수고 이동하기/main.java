import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};   

        int[][] maps = new int[n][m];
        int[][][] visited = new int[n][m][2];
        visited[0][0][0] = 1;
        // [0][0] -> 첫 번째는 벽 안 부수고 도달한 거리, 두 번째는 벽 부수고 도달한 거리

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                maps[i][j] = Character.getNumericValue(row.charAt(j));
            }
        }

        // 큐 생성, 처음 시작점 넣기
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0, 0});

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            int is_broken = cur[2];
            if (cx == n - 1 && cy == m - 1) {
                System.out.println(visited[cx][cy][is_broken]);
                return;
            }
            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m){
                    // 벽 X, 방문한 적 없음 // 벽은 부쉈든 안부쉈든 상관 없으므로 받은 그대로 전달
                    if (maps[nx][ny] == 0 && visited[nx][ny][is_broken] == 0){
                        // 지금 이동한 경로 + 1
                        visited[nx][ny][is_broken] = visited[cx][cy][is_broken] + 1;
                        que.offer(new int[]{nx, ny, is_broken});
                    }
                    // 벽 O, 부순 적 없음
                    else if(maps[nx][ny] == 1 && is_broken == 0){
                        // 벽 부순 횟수 저장 칸에 + 1
                        visited[nx][ny][1] = visited[cx][cy][0] + 1;
                        que.offer(new int[]{nx, ny, 1});
                    }
                    // 이미 방문 / 벽인데 이미 벽 부순 경우
                    else
                        continue;
                }
            }
        }
        System.out.println(-1);
    }
}