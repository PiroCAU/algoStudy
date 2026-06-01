package pro.p12927.wldy4627;

import java.util.*;

class Solution {
	public long solution(int n, int[] works) {
		long answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int work : works) {
			pq.offer(work);
		}

		for (int i = 0; i < n; i++) {
			int num = pq.poll();
			if (num == 0) break;
			pq.offer(num - 1);
		}

		while (!pq.isEmpty()) {
			int num = pq.poll();
			answer += num * num;
		}

		return answer;
	}
}