package pro.p12904.wldy4627;

import java.util.*;

class Solution
{
	public int solution(String s)
	{
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			// 홀수 길이
			int len1 = getPalindromeLength(s, i, i);

			// 짝수 길이
			int len2 = getPalindromeLength(s, i, i + 1);

			int currentMax = Math.max(len1, len2);
			answer = Math.max(answer, currentMax);
		}

		return answer;
	}

	private int getPalindromeLength(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return right - left - 1;
	}
}