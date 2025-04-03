package boj.b1932.wldy4627;

import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] numbers;
    public static Integer[][] sumDp;

    public static int dp(int x, int y) {
        if (x == n - 1) return numbers[x][y];

        if (sumDp[x][y] == null) {
            sumDp[x][y] = Math.max(dp(x + 1, y), dp(x + 1, y + 1)) + numbers[x][y];
        }

        return sumDp[x][y];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        numbers = new int[n][n];
        sumDp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                numbers[i][j] = sc.nextInt();
            }
        }

        int result = dp(0, 0);
        System.out.println(result);
    }
}
