package BOJ_15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_error {

    static int[] map;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            map = new int[M + 1];

            dp(0, 0);
            System.out.println(map[M]);
        }
    }

    private static void dp(int num, int added) {
        if (num > M) {
            return;
        } else if (num == M) {
            map[M]++;
            return;
        }

        map[num]++;
        if (added == 0 || added == 3) {
            dp(num+1, 1);
            dp(num+2, 2);
            dp(num+3, 3);
        } else if (added == 2) {
            dp(num+1, 1);
            dp(num+2, 2);
        } else if (added == 1) {
            dp(num + 1, 1);
        }
    }
}
