package BOJ_1806_부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        if (map[0] >= S) {
            System.out.println(1);
            return;
        } else if (N == 1) {
            System.out.println(0);
            return;
        }

        int min = Integer.MAX_VALUE;
        int curCnt = 2;
        int curSum = map[0] + map[1];
        int left = 0;
        int right = 1;

        while (right < N) {
            if (curSum >= S) {
                curSum -= map[left];
                left++;
                curCnt--;

                if (curSum >= S) {
                    min = Math.min(min, curCnt);
                }
            } else if (curSum < S) {
                right++;
                if (right >= N) break;
                curSum += map[right];
                curCnt++;

                if (curSum >= S) {
                    min = Math.min(min, curCnt);
                }
            }
        }

        if (min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);
    }
}
