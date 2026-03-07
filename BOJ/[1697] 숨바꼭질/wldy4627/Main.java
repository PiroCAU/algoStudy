package boj.b1697.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[100001];
		int[] dist = new int[100001];
		Queue<Integer> q = new LinkedList<>();

		q.add(N);
		dist[N] = 0;
		visited[N] = true;
		while (true) {
			int now = q.poll();

			if (now == K) break;

			// 1. 걷기 (+1)
			if (now + 1 < 100001 && !visited[now + 1]) {
				dist[now + 1] = dist[now] + 1;
				visited[now + 1] = true;
				q.add(now + 1);
			}
			// 2. 걷기 (-1)
			if (now - 1 >= 0 && !visited[now - 1]) {
				dist[now - 1] = dist[now] + 1;
				visited[now - 1] = true;
				q.add(now - 1);
			}
			// 3. 순간이동 (*2)
			if (now * 2 < 100001 && !visited[now * 2]) {
				dist[now * 2] = dist[now] + 1;
				visited[now * 2] = true;
				q.add(now * 2);
			}
		}

		System.out.println(dist[K]);
	}
}
