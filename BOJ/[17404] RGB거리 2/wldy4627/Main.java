package boj.b17404.wldy4627;

import java.util.Scanner;

public class Main {
    static int house[][];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        house = new int[N][3];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                house[i][j] = sc.nextInt();
            }
        }

        int result = 1_000_000_00;

        for (int firstColor = 0; firstColor < 3; firstColor++) {
            int[][] dp = new int[N][3];

            for (int j = 0; j < 3; j++) {
                if (j == firstColor) dp[0][j] = house[0][j];
                else dp[0][j] = result;
            }

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
            }

            for (int lastColor = 0; lastColor < 3; lastColor++) {
                if (lastColor == firstColor) continue;
                result = Math.min(result, dp[N-1][lastColor]);
            }
        }

        System.out.println(result);
    }
}
