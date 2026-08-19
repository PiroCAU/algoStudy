package proj.p132266.wldy4627;

import java.util.*;

/*
- BFS를 이용
- destination에서부터 부대원의 위치까지의 거리 찾기
*/

class Solution {
	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int[] answer = new int[sources.length];

		// roads -> graph (양방향 그래프)
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] road : roads) {
			int u = road[0];
			int v = road[1];

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(destination);

		int[] distance = new int[n + 1];
		Arrays.fill(distance, -1);

		boolean[] visited = new boolean[n + 1];
		visited[destination] = true;
		distance[destination] = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : graph.get(current)) {
				if (!visited[next]) {
					visited[next] = true;
					distance[next] = distance[current] + 1;
					queue.add(next);
				}
			}
		}

		for (int i = 0; i < sources.length; i++) {
			answer[i] = distance[sources[i]];
		}
		return answer;
	}
}