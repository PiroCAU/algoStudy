import java.io.*;
import java.util.*;

public class Main {
    static int N, K, P, X;
    static int[] xDigits;
    static int[][] cost = new int[10][10];
    static int answer = 0;

    static int[][] numbers = {
            { 1, 1, 1, 1, 1, 1, 0 }, // 0
            { 0, 1, 1, 0, 0, 0, 0 }, // 1
            { 1, 1, 0, 1, 1, 0, 1 }, // 2
            { 1, 1, 1, 1, 0, 0, 1 }, // 3
            { 0, 1, 1, 0, 0, 1, 1 }, // 4
            { 1, 0, 1, 1, 0, 1, 1 }, // 5
            { 1, 0, 1, 1, 1, 1, 1 }, // 6
            { 1, 1, 1, 0, 0, 0, 0 }, // 7
            { 1, 1, 1, 1, 1, 1, 1 }, // 8
            { 1, 1, 1, 1, 0, 1, 1 } // 9
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 0 ~ 9 바꾸는데 필요한 비용 계산
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int cnt = 0;
                for (int k = 0; k < 7; k++) {
                    if (numbers[i][k] != numbers[j][k])
                        cnt++;
                }
                cost[i][j] = cnt;
            }
        }

        // 숫자 바꾸기
        xDigits = toDigits(X);

        // dfs
        // 앞부터 바꾸기: 지금 바꾸는 자리, 지금까지 바꾼 값, 숫자
        dfs(0, 0, 0);

        System.out.println(answer);
    }

    static int[] toDigits(int num) {
        int[] d = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            d[i] = num % 10;
            num /= 10;
        }
        return d;
    }

    static void dfs(int idx, int used, int value) {
        if (used > P)
            return;

        if (idx == K) {
            if (value >= 1 && value <= N && value != X)
                answer++;
            return;
        }

        for (int d = 0; d <= 9; d++) {
            dfs(idx + 1, used + cost[xDigits[idx]][d], value * 10 + d);
        }
    }
}
