class Solution {
    public int solution(int[] sticker) {
        int n = sticker.length;


        //예외처리
        if (n == 1) {
            return sticker[0];
        }
        if (n == 2) {
            return Math.max(sticker[0], sticker[1]);
        }

        int case1 = linearDP(sticker, 1, n - 1);

        int case2 = linearDP(sticker, 0, n - 2);

        return Math.max(case1, case2);
    }

    // start ~ end 구간에서 인접한 원소를 동시에 선택할 수 없을 때 최대 합
    private int linearDP(int[] sticker, int start, int end) {
        int len = end - start + 1;

        if (len == 1) {
            return sticker[start];
        }

        int[] dp = new int[len];
        dp[0] = sticker[start];
        dp[1] = Math.max(sticker[start], sticker[start + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[start + i]);
        }

        return dp[len - 1];
    }
}