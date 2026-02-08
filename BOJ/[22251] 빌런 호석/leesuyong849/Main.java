package BOJ_22251_빌런호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, P, X;
    static int[][] display = {{1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 0, 1}, //1
            {0, 1, 1, 1, 1, 1, 0}, //2
            {0, 1, 1, 1, 0, 1, 1}, //3
            {1, 0, 1, 1, 0, 0, 1}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {0, 1, 1, 0, 0, 0, 1}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}}; //9

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       //표시되는 수가 이 수 아래
        K = Integer.parseInt(st.nextToken());       //자리수
        P = Integer.parseInt(st.nextToken());       //최대 반전시킬 계획
        X = Integer.parseInt(st.nextToken());       //현제엘리베이터 위치

        int[] myNum;

        myNum = numToDigit(X);

        int check = check(myNum);
        System.out.println(check);
    }

    public static int check(int[] digit) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            if (ableReverse(i, digit)) cnt++;
        }

        return cnt;
    }

    public static boolean ableReverse(int target, int[] myNum) {
        int[] targetToDigit = numToDigit(target);
        int changeCal = 0;

        for (int i = 0; i < K; i++) {
            int form = myNum[i];
            int to = targetToDigit[i];
            if (form == to) continue;

            for (int j = 0; j < 7; j++) {
                if (display[form][j] != display[to][j]) changeCal++;
            }
        }
        return changeCal <= P;
    }

    public static int[] numToDigit(int x) {
        int[] result = new int[K];
        for (int i = K - 1; i >=0; i--) {
            result[i] = x % 10;
            x /= 10;
        }
        return result;
    }
}
