package boj.b9465.wldy4627;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] answer = new int[T];

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            sc.nextLine();

            int[][] sticker = new int[2][n];

            for (int j = 0; j < 2; j++) {
                String line = sc.nextLine();
                String[] tokens = line.split(" ");
                for (int k = 0; k < n; k++) {
                    sticker[j][k] = Integer.parseInt(tokens[k]);
                }
            }

            int[][] dp = new int[2][n];

            if (n == 1) {
                answer[i] = Math.max(sticker[0][0], sticker[1][0]);
                continue;
            }

            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            dp[0][1] = dp[1][0] + sticker[0][1];
            dp[1][1] = dp[0][0] + sticker[1][1];

            for (int j = 2; j < n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + sticker[1][j];
            }

            answer[i] = Math.max(dp[0][n - 1], dp[1][n - 1]);
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }
}
