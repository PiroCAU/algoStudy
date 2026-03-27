package BOJ_15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int T, N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        map = new int[10001][4];

        for(int t = 0; t<T; t++)
        {
            N = Integer.parseInt(br.readLine());
            map[1][1] = map[2][1] = map[2][2] = map[3][1] = map[3][2] = map[3][3] = 1;
            for(int i=4; i<=N; i++)  {
                map[i][1] = map[i-1][1];
                map[i][2] = map[i-2][1] + map[i-2][2];
                map[i][3] = map[i-3][1] + map[i-3][2] + map[i-3][3];
            }
            sb.append(map[N][3]+map[N][2]+map[N][1]+"\n");
        }
        System.out.println(sb);
    }
}
