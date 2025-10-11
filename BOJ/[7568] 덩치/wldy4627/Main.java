package boj.b7568.wldy4627;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] student = new int[N][2];
        for (int i = 0; i < N; i++) {
            student[i][0] = sc.nextInt();
            student[i][1] = sc.nextInt();
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (student[j][0] > student[i][0] && student[j][1] > student[i][1]) {
                    rank++;
                }
            }
            result[i] = rank;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i] + " ");
        }

        System.out.println(sb.toString());
    }
}
