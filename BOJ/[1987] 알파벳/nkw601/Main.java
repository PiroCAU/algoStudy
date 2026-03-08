import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int R, C;
    private static char[][] map;
    private static boolean[] visited;
    private static int max = 0;

    private static final int[] dr = { -1, 1, 0, 0 };
    private static final int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[26];

        int start = map[0][0] - 'A';
        visited[start] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    private static void dfs(int r, int c, int count) {
        max = Math.max(max, count);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (!isIn(nr, nc))
                continue;

            int next = map[nr][nc] - 'A';

            if (!visited[next]) {
                visited[next] = true;
                dfs(nr, nc, count + 1);
                visited[next] = false;
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }
}