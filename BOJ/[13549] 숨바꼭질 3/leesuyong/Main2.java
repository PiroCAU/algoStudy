package BOJ_13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main2 {

    static int N, K;
    static boolean[] visited;
    static Deque<int[]> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        result = new ArrayDeque<>();
        visited = new boolean[100001];
        result.add(new int[]{N,0});

        while (!result.isEmpty()) {
            int[] poped = result.pop();
            int pop = poped[0];
            int popMap = poped[1];

            if (pop == K) {
                System.out.println(popMap);
                break;
            }

            int nextDouble = pop * 2;
            if (nextDouble < 100001 && !visited[nextDouble]) {
                result.offerFirst(new int[]{nextDouble, popMap});
                visited[nextDouble] = true;
            }

            int nextMinus = pop - 1;
            if (nextMinus >= 0 && !visited[nextMinus]) {
                result.add(new int[]{nextMinus, popMap+1});
                visited[nextMinus] = true;
            }

            int nextPlus = pop + 1;
            if (nextPlus < 100001 && !visited[nextPlus]) {
                result.add(new int[]{nextPlus, popMap + 1});
                visited[nextPlus] = true;
            }
        }
    }
}
