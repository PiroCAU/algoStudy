package PRO_12904_가장긴팰린드롬;

import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {

    }

    public int solution(String s)
    {
        int answer = 0;
        int N = s.length();

        for (int i = 0; i < N; i++) {
            int case1 = check(s, i, i);
            int case2 = check(s, i, i+1);
            answer = Math.max(answer, Math.max(case1, case2));
        }

        return answer;
    }

    private int check(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
