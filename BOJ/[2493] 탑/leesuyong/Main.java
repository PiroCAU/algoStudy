package BOJ_2493_탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] tower, result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        tower = new int[N];
        result = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            tower[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = new int[N];

        // 스택: (index, height) — 왼쪽 탑들 중 현재 기준으로 후보만 유지
        Deque<int[]> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int h = tower[i];

            // 현재 탑보다 작거나 같은 왼쪽 탑들은 전파 못하므로 제거
            while (!stack.isEmpty() && stack.peekLast()[1] <= h) {
                stack.pollLast();
            }

            // 스택의 top이 곧 왼쪽에서 처음 만나는 더 높은 탑
            if (!stack.isEmpty()) {
                ans[i] = stack.peekLast()[0] + 1; // 1-based
            } else {
                ans[i] = 0;
            }

            // 현재 탑을 후보로 추가
            stack.addLast(new int[]{i, h});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}
