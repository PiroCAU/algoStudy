package proj.p43238.wldy4627;

import java.util.*;

class Solution {
	public long solution(int n, int[] times) {
		long answer = Integer.MAX_VALUE;

		Arrays.sort(times);
		long end = n * (long) times[times.length - 1];
		long start = 1;

		long mid;
		while (start <= end) {
			mid = (start + end) / 2;

			long peopleCnt = 0;
			for (int i = 0; i < times.length; i++) {
				peopleCnt += mid / times[i];
			}

			if (peopleCnt >= n) {
				answer = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return answer;
	}
}
