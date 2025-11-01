package boj.b10431.wldy4627;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt();
        int[][] heights = new int[P][20];
        for (int i = 0; i < P; i++) {
            int T = sc.nextInt();
            for (int j = 0; j < 20; j++) {
                heights[i][j] = sc.nextInt();
            }
        }

        int[] sortCnt = new int[P];
        for (int i = 0; i < P; i++) {
            int cnt = 0;
            List<Integer> sortedHeight = new ArrayList<>();
            sortedHeight.add(heights[i][0]);
            for (int j = 1; j < 20; j++) {
                int idx = Collections.binarySearch(sortedHeight, heights[i][j]);
                if (idx < 0) {
                   idx = -idx - 1;  // 삽입 위치
                }

                cnt += sortedHeight.size() - idx;
                sortedHeight.add(heights[i][j]);

                Collections.sort(sortedHeight);
            }
            sortCnt[i] = cnt;
        }

        for (int i = 0; i < P; i++) {
            System.out.println(i+1 + " " + sortCnt[i]);
        }
    }
}
