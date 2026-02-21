package boj.b4485.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int cost;

		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N;
		int[][] map;
		int idx = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) return;

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0, map[0][0]));
			int[][] dist = new int[N][N];
			for (int[] d : dist) {
				Arrays.fill(d, Integer.MAX_VALUE);
			}
			dist[0][0] = map[0][0];
			while (!pq.isEmpty()) {
				Node node = pq.poll();
				if (node.cost > dist[node.x][node.y]) continue;

				for (int i = 0; i < 4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						int newCost = node.cost + map[nx][ny];
						if (newCost < dist[nx][ny]) {
							dist[nx][ny] = newCost;
							pq.add(new Node(nx, ny, newCost));
						}
					}
				}
			}

			System.out.println("Problem " + idx++ + ": " + dist[N - 1][N - 1]);
		}
	}
}
