package pro.p150369.wldy4627;

public class Main {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverRemain = 0;
        int pickupRemain = 0;

        for (int i = n - 1; i >= 0; i--) {
            deliverRemain += deliveries[i];
            pickupRemain += pickups[i];

            // 필요한 왕복 수 계산
            while (deliverRemain > 0 || pickupRemain > 0) {
                deliverRemain -= cap;
                pickupRemain -= cap;
                answer += (i + 1) * 2L;  // 왕복 거리
            }
        }

        return answer;
    }
}
