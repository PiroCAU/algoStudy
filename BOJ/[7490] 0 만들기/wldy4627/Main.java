package boj.b7490.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[] ops;
    static StringBuilder out;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine().trim());
            ops = new char[N];
            out = new StringBuilder();

            dfs(1);

            ans.append(out);
            if (tc != T - 1) ans.append('\n');
        }

        System.out.print(ans.toString());
    }

    static void dfs(int idx) {
        if (idx == N) {
            if (isZero()) out.append(buildExpr()).append('\n');
            return;
        }

        ops[idx] = ' ';
        dfs(idx + 1);

        ops[idx] = '+';
        dfs(idx + 1);

        ops[idx] = '-';
        dfs(idx + 1);
    }

    static String buildExpr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i);
            if (i < N) sb.append(ops[i]);
        }
        return sb.toString();
    }

    // 공백 제거 -> +,-만 있는 식으로 만든 뒤 평가
    static boolean isZero() {
        String expr = buildExpr();

        StringBuilder noSpace = new StringBuilder();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (c != ' ') noSpace.append(c);
        }

        // + / - 파싱 평가
        long sum = 0;
        long num = 0;
        char sign = '+';

        for (int i = 0; i < noSpace.length(); i++) {
            char c = noSpace.charAt(i);

            if (c == '+' || c == '-') {
                sum += (sign == '+') ? num : -num;
                sign = c;
                num = 0;
            } else {
                num = num * 10 + (c - '0');
            }
        }
        sum += (sign == '+') ? num : -num;

        return sum == 0;
    }
}