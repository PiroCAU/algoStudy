package pro.p181188.wldy4627;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] targets = new int[][]{{4,5},{4,8}, {10,14},{11, 13}, {5, 12}, {3, 7}, {1, 4}};
        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        Arrays.sort(targets, (a1, a2) -> {
            return a1[1] - a2[1];
        });

        int answer = 0;
        int lastTarget = -1;
        for (int[] target : targets) {
            if (target[0] < lastTarget) {
                continue;
            } else {
                lastTarget = target[1];
                answer++;
            }
        }

        return answer;
    }
}
