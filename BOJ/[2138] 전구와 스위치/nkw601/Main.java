import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] start, target;

    static void toggle(char[] arr, int i) {
        if (i < 0 || i >= N)
            return;
        arr[i] = (arr[i] == '0') ? '1' : '0';
    }

    static int test(boolean pressFirst) {
        char[] cur = start.clone();
        int cnt = 0;

        if (pressFirst) {
            cnt++;
            toggle(cur, 0);
            toggle(cur, 1);
        }
        // i 스위치를 눌러서 i-1을 확인
        for (int i = 1; i < N; i++) {
            if (cur[i - 1] != target[i - 1]) {
                cnt++;
                toggle(cur, i - 1);
                toggle(cur, i);
                toggle(cur, i + 1);
            }
        }
        for (int i = 0; i < N; i++) {
            if (cur[i] != target[i])
                return Integer.MAX_VALUE;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        start = br.readLine().trim().toCharArray();
        target = br.readLine().trim().toCharArray();

        int a = test(false); // 0번 안 누름
        int b = test(true); // 0번 누름
        int ans = Math.min(a, b);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
