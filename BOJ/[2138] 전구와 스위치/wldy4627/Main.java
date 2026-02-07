package boj.b2138.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] nowBulb = new int[N];
        String nowBulbStr = br.readLine();
        for (int i = 0; i < N; i++) {
            nowBulb[i] = nowBulbStr.charAt(i) - '0';
        }

        int[] wantedBulb = new int[N];
        String wantedBulbStr = br.readLine();
        for (int i = 0; i < N; i++) {
            wantedBulb[i] = wantedBulbStr.charAt(i) - '0';
        }

        if (N == 1) {
            if (Arrays.equals(nowBulb, wantedBulb)) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
            return;
        }

        // (i-1)번째 자릿수를 보고 스위치를 누를지 말지 결정
        int[] oneTemp = nowBulb.clone();
        // 1. 첫번째 자릿수 스위치를 눌렀을 경우
        swap(oneTemp, 0);
        int oneAns = 1;
        for (int i = 1; i < N; i++) {
            if (oneTemp[i-1] != wantedBulb[i-1]) {
                swap(oneTemp, i);
                oneAns++;
            }
        }
        if (!Arrays.equals(oneTemp, wantedBulb)) {
            oneAns = -1;
        }

        // 2. 첫번째 자릿수 스위치를 누르지 않았을 경우
        int[] twoTemp = nowBulb.clone();
        int twoAns = 0;
        for (int i = 1; i < N; i++) {
            if (twoTemp[i-1] != wantedBulb[i-1]) {
                swap(twoTemp, i);
                twoAns++;
            }
        }
        if (!Arrays.equals(twoTemp, wantedBulb)) {
            twoAns = -1;
        }

        if (oneAns == -1 && twoAns == -1) {
            System.out.println(-1);
        } else if (oneAns == -1 || twoAns == -1) {
            System.out.println(Math.max(oneAns, twoAns));
        } else {
            System.out.println(Math.min(oneAns, twoAns));
        }

    }

    static void swap(int[] arr, int idx) {
        arr[idx] ^= 1;
        if (idx == 0) {     // i, i+1번째 바꿈
            arr[idx + 1] ^= 1;
        } else if (idx == N - 1) {      // i-1, i번째 바꿈
            arr[idx - 1] ^= 1;
        } else {    // i-1, i, i+1번째 바꿈
            arr[idx - 1] ^= 1;
            arr[idx + 1] ^= 1;
        }
    }
}