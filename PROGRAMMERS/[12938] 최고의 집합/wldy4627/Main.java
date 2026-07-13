package prog.p12938.wldy4627;

public class Main {
	class Solution {
		public int[] solution(int n, int s) {
			int[] answer = {};

			if (s < n) {
				return new int[]{-1};
			}

			answer = new int[n];

			int num = s / n;
			for (int i = 0; i < n; i++) {
				answer[i] = num;
			}

			int remainder = s % n;
			if (remainder > 0) {
				for (int i = 1; i <= remainder; i++) {
					answer[n - i]++;
				}
			}

			return answer;
		}
	}
}
