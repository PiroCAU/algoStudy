package proj.p77486.wldy4627;

import java.util.*;

class Solution {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		HashMap<String, String> parentMap = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			parentMap.put(enroll[i], referral[i]);
		}

		HashMap<String, Integer> moneyMap = new HashMap<>();
		for (int i = 0; i < enroll.length; i++) {
			moneyMap.put(enroll[i], 0);
		}

		for (int i = 0; i < seller.length; i++) {
			String curName = seller[i];
			int money = amount[i] * 100;

			while (!curName.equals("-") && money > 0) {
				int tax = money / 10;       // 상사에게 떼어줄 10%
				int myMoney = money - tax;  // 내가 가질 90%

				moneyMap.put(curName, moneyMap.get(curName) + myMoney);

				curName = parentMap.get(curName);
				money = tax;
			}
		}

		int[] answer = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = moneyMap.get(enroll[i]);
		}

		return answer;
	}
}