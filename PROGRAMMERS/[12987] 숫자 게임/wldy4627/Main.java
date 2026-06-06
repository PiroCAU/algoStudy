package proj.p12987.wldy4627;

import java.util.Arrays;

public class Main {
	class Solution {
		public int solution(int[] A, int[] B) {
			int answer = 0;

			Arrays.sort(A);
			Arrays.sort(B);

			int aIndex = 0;
			for (int i = 0; i < B.length; i++) {
				if (A[aIndex] < B[i]) {
					answer++;
					aIndex++;
				}
			}
			return answer;
		}
	}
}
