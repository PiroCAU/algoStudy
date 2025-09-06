import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static StringTokenizer st;
    public static int N;
    public static int M;
    public static ArrayList<pos> vir;
    public static int[][] grid;
    public static int[] nextx = {0,0,-1,1};
    public static int[] nexty = {1,-1,0,0};
    public static ArrayList<pos> emptyList;
    public static Integer max = 0;

    static class pos {
        int x; int y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄: N, M
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화
        vir = new ArrayList<>();
        emptyList = new ArrayList<>();

        // N x M 그리드 입력
        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int parseInt = Integer.parseInt(st.nextToken());
                grid[i][j] = parseInt;

                if (parseInt == 2) {
                    vir.add(new pos(i, j));
                } else if (parseInt == 0) {
                    emptyList.add(new pos(i, j));
                }
            }
        }

        int E = emptyList.size();

        for (int a = 0; a < E - 2; a++) {
            for (int b = a + 1; b < E - 1; b++) {
                for (int c = b + 1; c < E; c++) {
                    pos A = emptyList.get(a);
                    pos B = emptyList.get(b);
                    pos C = emptyList.get(c);

                    int[][] tempMap = copy(grid);
                    tempMap[A.x][A.y] = 1;
                    tempMap[B.x][B.y] = 1;
                    tempMap[C.x][C.y] = 1;

                    for (pos pos : vir) {
                        tempMap[pos.x][pos.y] = 0;
                        dfs(pos.x, pos.y, tempMap);
                    }

                    int cnt = cntSafe(tempMap);
                    max = Math.max(max, cnt );
                }
            }
        }

        System.out.println(max);
    }

    public static void dfs(int x, int y, int[][] map) {

        if (map[x][y] == 1 || map[x][y] == 2) return;
        else map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + nextx[i];
            int ny = y + nexty[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            } else {
                dfs(nx, ny, map);
            }
        }
    }

    public static int[][] copy(int[][] origin) {
        int[][] newOne = new int[N][M];
        for (int i = 0; i < N; i++) {
            newOne[i] = origin[i].clone();
        }
        return newOne;
    }

    public static int cntSafe(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
