package BOJ_43238_입국심사;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {

        long lower = 1;
        long upper = Arrays.stream(times).min().getAsInt() * n;
        long mid = (lower + upper) / 2;

        while(lower < upper) {
            int cnt = 0;
            for (int time : times) {
                cnt += mid / time;
            }

            if (cnt >= n) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
            mid = (lower + upper) / 2;
        }

        return mid;
    }
}
