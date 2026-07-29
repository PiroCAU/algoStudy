package pro.p42861.wldy4627;
import java.util.*;

class Solution {
	int[] parent;

	int find(int x) {
		if (parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			parent[rootY] = rootX;
		}
	}

	public int solution(int n, int[][] costs) {
		int answer = 0;
		int count = 0;

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		// 오름차순으로 정렬
		Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

		for (int[] edge : costs) {
			int from = edge[0];
			int to = edge[1];
			int cost = edge[2];

			if (find(from) != find(to)) {
				union(from, to);
				answer += cost;
				count++;

				if (count == n-1) break;
			}
		}

		return answer;
	}
}