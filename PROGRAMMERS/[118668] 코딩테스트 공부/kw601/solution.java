import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        // DP...?
        // 최소 시간... 최단경로

        int max_alp = 0, max_cop = 0;
        for (int[] problem : problems) {
            max_alp = Math.max(max_alp, problem[0]);
            max_cop = Math.max(max_cop, problem[1]);
        }

        // 내가 지금 모든 문제를 풀 수 있다면...을 방지
        alp = Math.min(alp, max_alp);
        cop = Math.min(cop, max_cop);

        // 초기 dp 설정, 초기화
        int INF = Integer.MAX_VALUE;
        int[][] dp = new int[max_alp + 1][max_cop + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[alp][cop] = 0; // 지금 상태에서 시작 -> 시간 0

        for (int i = alp; i <= max_alp; i++) {
            for (int j = cop; j <= max_cop; j++) {
                // 1. 가능하면 문제 풀기
                for (int[] problem : problems) {
                    int alp_req = problem[0], cop_req = problem[1];
                    int alp_rwd = problem[2], cop_rwd = problem[3], cost = problem[4];

                    // 문제 풀 수 있으면
                    if (i >= alp_req && j >= cop_req) {
                        // 가장 높은 만큼만 하면되고, 그 높은 곳의 시간을 비교해야하므로 min처리
                        int new_alp = Math.min(max_alp, i + alp_rwd);
                        int new_cop = Math.min(max_cop, j + cop_rwd);
                        // min 하는 이유: 최소시간만
                        dp[new_alp][new_cop] = Math.min(dp[new_alp][new_cop], dp[i][j] + cost);
                    }
                }

                // 2-1. 알고력 높이기
                if (i + 1 <= max_alp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                // 2-2. 코딩력 높이기
                if (j + 1 <= max_cop) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }
            }
        }

        return dp[max_alp][max_cop];
    }
}