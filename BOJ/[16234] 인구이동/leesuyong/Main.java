package BOJ_16234_인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R, depth, sum;
    static int[][] map;
    static int[][] visited;
    static int[] nx = {0,0,1,-1};
    static int[] ny = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {      //더 이상 이동이 없을때까지 한다.

            visited = new int[N][N];
            Map<Integer, Integer> maps = new HashMap<Integer, Integer>();

            //dfs를 통해 그룹을 만든다.
            int group = 1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        //아직 안 간 곳이라면 가서 탐색
                        depth = 0;
                        sum = 0;
                        dfs(i, j, group++);

                        //depth가 1이라는 건 연합이 없다는 의미 -> 패스
                        //값을 maps에 저장한다.
                        if (depth > 1) {
                            maps.put(group - 1, sum / depth);
                        }
                    }
                }
            }

            //각 그룹에 대해 값을 갱신한다.
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int groups = visited[i][j];
                    Integer integer = maps.get(groups);
                    if (integer != null) {
                        map[i][j] = integer;
                    }
                }
            }
            if (maps.size() == 0) break;
            result++;
        }

        System.out.println(result);
    }

    static public void dfs(int x, int y, int group) {
        visited[x][y] = group;
        depth++;
        sum += map[x][y];

        for (int i = 0; i < 4; i++) {       //상하좌우에 대해
                int nextx = x + nx[i];
                int nexty = y + ny[i];

                if (nextx >= 0 && nextx < N && nexty >= 0 && nexty < N) {       //인덱스 에러 체크
                    if (visited[nextx][nexty] == 0) {                   //아직 안간곳만 감
                        int abs = Math.abs(map[nextx][nexty] - map[x][y]);
                        if (abs >= L && abs <= R){              //문제에서 주어진 범위에 해당하는지 확인
                            dfs(nextx, nexty, group);
                        }
                    }
                }
        }
    }
}
