package boj.b1446.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class ShortCut {
		int start;
		int end;
		int length;

		public ShortCut(int start, int end, int length) {
			this.start = start;
			this.end = end;
			this.length = length;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		ShortCut[] shortCuts = new ShortCut[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			shortCuts[i] = new ShortCut(start, end, length);
		}

		int[] dist = new int[D + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[0] = 0;

		for (int i = 0; i <= D; i++) {
			if (i > 0) {
				dist[i] = Math.min(dist[i], dist[i-1] + 1);
			}

			for (ShortCut shortCut : shortCuts) {
				if (shortCut.start == i && shortCut.end <= D) {
					dist[shortCut.end] = Math.min(dist[shortCut.end], dist[i] + shortCut.length);
				}
			}
		}

		System.out.println(dist[D]);
	}
}
