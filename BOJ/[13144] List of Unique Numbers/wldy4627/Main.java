package boj.b13144.wldy4627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long cnt = 0;
		int left = 0, right = 0;
		HashSet<Integer> set = new HashSet<>();
		while (right < N) {
			if (set.contains(arr[right])) {
				set.remove(arr[left]);
				left++;
			} else {
				set.add(arr[right]);
				right++;
				cnt += (right - left);
			}
		}

		System.out.println(cnt);
	}
}
