package boj.b14940.wldy4627;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int targetX = 0;
		int targetY = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2) {
					targetX = i;
					targetY = j;
				}
			}
		}

		int[][] dist = new int[n][m];
		dist[targetX][targetY] = 0;

		int[] dx = new int[] { -1, 0, 1, 0 };
		int[] dy = new int[] { 0, 1, 0, -1 };
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		visited[targetX][targetY] = true;

		q.add(new int[] { targetX, targetY });
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currX = curr[0];
			int currY = curr[1];

			for (int i = 0; i < 4; i++) {
				int nx = currX + dx[i];
				int ny = currY + dy[i];

				if (nx < n && ny < m && nx >= 0 && ny >= 0
					&& map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					dist[nx][ny] = dist[currX][currY] + 1;
					q.add(new int[] { nx, ny });
				}
			}
		}

		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					if (visited[i][j] == false) {
						sb.append(-1 + " ");
					} else {
						sb.append(dist[i][j] + " ");
					}
				} else {
					sb.append(0 + " ");
				}
			}
			System.out.println(sb.toString());
		}
	}
}
