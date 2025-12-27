package boj.b17484.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][M][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for (int j = 0; j < M; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = matrix[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j + 1 < M) {
                    dp[i][j][0] = matrix[i][j] + Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);
                }

                dp[i][j][1] = matrix[i][j] + Math.min(dp[i-1][j][0], dp[i-1][j][2]);

                if (j - 1 >= 0) {
                    dp[i][j][2] = matrix[i][j] + Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                ans = Math.min(ans, dp[N-1][i][j]);
            }
        }

        System.out.println(ans);
    }
}
