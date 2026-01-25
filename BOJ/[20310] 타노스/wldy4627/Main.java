package boj.b20310.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        char[] str = new char[S.length()];

        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < str.length; i++) {
            str[i] = S.charAt(i);
            if (str[i] == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }

        int removeCnt = 0;
        for (int i = 0; i < str.length; i++) {
            if (removeCnt == oneCnt / 2) break;

            if (str[i] == '1') {
                removeCnt++;
                str[i] = '2';
            }
        }
        removeCnt = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            if (removeCnt == zeroCnt / 2) break;

            if (str[i] == '0') {
                removeCnt++;
                str[i] = '2';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '0' || str[i] == '1') {
                sb.append(str[i]);
            }
        }

        System.out.println(sb.toString());
    }
}
