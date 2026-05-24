class Solution {
    boolean[] visited;

    public int solution(int n, int[][] computers) {

        visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    void dfs(int node, int[][] computers) {
        visited[node] = true;

        for (int next = 0; next < computers.length; next++) {
            if (node != next && computers[node][next] == 1 && !visited[next]) {
                dfs(next, computers);
            }
        }
    }
}