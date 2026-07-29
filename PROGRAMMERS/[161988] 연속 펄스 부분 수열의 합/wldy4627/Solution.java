package proj.p161988.wldy4627;

import java.util.*;

class Solution {
	public long solution(int[] sequence) {
		long answer = 0;

		int len = sequence.length;

		long[] purse1 = new long[len];    // [1, -1, 1, ...]를 곱한 수열
		long[] purse2 = new long[len];    // [-1, 1, -1, ...]를 곱한 수열
		for (int i = 0; i < len; i++) {
			if (i % 2 == 0) {
				purse1[i] = sequence[i] * 1;
				purse2[i] = sequence[i] * -1;
			} else {
				purse1[i] = sequence[i] * -1;
				purse2[i] = sequence[i] * 1;
			}
		}

		long[] sum1 = new long[len];
		sum1[0] = purse1[0];
		answer = purse1[0];
		for (int i = 1; i < len; i++) {
			sum1[i] = Math.max(sum1[i-1] + purse1[i], purse1[i]);
			answer = Math.max(answer, sum1[i]);
		}

		long[] sum2 = new long[len];
		sum2[0] = purse2[0];
		answer = Math.max(answer, purse2[0]);
		for (int i = 1; i < len; i++) {
			sum2[i] = Math.max(sum2[i-1] + purse2[i], purse2[i]);
			answer = Math.max(answer, sum2[i]);
		}

		return answer;
	}
}