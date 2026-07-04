package prog.p12971.wldy4627;

import java.util.*;

class Solution {
	public int solution(int sticker[]) {
		int num = sticker.length;

		if (sticker.length == 1) {
			return sticker[0];
		}

		int[] sum1 = new int[num];  // 첫번째 스티커를 찢은 경우의 합
		int[] sum2 = new int[num];  // 두번째 스티커를 찢은 경우의 합

		/*
		 * 첫번째 스티커를 찢은 경우
		 * 두번째 스티커와 마지막 스티커는 찢을 수 없음
		 */
		sum1[0] = sticker[0];
		sum1[1] = sum1[0];
		for (int i = 2; i < num; i++) {
			if (i == num - 1) {
				sum1[i] = sum1[i - 1];
				break;
			}
			sum1[i] = Math.max(sum1[i - 2] + sticker[i], sum1[i - 1]);
		}

		/*
		 * 첫번째 스티커를 찢지 않은 경우
		 * 두번째 스티커와 마지막 스티커는 찢을 수 있음
		 */
		sum2[0] = 0;
		sum2[1] = sticker[1];
		for (int i = 2; i < num; i++) {
			sum2[i] = Math.max(sum2[i - 2] + sticker[i], sum2[i - 1]);
		}
		return Math.max(sum1[num - 1], sum2[num - 1]);
	}
}
