package boj.b9655.wldy4627;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N < 4) {
            System.out.println((N % 2== 1) ? "SK" : "CY");
            return;
        }

        boolean[] dp = new boolean[N + 1];
        // ture: 상근, false: 창영
        dp[1] = true;
        dp[2] = false;
        dp[3] = true;
        for (int i = 4; i <= N; i++) {
            dp[i] = !(dp[i-1] && dp[i-3]);
        }

        System.out.println(dp[N] == true ? "SK" : "CY");
    }
}
