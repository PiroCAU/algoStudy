package boj.b1253.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		int answer = 0;
		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N-1;
			while (left < right) {
				if (left == i) {
					left++;
					continue;
				} else if (right == i) {
					right--;
					continue;
				} else {
					long sum = nums[left] + nums[right];

					if (sum == nums[i]) {
						answer++;
						break;
					} else if (sum < nums[i]) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
