package boj.b15989.wldy4627;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int[] nums = new int[T];
        for (int i = 0; i < T; i++) {
            nums[i] = sc.nextInt();
        }

        int[][] dp = new int[10001][4];

        for (int i = 1; i <= 3; i++) {
            dp[0][i] = 1;  // 0을 만드는 방법은 1가지
        }

        for (int i = 1; i <= 10000; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i - j >= 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - j][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[nums[i]][3]);
        }
    }
}
