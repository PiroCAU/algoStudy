package boj.b1138.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] memory = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        int[] pos = new int[N];
        int pre = 0;
        int idx = 0;
        for (int i = 1; i <= N; i++) {
            pre = 0;
            idx = 0;
            while (true) {
                // 앞에 있는 숫자의 개수가 기억과 동일하다면
                if (pre == memory[i]) break;
                // 현재 위치가 0으로 비어있다면 pre+1 -> 앞에 pre+1개의 큰 수가 있음
                if (pos[idx] == 0) {
                    pre++;
                }
                // i 값이 들어갈 위치는 idx
                idx++;
            }
            while (pos[idx] != 0) {
                idx++;
            }
            pos[idx] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(pos[i] + " ");
        }
        System.out.println(sb);
    }
}
