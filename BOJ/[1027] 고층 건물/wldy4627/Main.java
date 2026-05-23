package boj.b1027.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] buildings;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		buildings = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			buildings[i] = Integer.parseInt(st.nextToken());
		}

		int maxCnt = 0;
		for (int i = 1; i <= N; i++) {
			if (i == 1) {
				maxCnt = right(i);
			} else if (i == N) {
				maxCnt = Math.max(maxCnt, left(i));
			} else {
				maxCnt = Math.max(maxCnt, left(i) + right(i));
			}
		}

		System.out.println(maxCnt);
	}

	static int left(int startIdx) {
		int nowIdx = startIdx;
		int cnt = 0;
		double maxSlope = Double.MAX_VALUE;
		while (true) {
			// 다음 빌딩 탐색
			nowIdx--;
			if (nowIdx <= 0) {
				break;
			}

			double nowSlope = (double)(buildings[nowIdx] - buildings[startIdx]) / (nowIdx - startIdx);

			if (nowSlope < maxSlope) {
				maxSlope = nowSlope;
				cnt++;
			}
		}
		return cnt;
	}

	static int right(int startIdx) {
		int nowIdx = startIdx;
		int cnt = 0;
		double maxSlope = -Double.MAX_VALUE;
		while (true) {
			// 다음 빌딩 탐색
			nowIdx++;
			if (nowIdx > N) {
				break;
			}

			double nowSlope = (double)(buildings[nowIdx] - buildings[startIdx]) / (nowIdx - startIdx);

			if (nowSlope > maxSlope) {
				maxSlope = nowSlope;
				cnt++;
			}
		}
		return cnt;
	}
}
