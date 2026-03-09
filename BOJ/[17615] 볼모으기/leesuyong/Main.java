package BOJ_17615_볼모으기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static String s;
    static int answer = Integer.MAX_VALUE;
    static int curCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = br.readLine();

        int totalR = 0;
        int totalB = 0;
        int leftR = 0;
        int leftB = 0;
        int rightR = 0;
        int rightB = 0;

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'R') leftR++;
            else break;
        }

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'B') leftB++;
            else break;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (s.charAt(i) == 'R') rightR++;
            else break;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (s.charAt(i) == 'B') rightB++;
            else break;
        }

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'R') totalR++;
            else totalB++;
        }

        curCnt = totalB - leftB;
        answer = Math.min(curCnt, answer);

        curCnt = totalR - leftR;
        answer = Math.min(curCnt, answer);
        curCnt = totalB - rightB;
        answer = Math.min(curCnt, answer);
        curCnt = totalR - rightR;
        answer = Math.min(curCnt, answer);


        System.out.println(answer);
    }
}
