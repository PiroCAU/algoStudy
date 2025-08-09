import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(int data) {
            this.data = data;
        }
    }

    static Node[] nodes;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = 1;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            // 종료 조건 0 0 
            if (n == 0 && m == 0) break;

            nodes = new Node[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a].children.add(nodes[b]);
                nodes[b].children.add(nodes[a]);
            }

            visited = new boolean[n + 1];
            int treeCnt = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    if (dfs(nodes[i], null)) treeCnt++;
                }
            }

            sb.append("Case ").append(test_case++).append(": ");
            if (treeCnt == 0) sb.append("No trees.");
            else if (treeCnt == 1) sb.append("There is one tree.");
            else sb.append("A forest of ").append(treeCnt).append(" trees.");
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    // DFS -> 사이클 있으면 false
    static boolean dfs(Node node, Node parent) {
        visited[node.data] = true;
        for (Node child : node.children) {
            if (!visited[child.data]) {
                if (!dfs(child, node)) return false;
            } else if (child != parent) {
                // 부모 아닌데 이미 방문 → 사이클
                return false;
            }
        }
        return true;
    }
}

// 입력
// 정점 간선
// m줄: 간선 정보

// 출력
// 0: No trees
// 1: There is one tree
// <=3: A forest of T trees

// 생각
// 노드 만들고
// int data, list children
// visited 만들어서 dfs, 개수 cnt
// 사이클 탐색 어케함??
// 검색했더니 만났는데 부모 아니면 사이클이래
// 부모는 사이클 아닌 이유
// 인접 목록 순회하면 당연히 부모가 보여서...