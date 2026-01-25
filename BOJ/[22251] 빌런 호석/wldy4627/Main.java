package boj.b22251.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.StringTokenizer;

public class Main {
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] mask = new int[10];

        mask[0] = 0b0111111; // 0
        mask[1] = 0b0000110; // 1
        mask[2] = 0b1011011; // 2
        mask[3] = 0b1001111; // 3
        mask[4] = 0b1100110; // 4
        mask[5] = 0b1101101; // 5
        mask[6] = 0b1111101; // 6
        mask[7] = 0b0000111; // 7
        mask[8] = 0b1111111; // 8
        mask[9] = 0b1101111; // 9

        // diff[i][j]: i -> j 되는데 반전시키는 LED 개수
        int[][] diff = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                diff[i][j] = Integer.bitCount(mask[i] ^ mask[j]);
            }
        }

        int[] xDigit = toDigits(X);
        int ans = 0;
        for (int y = 1; y <= N; y++) {
            if (y == X) continue;

            int[] yDigits = toDigits(y);

            int cost = 0;
            for (int i = 0; i < K; i++) {
                cost += diff[xDigit[i]][yDigits[i]];
                if (cost > P) break;
            }

            if (cost <= P) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    static int[] toDigits(int n) {
        int[] digits = new int[K];
        for (int i = 0; i < K; i++) {
            digits[i] = n % 10;
            n /= 10;
        }
        return digits;
    }
}
