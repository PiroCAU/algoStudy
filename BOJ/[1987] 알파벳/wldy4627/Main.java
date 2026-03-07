package boj.b1987.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static char[][] map;
	static int[] dx = new int[]{-1, 0, 1, 0};
	static int[] dy = new int[]{0, -1, 0, 1};
	static boolean[] alphabet = new boolean[26];
	static int max = 1;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			map[i] = line.toCharArray();
		}

		alphabet[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(max);
	}

	static void dfs(int x, int y, int dist) {
		max = Math.max(max, dist);
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				if (!alphabet[map[nx][ny] - 'A']) {
					alphabet[map[nx][ny] - 'A'] = true;
					dfs(nx, ny, dist + 1);
					alphabet[map[nx][ny] - 'A'] = false;
				}
			}
		}
	}
}
