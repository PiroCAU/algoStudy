import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[][] deltas = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    static ArrayList<int[]> unions;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        // 이동할 국가들
                        unions = new ArrayList<>();
                        sum = 0;
                        dfs(r, c);
                        
                        // 인구 이동이 일어나면
                        if (unions.size() > 1) {
                            moved = true;
                            int avg = sum / unions.size();
                            for (int[] cell : unions) {
                                map[cell[0]][cell[1]] = avg;
                            }
                        }
                    }
                }
            }

            // 이동 안하면 그만
            if (!moved) break;
            days++;
        }

        System.out.println(days);
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        sum += map[r][c];
        unions.add(new int[]{r, c});

        for (int[] d : deltas) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (visited[nr][nc]) continue;

            int diff = Math.abs(map[r][c] - map[nr][nc]);
            if (diff >= L && diff <= R) {
                dfs(nr, nc);
            }
        }
    }
}

// 입력
// N L R
// N줄 인구 

// 출력
// 인구 이동이 발생한 일

// 생각
// 인구 차이가 L<= R>=이면 국경선 엶
// 열리면 이동: 인구수는 연합 / 칸 개수