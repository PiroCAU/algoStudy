package BOJ_1260_DFS와BFS;

import java.io.*;
import java.util.*;

public class Main {

    static int N, M, V;
    static ArrayList<Integer>[] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for (ArrayList<Integer> list : map) {
            if (list != null) Collections.sort(list);
        }

        dfs(V);
        bfs(V);
    }

    private static void dfs(int v) {
        StringBuilder sb = new StringBuilder();

        visited = new boolean[N + 1];
        dfs_sol(v, sb);
        System.out.println(sb);
    }

    private static void dfs_sol(int v, StringBuilder sb) {
        if (visited[v]) return;

        visited[v] = true;
        sb.append(v).append(" ");

        ArrayList<Integer> integers = map[v];
        for (Integer integer : integers) {
            dfs_sol(integer, sb);
        }
    }

    private static void bfs(int v) {
        StringBuilder sb = new StringBuilder();

        visited = new boolean[N + 1];
        bfs_sol(v, sb);
        System.out.println(sb);
    }

    private static void bfs_sol(int v, StringBuilder sb) {
        Deque<Integer> que = new ArrayDeque<>();
        que.add(v);

        while (!que.isEmpty()) {
            Integer pop = que.pop();
            if (visited[pop]) continue;

            visited[pop] = true;
            sb.append(pop).append(" ");
            ArrayList<Integer> integers = map[pop];
            for (Integer integer : integers) {
                que.add(integer);
            }
        }
    }
}
