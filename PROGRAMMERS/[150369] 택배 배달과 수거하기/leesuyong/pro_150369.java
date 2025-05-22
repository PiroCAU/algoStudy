import java.util.Comparator;
import java.util.PriorityQueue;

public class pro_150369 {

    class Solution_150369 {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;


            int d = n - 1; // 배달 끝 인덱스
            int p = n - 1; // 수거 끝 인덱스

            while (d >= 0 || p >= 0) {
                // 가장 먼 거리 찾기
                while (d >= 0 && deliveries[d] == 0) d--;
                while (p >= 0 && pickups[p] == 0) p--;

                if (d < 0 && p < 0) break;

                int maxIdx = Math.max(d, p);
                answer += (maxIdx + 1) * 2L;

                // 배달
                int remain = cap;
                for (int i = d; i >= 0 && remain > 0; i--) {
                    if (deliveries[i] <= remain) {
                        remain -= deliveries[i];
                        deliveries[i] = 0;
                    } else {
                        deliveries[i] -= remain;
                        remain = 0;
                    }
                }

                // 수거
                remain = cap;
                for (int i = p; i >= 0 && remain > 0; i--) {
                    if (pickups[i] <= remain) {
                        remain -= pickups[i];
                        pickups[i] = 0;
                    } else {
                        pickups[i] -= remain;
                        remain = 0;
                    }
                }
            }

            return answer;
        }
    }
}
