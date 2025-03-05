import java.util.*;
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            Set<Integer> cur = dp.get(i);

            // N*i
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            cur.add(num);

            // 점화식 구현(dp[i]의 원소 = dp[i - j]의 원소 (사칙연산) dp[j])
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);

                for (int a : set1) {
                    for (int b : set2) {
                        cur.add(a + b);
                        cur.add(a - b);
                        cur.add(a * b);
                        if (b != 0) cur.add(a / b);
                    }
                }
            }
            
            // 찾으면
            if (cur.contains(number)) {
                return i;
            }
        }
    // 8번 하는 동안 못찾으면
    return -1;
    }
}