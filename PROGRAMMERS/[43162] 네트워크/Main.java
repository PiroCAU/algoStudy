package PRO_43162_네트워크;

import java.util.ArrayList;

public class Main {
}

class Solution {

    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];


        int length = computers.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            result++;
            bfs(i, n, computers);
        }

        return result;
    }

    public void bfs(int x, int n, int[][] computers) {
        visited[x] = true;

        for (int i = 0; i < n; i++) {
            if (computers[x][i] == 1 && !visited[i]) {
                bfs(i, n, computers);
            }
        }
    }
}

