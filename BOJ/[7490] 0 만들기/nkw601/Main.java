import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static char[] ops; // 넣을 연산자

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            ops = new char[N - 1];

            dfs(0);
            // tc마다 왜 한줄을 더...
            sb.append('\n');
        }

        System.out.print(sb);
    }

    // gpt 찬스
    // 공백 -> + -> -로 넣으면 자동 사전순이래요
    static void dfs(int idx) {
        if (idx == N - 1) {
            String res = make();
            if (calc(res) == 0)
                sb.append(res).append('\n');
            return;
        }

        ops[idx] = ' ';
        dfs(idx + 1);

        ops[idx] = '+';
        dfs(idx + 1);

        ops[idx] = '-';
        dfs(idx + 1);
    }

    // 수식으로 만들기
    static String make() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i);
            if (i != N)
                sb.append(ops[i - 1]);
        }
        return sb.toString();
    }

    // 공백 없애고 계산하기
    static int calc(String res) {
        String s = res.replace(" ", "");

        int sum = 0;
        int sign = 1;
        int cur = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-') {
                sum += sign * cur;
                sign = (c == '+') ? 1 : -1;
                cur = 0;
            } else {
                cur = cur * 10 + (c - '0');
            }
        }

        sum += sign * cur;
        return sum;
    }
}
/*
 * // 입력
 * TC 수
 * N
 * 
 * // 출력
 * (acsii 순서) 결과가 0이 되는 모든 수식
 * 
 * // 생각
 * ? 1 ~ N까지 쓰고 사이에 + - 공백 넣고 붙여서 계산
 * 할 수 있는 경우의 수: 3개
 * 그냥 dfs로 냅다 돌리면 될듯
 */