package src.week5.코딩테스트공부;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        ArrayList<int[]> probList = new ArrayList<>();
        probList.addAll(Arrays.asList(problems));
//        int maxAlpReq = 0;
//        int maxCopReq = 0;
        int maxAlpReq = alp;
        int maxCopReq = cop;
        for (int[] problem : problems) {
            if (problem[0] >= maxAlpReq) maxAlpReq = problem[0];
            if (problem[1] >= maxCopReq) maxCopReq = problem[1];
            if (problem[2] == 0 && problem[3] == 0) probList.remove(problem);
        }

        // 이미 모든 문제를 풀 수 있는 경우
        if (alp >= maxAlpReq && cop >= maxCopReq) return 0;
//        if (alp >= maxAlpReq) alp = maxAlpReq;
//        if (cop >= maxCopReq) cop = maxCopReq;

        probList.add(new int[]{0, 0, 1, 0, 1}); // 알고리즘 공부
        probList.add(new int[]{0, 0, 0, 1, 1}); // 코딩 공부
        System.out.println(Arrays.deepToString(probList.toArray()));

        int[][] DP = new int[maxAlpReq + 1][maxCopReq + 1];
        for (int i = 0; i <= maxAlpReq; i++) {
            Arrays.fill(DP[i], Integer.MAX_VALUE);
        }
        DP[alp][cop] = 0; // 시작점

        for (int i = alp; i <= maxAlpReq; i++) {
            for (int j = cop; j <= maxCopReq; j++) {
                if (DP[i][j] == Integer.MAX_VALUE) continue;
                for (int[] problem : probList) {
                    int alpReq = problem[0];
                    int copReq = problem[1];
                    int alpRwd = problem[2];
                    int copRwd = problem[3];
                    int cost = problem[4];

                    if (i >= alpReq && j >= copReq) { // 문제를 풀 수 있으면
                        int newAlp = Math.min(i + alpRwd, maxAlpReq);
                        int newCop = Math.min(j + copRwd, maxCopReq);

                        if (DP[i][j] + cost < DP[newAlp][newCop]) {
                            DP[newAlp][newCop] = DP[i][j] + cost;
                        }
                        // 비교: 원래의 DP vs. 문제 풀고 시간이 늘어난 DP
                    }
                }
            }
        }

        return DP[maxAlpReq][maxCopReq];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int alp = 10;
        int cop = 1;
        int[][] problems = {{1, 1, 1, 1, 1}, {5, 5, 1, 1, 3}};
        int result = sol.solution(alp, cop, problems); // 예상 result: 80
        System.out.println("결과: " + result);
    }
}