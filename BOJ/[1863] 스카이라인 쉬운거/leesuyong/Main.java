package BOJ_1863_스카이라인쉬운거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, W, H;
    static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        map = new TreeMap<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        W = Integer.MIN_VALUE;
        H = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a, b);

            W = Math.max(a, W);
            H = Math.max(b, H);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for (int h : map.values()) {

            while (!stack.isEmpty() && stack.peekLast() > h) {
                int top = stack.pollLast();
                if (top != 0) result++;
            }

            // 같은 높이면 넣지 않음
            if (stack.isEmpty() || stack.peekLast() < h) {
                stack.addLast(h);
            }
        }

        // 남아있는 높이들도 닫힘 처리
        while (!stack.isEmpty()) {
            int top = stack.pollLast();
            if (top != 0) result++;
        }

        System.out.println(result);
    }
}
