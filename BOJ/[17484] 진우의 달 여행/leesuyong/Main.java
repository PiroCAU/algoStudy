package BOJ_17484_진우의달여행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] resultMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        resultMap = new int[N][M][3];



        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(resultMap[i][j], Integer.MAX_VALUE);
            }
        }

        //첫번째 초기화
        for (int i = 0; i < M; i++) {
            resultMap[0][i][0] = map[0][i];
            resultMap[0][i][1] = map[0][i];
            resultMap[0][i][2] = map[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j > 0) resultMap[i][j][0] = Math.min(resultMap[i-1][j-1][1], resultMap[i-1][j-1][2]) + map[i][j];

                resultMap[i][j][1] = Math.min(resultMap[i-1][j][0], resultMap[i-1][j][2]) + map[i][j];

                if (j < M - 1) resultMap[i][j][2] =Math.min(resultMap[i-1][j+1][1], resultMap[i-1][j+1][0]) + map[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            answer = Math.min(Arrays.stream(resultMap[N - 1][i]).min().getAsInt(), answer);
        }

        System.out.println(answer);

    }
}
