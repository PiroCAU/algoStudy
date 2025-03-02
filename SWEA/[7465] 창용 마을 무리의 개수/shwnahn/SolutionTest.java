package shwnahn.창용마을;

import java.util.ArrayList;
import java.util.Scanner;

public class SolutionTest {
    // 각 테스트케이스마다 사용할 인접 리스트와 방문 배열
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            // (1) 입력값으로 graph를 먼저 만든다.
            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            // (2) 이를 바탕으로 dfs 를 시행한다. visited가 false일때만.
            // 초기화
            visited = new boolean[N+1];
            // (3) 새로 시행한 dfs 회수만큼 무리가 있다고 볼 수 있음.
            int groupCount = 0;

            // 모든 사람 대상으로 dfs 수행
            for (int i = 0; i <= N; i++) {
                if (!visited[i]) {
                    groupCount++;
                    dfs(i);
                }
            }

            System.out.println("#" + test_case + " " + groupCount);
        }

    }

    static void dfs(int node) {
        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            // 아직 방문 안했으면 재귀적으로 dfs
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

}
// 어떻게 해결할까? // set 을 각각 만들고, 그룹과 비교. 겹치면 해당 세트에 넣고 안 겹치면 새로 세트 만들기?
// => 깊이 우선 탐색...!
// (1) 입력값으로 graph를 먼저 만든다.
// (2) 이를 바탕으로 dfs 를 시행한다. visited가 false일때만.
// (3) 새로 시행한 dfs 회수만큼 무리가 있다고 볼 수 있음.