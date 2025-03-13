package boj.b17779.wldy4627;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] place ;
    static int totalPeople = 0;
    static int min = Integer.MAX_VALUE;

    static void solution(int x, int y, int d1, int d2) {
        int[][] border = new int[N][N];

        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = 1;  // 1번 경계선
            border[x + d2 + i][y + d2 - i] = 1;  // 4번 경계선
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = 1;  // 2번 경계선
            border[x + d1 + i][y - d1 + i] = 1;  // 3번 경계선
        }

        int[] areaPeople = new int[5];

        // 1 구역 인구 수
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j] == 1) break;
                areaPeople[0] += place[i][j];
            }
        }
        // 2 구역 인구 수
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (border[i][j] == 1) break;
                areaPeople[1] += place[i][j];
            }
        }
        // 3 구역 인구 수
        for (int i = N - 1; i >= x + d1; i--) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j] == 1) break;
                areaPeople[2] += place[i][j];
            }
        }
        // 4 구역 인구 수
        for (int i = N - 1; i >= x + d2 + 1; i--) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (border[i][j] == 1) break;
                areaPeople[3] += place[i][j];
            }
        }
        // 5 구역 인구 수
        areaPeople[4] = totalPeople;
        for (int i = 0; i < 4; i++) {
            areaPeople[4] -= areaPeople[i];
        }

        Arrays.sort(areaPeople);

        min = Math.min(min, areaPeople[4] - areaPeople[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        place = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                place[i][j] = sc.nextInt();
                totalPeople += place[i][j];
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;

                        solution(x, y, d1, d2);
                    }
                }
            }
        }
        sc.close();

        System.out.println(min);
    }
}