class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;

        long[] dp1 = new long[n]; // [1, -1, 1, ...]
        long[] dp2 = new long[n]; // [-1, 1, -1, ...]

        dp1[0] = sequence[0];
        dp2[0] = -sequence[0];

        long answer = Math.max(dp1[0], dp2[0]);

        for (int i = 1; i < n; i++) {

            int pulse = (i % 2 == 0) ? 1 : -1;

            dp1[i] = Math.max((long) sequence[i] * pulse,
                    dp1[i - 1] + (long) sequence[i] * pulse);

            dp2[i] = Math.max((long) sequence[i] * -pulse,
                    dp2[i - 1] + (long) sequence[i] * -pulse);

            answer = Math.max(answer, Math.max(dp1[i], dp2[i]));

        }

        return answer;
    }
}
// 연속펄스부분수열...
// LIS 그건가
// 아 아니어따...
// 글면 얘는 dp이겟군
// dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);