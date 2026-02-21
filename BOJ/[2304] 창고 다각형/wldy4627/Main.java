package boj.b2304.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[1001];

        int firstIndex = 1001;
        int lastIndex = 0;
        int maxIndex = 0;
        int maxHeight = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            height[L] = R;
            maxHeight = Math.max(maxHeight, R);
            if (maxHeight == R) {
                maxIndex = L;
            }

            firstIndex = Math.min(firstIndex, L);
            lastIndex = Math.max(lastIndex, L);
        }

        int area = 0;
        int ny = 0;
        for (int i = firstIndex; i <= maxIndex; i++) {
            if (height[i] != 0 && ny <= height[i]) {
                ny = height[i];
            }
            // 가로 * 세로
            area += ny;
        }
        ny = 0;
        for (int i = lastIndex; i > maxIndex; i--) {
            if (height[i] != 0 && ny <= height[i]) {
                ny = height[i];
            }
            area += ny;
        }

        System.out.println(area);
    }
}
