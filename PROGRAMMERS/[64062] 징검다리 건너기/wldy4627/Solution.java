package proj.p64062.wldy4627;

import java.util.*;

/*
- 연속된 k개의 구간이 모두 0이 되는 시점 -> 가장 빠르게 되는 시점
- k개의 구간으로 나누었을 때 최댓값이 가장 작은 경우
*/

class Solution {
	public int solution(int[] stones, int k) {
		// [값, 원래 인덱스] 배열을 담고, 값을 기준으로 내림차순 정렬하는 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
		for (int i = 0; i < k; i++) {
			pq.add(new int[]{stones[i], i});
		}

		int currentMax = pq.peek()[0];
		int resultMin = currentMax;

		for (int i = k; i < stones.length; i++) {
			pq.add(new int[]{stones[i], i});

			while (!pq.isEmpty() && pq.peek()[1] < i - k + 1) {
				pq.poll();
			}

			currentMax = pq.peek()[0];
			resultMin = Math.min(resultMin, currentMax);
		}

		return resultMin;
	}
}