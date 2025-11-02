package BOJ_10431_줄세우기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][20];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            String s = st.nextToken();
            int cnt = 0;

            for (int j = 0; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                int cur = j;

                while (true) {
                    if (cur - 1 < 0) break;
                    if (map[i][cur - 1] < map[i][cur]) break;

                    int temp = map[i][cur - 1];
                    map[i][cur - 1] = map[i][cur];
                    map[i][cur] = temp;
                    cnt++;
                    cur--;
                }
            }
            sb.append(i + 1).append(" ").append(cnt).append('\n');
        }

        System.out.println(sb.toString());
    }
}
