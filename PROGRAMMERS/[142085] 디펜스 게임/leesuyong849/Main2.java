public class Main2 {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < enemy.length; i++) {
            sum += enemy[i];
            maxHeap.add(enemy[i]);

            if (sum > n) {
                if (k > 0) {
                    sum -= maxHeap.poll(); // 가장 큰 값 제거
                    k--;
                } else {
                    return i; // 현재 라운드 이전까지 가능
                }
            }
        }

        return enemy.length; // 모든 라운드 통과
    }
}