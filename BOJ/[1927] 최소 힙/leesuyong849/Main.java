package BOJ_1927_최소힙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());

            if (a == 0) {
                if (!que.isEmpty()) sb.append(que.poll()).append('\n');
                else sb.append("0").append('\n');
            } else
                que.add(a);
        }

        System.out.println(sb);
    }
}
