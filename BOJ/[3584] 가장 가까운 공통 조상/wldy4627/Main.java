package boj.b3584.wldy4627;

import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            parent = new int[N + 1];
            visited = new boolean[N + 1];

            for (int j = 0; j < N - 1; j++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                parent[B] = A;  // A가 B의 부모
            }
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            while (node1 > 0) {
                visited[node1] = true;
                node1 = parent[node1];
            }
            while (node2 > 0) {
                if (visited[node2]) {
                    System.out.println(node2);
                    break;
                }
                node2 = parent[node2];
            }
        }
    }
}
