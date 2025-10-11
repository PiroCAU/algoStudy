package boj.b12919.wldy4627;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        solve(S, T);
        System.out.println(answer);
        return;
    }

    static void solve(String S, String T) {
        if (answer == 1) return;

        if (S.length() == T.length()) {
            if (S.equals(T)) {
                answer = 1;
            }
            return;
        }

        if (T.charAt(T.length() - 1) == 'A') {
            solve(S, T.substring(0, T.length() - 1));
        }

        if (T.charAt(0) == 'B') {
            String str = T.substring(1);
            StringBuffer sb = new StringBuffer(str);
            String str2 = sb.reverse().toString();
            solve(S, str2);
        }
    }
}
