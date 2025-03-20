import java.util.*;

class Main {
    public int solution(int alp, int cop, int[][] problems) {
        int max_alp = 0;
        int max_cop = 0;

        for (int[] problem : problems) {
            max_alp = Math.max(problem[0], max_alp);
            max_cop = Math.max(problem[1], max_cop);
        }

        // 현재 능력이 목표 능력을 초과할 경우 조정
        alp = Math.min(alp, max_alp);
        cop = Math.min(cop, max_cop);

        //DP 값을 저장할 곳을 만든다. 최대값은 MAX_VALUE로 초기화
        int[][] dp = new int[max_alp + 1][max_cop + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        //현재 내 상태는 비용이 0이다.
        dp[alp][cop] = 0;

        //DP 시작
        for (int i = alp; i <= max_alp; i++) {
            for (int j = cop; j <= max_cop; j++) {
                //그냥 공부한다.
                if (i + 1 <= max_alp) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                }
                if (j + 1 <= max_cop) {
                    dp[i][j + 1] = Math.min(dp[i][j+1], dp[i][j]+1);
                }

                //문제를 푸는 경우
                for (int[] problem : problems) {
                    int req_a = problem[0];
                    int req_c = problem[1];
                    int rwd_a = problem[2];
                    int rwd_c = problem[3];
                    int cost = problem[4];

                    //문제를 풀 능력이 있는가?
                    if (req_a <= i && req_c <= j) {

                        //문제를 풀게 됨으로서 가지게 된 능력치: 목표치의 범위를 넘어가지 않도록 min 함수 사용
                        int new_a = Math.min(max_alp, i + rwd_a);
                        int new_c = Math.min(max_cop, j + rwd_c);
                        //해당 능력치를 얻기 위해 사용된 cost를 비교한다.
                        dp[new_a][new_c] = Math.min(dp[new_a][new_c], dp[i][j] + cost);
                    }
                }
            }
        }
        return dp[max_alp][max_cop];
    }

}