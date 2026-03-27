package BOJ_1976_여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer>[] map;
    static int[] plan;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }
        plan = new int[M];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    map[i].add(j);
                }
            }
        }

        st  = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            plan[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 0; i < M - 1; i++) {
            int start = plan[i];
            int end = plan[i + 1];
            visited = new boolean[N];
            visited[start] = true;
            boolean dfs = dfs(start, end);

            if (!dfs) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    static boolean dfs(int start, int end) {
        if (start == end) {
            return true;
        }

        ArrayList<Integer> nexts = map[start];

        for (Integer next : nexts) {
            if (!visited[next]) {
                visited[next] = true;
                boolean dfs = dfs(next, end);

                if (dfs) return true;
            }
        }
        return false;
    }
}
