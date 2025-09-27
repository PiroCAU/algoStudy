package BOJ_15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());

        for (int a = 0; a < N; a++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[10001][4];        //[dp의 총길이][더한 정수]

            map[0][1] = map[0][2] = map[0][3] = 0;
            map[1][1] = 1;
            map[1][1] = 1;
            map[2][1] = 1;
            map[2][2] = 1;
            map[3][1] = 1;
            map[3][1] = 1;
            map[3][2] = 1;
            map[3][3] = 1;

            for (int i = 4; i <= M; i++) {
                map[i][1] = map[i-1][1];
                map[i][2] = map[i-2][2] + map[i-2][1];
                map[i][3] = map[i-3][2] + map[i-3][1] + map[i - 3][3];
            }

            System.out.println(map[M][1] + map[M][2] + map[M][3]);
        }




    }
}
