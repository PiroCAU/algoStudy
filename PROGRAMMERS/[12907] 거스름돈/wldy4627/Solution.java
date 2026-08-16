package pro.p12907.wldy4627;

import java.util.*;

class Solution {
	public int solution(int n, int[] money) {
		// dp[i] = i원을 만드는 가지 수
		int[] dp = new int[n + 1];

		dp[0] = 1;

		for (int coin : money) {
			for (int i = coin; i <= n; i++) {
				dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
			}
		}

		return dp[n];
	}
}
