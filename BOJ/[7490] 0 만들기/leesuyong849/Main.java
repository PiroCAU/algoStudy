package BOJ_7490_0만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char[] ops;
    static int N, C;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            C = Integer.parseInt(br.readLine());
            ops = new char[C - 1];
            solve(C);

            if (i != N - 1) sb.append('\n');
        }

        System.out.println(sb);
    }

    static void solve(int c) {

        dfs(0);
    }

    public static void dfs(int idx) {
        if (idx == C - 1) {
            if (evaluate() == 0) {
                sb.append(builder()).append('\n');
            }
            return;
        }

        //부호를 저장하고 다음 단계로 간다.
        ops[idx] = ' ';
        dfs(idx + 1);

        ops[idx] = '+';
        dfs(idx + 1);

        ops[idx] = '-';
        dfs(idx + 1);
    }

    public static String builder() {
        StringBuilder sbn = new StringBuilder();
        sbn.append("1");
        for (int i = 0; i < C - 1; i++) {
            sbn.append(ops[i]).append(i + 2);
        }
        return sbn.toString();
    }

    public static long evaluate() {
        long result = 0;
        long num = 1;
        int sign = 1;

        for (int i = 0; i < C - 1; i++) {
            char op = ops[i];
            int next = i + 2;

            if (op == ' ') {
                num = num * 10 + next;
            } else {
                //이전에 갱신된 부호와 값을 반영한다.
                result += sign * num;
                //다음 사이클을 위해 부호와 값을 반영한다.
                sign = (op == '+') ? 1 : -1;
                num = next;
            }
        }
        result += sign * num;
        return result;
    }
}
