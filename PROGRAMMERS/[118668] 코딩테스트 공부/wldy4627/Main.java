import java.util.Arrays;

public class Main {
    public int solution(int alp, int cop, int[][] problems) {
        int maxAlp = alp;  // 문제를 푸는데 필요한 최대 알고력
        int maxCop = cop;  // 문제를 푸는데 필요한 최대 코딩력
        for (int[] problem : problems) {
            maxAlp = Math.max(maxAlp, problem[0]);
            maxCop = Math.max(maxCop, problem[1]);
        }
        if (alp >= maxAlp && cop >= maxCop) {
            // 만약 현재 알고력과 코딩력으로 문제를 풀 수 있다면 0 return
            return 0;
        }

        int[][] dp = new int[maxAlp + 1][maxCop + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dp[alp][cop] = 0;

        for (int i = alp; i < dp.length; i++) {
            for (int j = cop; j < dp[0].length; j++) {
                if (i + 1 <= maxAlp) {  // 공부해서 알고력 + 1
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if (j + 1 <= maxCop) {  // 공부해서 코딩력 + 1
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);
                }

                // 문제 풀기
                for (int[] problem : problems) {
                    if (i >= problem[0] && j >= problem[1]) {  // 문제를 풀 수 있다면
                        int nextAlp = Math.min(i + problem[2], maxAlp);
                        int nextCop = Math.min(j + problem[3], maxCop);

                        dp[nextAlp][nextCop] = Math.min(dp[nextAlp][nextCop], dp[i][j] + problem[4]);
                    }
                }
            }
        }
        return dp[maxAlp][maxCop];
    }
}
