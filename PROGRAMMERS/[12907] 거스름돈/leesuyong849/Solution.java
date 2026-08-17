package BOJ_12907_거스름돈;

public class Solution {

    public int solution(int n, int[] money) {
        final int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int coin : money) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % MOD;
            }
        }
        return (int) dp[n];
    }

}

