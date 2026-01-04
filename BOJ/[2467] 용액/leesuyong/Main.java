package BOJ_2467_용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int L = 0;
        int R = N - 1;
        int result = Integer.MAX_VALUE;
        int resultL = 0, resultR = 0;

        while (L < R) {
            int c = map[L] + map[R];

            if (Math.abs(c) < result) {
                resultL = L;
                resultR = R;
                result = Math.abs(c);
            }

            if (c < 0) L++;
            else R--;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map[resultL]).append(" ").append(map[resultR]);
        System.out.println(sb);
    }
}
