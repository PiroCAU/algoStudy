import java.util.ArrayList;
import java.util.Collections;

public class pro_154540 {

    static String[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] nx = {0,0,-1,1};
    static int[] ny = {-1,1,0,0};
    static int cnt;

    public int[] solution(String[] maps) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        map = new String[N][M];
        visited = new boolean[N][M];

        boolean flag = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = String.valueOf(maps[i].charAt(j));
                if (!map[i][j].equals("X")) {
                    flag = true;
                }
            }
        }

        //아무것도 없는 경우 -1  반환
        if (!flag) {
            answer = new int[]{-1};
            return answer;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //이미 방문한 곳은 패스
                if (visited[i][j]) {
                    continue;
                }

                //섬이라면 탐색 시작
                if (!map[i][j].equals("X")) {
                    cnt = 0;
                    DFS(i, j);
                    result.add(cnt);
                }

            }
        }
        Collections.sort(result);
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    private void DFS(int i, int j) {

        visited[i][j] = true;
        cnt += Integer.parseInt(map[i][j]);

        for (int k = 0; k < 4; k++) {
            int nextx = i + nx[k];
            int nexty = j + ny[k];

            if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < M) {
                if (!map[nextx][nexty].equals("X") && !visited[nextx][nexty]) {
                    DFS(nextx, nexty);
                }
            }
        }
    }
}
