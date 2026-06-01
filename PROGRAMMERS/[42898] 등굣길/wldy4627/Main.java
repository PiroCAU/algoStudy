import java.util.*;

class Solution {
	public int solution(int m, int n, int[][] puddles) {

		boolean[][] map = new boolean[m + 1][n + 1];
		for (int[] p : puddles) {
			map[p[0]][p[1]] = true;
		}

		int[][] dp = new int[m + 1][n + 1];
		dp[1][1] = 1;

		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= m; x++) {
				if (map[x][y]) {
					dp[x][y] = 0;
					continue;
				}

				if (x == 1 && y == 1) continue;

				dp[x][y] = (dp[x - 1][y] + dp[x][y - 1]) % 1000000007;
			}
		}

		return dp[m][n];
	}
}