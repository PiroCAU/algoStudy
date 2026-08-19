package proj.p67259.wldy4627;

import java.util.*;

class Solution {
	static class Node {
		int x, y;
		int cost;   // 지금까지 든 비용
		int dir;    // 여기까지 들어온 방향 (동: 0, 서: 1, 남: 2, 북: 3)

		Node(int x, int y, int cost, int dir) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.dir = dir;
		}
	}

	public int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		int N = board.length;

		// [dir][x][y] 특정 방향(0:동, 1:서, 2:남, 3:북)으로 (x, y) 칸에 도달했을 때의 최소 비용
		int[][][] cost = new int[4][N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 4; k++) {
					cost[k][i][j] = Integer.MAX_VALUE;
				}
			}
		}
		cost[0][0][0] = 0;
		cost[2][0][0] = 0;

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0, 0, 0));
		queue.add(new Node(0, 0, 0, 2));

		// 동 서 남 북
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		while (!queue.isEmpty()) {
			Node curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				int nextDir = i;
				int nextCost = curr.cost;

				if (nx < N && ny < N && nx >= 0 && ny >= 0) {
					if (board[nx][ny] == 0) {
						if (curr.dir == nextDir) {
							// 직선 경로
							nextCost += 100;
						} else {
							nextCost += 600;
						}
					} else {
						continue;
					}
					if (nextCost < cost[nextDir][nx][ny]) {
						cost[nextDir][nx][ny] = nextCost;
						queue.add(new Node(nx, ny, nextCost, nextDir));
					}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			answer = Math.min(answer, cost[i][N-1][N-1]);
		}
		return answer;
	}
}
