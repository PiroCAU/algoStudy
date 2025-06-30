package pro.p2156.wldy4627;

import java.util.Scanner;

public class Main {
    static int[] grape;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        grape = new int[n];
        for (int i = 0; i < n; i++) {
            grape[i] = sc.nextInt();
        }

        dp = new int[n];

        if (n == 1) {
            System.out.println(grape[0]);
            return;
        } else if (n == 2) {
            System.out.println(grape[0] + grape[1]);
            return;
        }
        dp[0] = grape[0];
        dp[1] = grape[0] + grape[1];
        dp[2] = max(dp[1], dp[0] + grape[2], grape[1] + grape[2]);

        for (int i = 3; i < n; i++) {
            dp[i] = max(dp[i-1], dp[i-2] + grape[i], dp[i-3] + grape[i] + grape[i-1]);
        }

        System.out.println(dp[n-1]);
    }

    private static int max(int a, int b, int c) {
        int max = Math.max(a, b);
        int realMax = Math.max(max, c);

        return realMax;
    }
}
