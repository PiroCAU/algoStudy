package boj.b1260.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		sb = new StringBuilder();
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println(sb);

		sb = new StringBuilder();
		visited = new boolean[N + 1];
		bfs(V);
		System.out.println(sb);
	}

	static void dfs(int s) {
		visited[s] = true;
		sb.append(s).append(" ");

		for (int n : graph[s]) {
			if (!visited[n]) {
				dfs(n);
			}
		}
	}

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;


		while (!q.isEmpty()) {
			int v = q.poll();
			sb.append(v).append(" ");

			for (int n : graph[v]) {
				if (!visited[n]) {
					visited[n] = true;
					q.add(n);
				}
			}
		}
	}
}