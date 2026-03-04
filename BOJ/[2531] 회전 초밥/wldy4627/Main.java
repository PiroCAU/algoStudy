package boj.b2531.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		int[] count = new int[d+1];
		Arrays.fill(count, 0);
		int distinct = 0;
		for (int i = 0; i < k; i++) {
			if (++count[sushi[i]] == 1) {
				distinct++;
			}
		}

		int answer = distinct;
		if (count[c] == 0) {
			answer = Math.max(answer, distinct + 1);
		} else {
			answer = Math.max(answer, distinct);
		}

		for (int i = 1; i < N; i++) {
			// 맨 앞에꺼 제거
			if (--count[sushi[i-1]] == 0) {
				distinct--;
			}

			// 맨 뒤에꺼 추가
			if (++count[sushi[(i-1 + k) % N]] == 1) {
				distinct++;
			}

			// answer 갱신
			if (count[c] == 0) {
				answer = Math.max(answer, distinct + 1);
			} else {
				answer = Math.max(answer, distinct);
			}
		}

		System.out.println(answer);
	}
}
