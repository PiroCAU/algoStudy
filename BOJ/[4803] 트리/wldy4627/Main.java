package boj.b4803.wldy4627;

import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> adj;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> ans = new ArrayList<>();
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) {
                break;
            }

            adj = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                adj.put(i, new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                adj.get(a).add(b);
                adj.get(b).add(a);
            }

            int treeCnt = 0;
            visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (dfs(i, 0)) {
                        treeCnt++;
                    }
                }
            }

            ans.add(treeCnt);
        }

        for (int i = 1; i <= ans.size(); i++) {
            if (ans.get(i - 1) == 0) {
                System.out.println("Case " + i + ": No trees.");
            } else if (ans.get(i - 1) == 1) {
                System.out.println("Case " + i + ": There is one tree.");
            } else {
                System.out.println("Case " + i + ": A forest of " + ans.get(i - 1) + " trees.");
            }
        }
    }

    static boolean dfs(int cur, int parent) {
        visited[cur] = true;
        for (int next : adj.get(cur)) {
            if (!visited[next]) {
                if (!dfs(next, cur)) return false;
            } else if (next != parent) {
                return false;
            }
        }
        return true;
    }
}
