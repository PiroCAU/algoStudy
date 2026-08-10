package PRO_42861_섬연결하기;

import java.util.ArrayList;
import java.util.Arrays;


class Solution {

    int[] parent;

    int findParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if (px != py) parent[px] = py;
    }

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int answer = 0;
        for (int[] cost : costs) {
            int x = cost[0];
            int y = cost[1];
            int w = cost[2];

            if (findParent(x) != findParent(y)) {
                union(x, y);
                answer += w;
            }
        }

        return answer;
    }
}