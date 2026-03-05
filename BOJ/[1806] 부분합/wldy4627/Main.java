package boj.b1806.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if (nums[i] >= S) {
				System.out.println(1);
				return;
			}
		}

		int length = Integer.MAX_VALUE;
		int start = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += nums[i];

			while (sum >= S) {
				length = Math.min(length, i - start + 1);
				sum -= nums[start];
				start++;
			}
		}

		if (length == Integer.MAX_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(length);
	}
}
