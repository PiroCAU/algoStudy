package pro.p172927.wldy4627;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int pickCnt = picks[0] + picks[1] + picks[2];
        int limit = Math.min(pickCnt * 5, minerals.length);

        List<int[]> mineralList = new ArrayList<>();
        for (int i = 0; i < limit; i += 5) {
            int[] mineral = new int[3];
            for (int j = i; j < i + 5 && j < limit; j++) {
                if (minerals[j].equals("diamond")) {
                    mineral[0] += 1;
                    mineral[1] += 5;
                    mineral[2] += 25;
                } else if (minerals[j].equals("iron")) {
                    mineral[0] += 1;
                    mineral[1] += 1;
                    mineral[2] += 5;
                } else {
                    mineral[0] += 1;
                    mineral[1] += 1;
                    mineral[2] += 1;
                }
            }
            mineralList.add(mineral);
        }

        mineralList.sort((a, b) -> b[2] - a[2]);

        for (int[] mineral : mineralList) {
            if (picks[0] > 0) {
                answer += mineral[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += mineral[1];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += mineral[2];
                picks[2]--;
            } else {
                break;
            }
        }

        return answer;
    }
}
