package boj.b20922.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[100001];
		int left = 0;
		int answer = 0;

		for (int right = 0; right < N; right++) {
			count[arr[right]]++;

			while (count[arr[right]] > K) {
				count[arr[left]]--;
				left++;
			}

			answer = Math.max(answer, right - left + 1);
		}

		System.out.println(answer);
	}
}
