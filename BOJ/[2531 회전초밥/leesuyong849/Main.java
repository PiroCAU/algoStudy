package BOJ_2531_회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 종류 수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) belt[i] = Integer.parseInt(br.readLine());

        int[] cnt = new int[d + 1]; // 초밥 번호 1..d
        int distinct = 0;

        // 초기 윈도우(0..k-1) 세팅 (원형이므로 %N)
        for (int i = 0; i < k; i++) {
            int sushi = belt[i % N];
            if (cnt[sushi] == 0) distinct++;
            cnt[sushi]++;
        }

        int best = distinct + (cnt[c] == 0 ? 1 : 0);

        // 윈도우를 한 칸씩 이동
        for (int start = 1; start < N; start++) {
            //하나 이동하면서 제거
            int out = belt[start - 1];
            cnt[out]--;
            if (cnt[out] == 0) distinct--;

            //새로운거 추가: 인덱스 나가지 않도록 %
            int in = belt[(start + k - 1) % N];
            if (cnt[in] == 0) distinct++;
            cnt[in]++;

            int current = distinct + (cnt[c] == 0 ? 1 : 0);
            if (current > best) best = current;
        }

        System.out.println(best);
    }
}
