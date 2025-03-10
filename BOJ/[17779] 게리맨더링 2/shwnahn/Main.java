package src.week4.게리맨더링2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] grid;
    static int totalPeople;
    static int min = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // (1) 입력
        N = Integer.parseInt(st.nextToken());
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                totalPeople += grid[i][j];
            }
        }

        // (2) 문제 풀이
        // x, y, d1, d2 값 지정하며 반복
        for (int x = 0; x < N - 2; x++) {
            for (int y = 0; y < N - 1; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;

                        count(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(min);

    }

    public static void count(int x, int y, int d1, int d2) {
        // 1. 경계선 지정
        boolean[][] border = new boolean[N][N];

        // 경계선 4개 설정
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true; // 1번 경계선
            border[x + d2 + i][y + d2 - i] = true; // 4번 경계선
        }
        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true; // 2번 경계선
            border[x + d1 + i][y - d1 + i] = true; // 3번 경계선
        }

        // 2. 경계선 마주칠때까지 인구 더하기
        int[] peopleSum = new int[5];
        // 1구역
        for (int r = 0; r < x + d1; r++) {
            for (int c = 0; c <= y; c++) {
                if (border[r][c]) break;
                peopleSum[0] += grid[r][c];
            }
        }

        // 2구역
        for (int r = 0; r <= x + d2; r++) {
            for (int c = N - 1; c > y; c--) {
                if (border[r][c]) break;
                peopleSum[1] += grid[r][c];
            }
        }

        // 3구역
        for (int r = x + d1; r < N; r++) {
            for (int c = 0; c < y - d1 + d2; c++) {
                if (border[r][c]) break;
                peopleSum[2] += grid[r][c];
            }
        }
        // 4구역
        for (int r = x + d2 + 1; r < N; r++) {
            for (int c = N - 1; c >= y - d1 + d2; c--) {
                if (border[r][c]) break;
                peopleSum[3] += grid[r][c];
            }
        }

        // 5구역
        peopleSum[4] = totalPeople;
        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }

        // 최소값 비교하기
        Arrays.sort(peopleSum);
        min = Math.min(min, peopleSum[4] - peopleSum[0]);
    }
}
