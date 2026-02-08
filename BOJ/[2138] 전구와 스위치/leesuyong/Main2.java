package BOJ_2138_전구와스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    static int N;
    static char[] map, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        map = new char[N];
        answer = new char[N];

        for (int i = 0; i < N; i++) {
            map[i] = s.charAt(i);
        }

        s = br.readLine();
        for (int i = 0; i < N; i++) {
            answer[i] = s.charAt(i);
        }

        int a = solution(map.clone(), 1, true);
        int b = solution(map.clone(), 1, false);

        int ans = Integer.MAX_VALUE;
        if (a != -1) ans = Math.min(ans, a);
        if (b != -1) ans = Math.min(ans, b);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static boolean check(char[] list) {
        for (int i = 0; i < N; i++) {
            if (list[i] != answer[i]) return false;
        }
        return true;
    }

    static int solution(char[] list, int idx, boolean first) {
        int cnt = 0;

        if (first) {
            click(list, 0);
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (list[i-1] != answer[i-1]) {
                click(list, i);
                cnt++;
            }
        }

        return check(list) ? cnt : -1;
    }

    static void click(char[] list, int idx) {
        change(list, idx - 1);
        change(list, idx);
        change(list, idx + 1);
    }

    static void change(char[] list, int idx) {
        if (idx < 0 || idx >= N) return;

        list[idx] = (list[idx] == '0') ? '1' : '0';
    }
}
