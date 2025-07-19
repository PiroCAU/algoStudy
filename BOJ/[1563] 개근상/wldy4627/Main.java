package boj.b1563.wldy4627;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][][] dp = new int[N+1][2][3];

        dp[0][0][0] = 1;

        for (int day = 0; day < N; day++) {
            for (int late = 0; late <= 1; late++) {
                for (int absent = 0; absent <= 2; absent++) {
                    int cur = dp[day][late][absent];

                    if (cur == 0) continue;

                    // 오늘 출석
                    dp[day + 1][late][0] += cur;
                    dp[day + 1][late][0] %= 1000000;

                    // 오늘 지각 (총 지각 횟수는 1 이하)
                    if (late < 1) {
                        dp[day + 1][late + 1][0] += cur;
                        dp[day + 1][late + 1][0] %= 1000000;
                    }

                    // 오늘 결석 (연속 결석 2 이하)
                    if (absent < 2) {
                        dp[day + 1][late][absent + 1] += cur;
                        dp[day + 1][late][absent + 1] %= 1000000;
                    }
                }
            }
        }

        int result = 0;
        for (int late = 0; late <= 1; late++) {
            for (int absent = 0; absent <= 2; absent++) {
                result += dp[N][late][absent];
                result %= 1000000;
            }
        }
        System.out.println(result);

    }
}
