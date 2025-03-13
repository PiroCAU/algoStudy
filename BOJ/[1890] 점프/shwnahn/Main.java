package src.week4.점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] grid;
    static long[][] dp; // 도착점까지 경로의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // (1) 입력 받기
        N = Integer.parseInt(st.nextToken());
        grid = new int[N][N];
        dp = new long [N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        dfs(0, 0);
        System.out.println(dp[0][0]);
//        System.out.println(Arrays.deepToString(dp).replace("], ", "]\n"));
    }

    public static long dfs(int r, int c) {
        // 1. 도착점일 경우
        if (r == N - 1 && c == N - 1) return 1;

        // 2. 이미 방문한 적이 있는 경우 dp값 리턴
        if (dp[r][c] != -1) return dp[r][c];

        // 3. 이동
        dp[r][c] = 0; // 방문이력 남기기
        int step = grid[r][c];
        // 3-1. 아래
        if (r + step < N) {
            dp[r][c] += dfs(r + step, c);
        }
        // 3-2. 오른쪽
        if (c + step < N) {
            dp[r][c] += dfs(r, c + step);
        }

        return dp[r][c]; // 경로의 수 리턴
    }
}