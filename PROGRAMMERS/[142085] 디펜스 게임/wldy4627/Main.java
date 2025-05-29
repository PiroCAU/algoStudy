package pro.p142085.wldy4627;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = new int[]{4, 2, 4, 5, 3, 3, 1};

        int answer = solution(n, k, enemy);
        System.out.println(answer);
    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int enemyNum : enemy) {
            if (n <= 0) break;

            if (k > 0) {  // 무적권이 남아있다면
                k--;  // 무적권 사용
                minHeap.add(enemyNum);
            } else {  // 사용할 무적권이 없다면
                if (minHeap.peek() < enemyNum) {
                    n -= minHeap.poll();
                    minHeap.add(enemyNum);
                } else {
                    n -= enemyNum;
                }
                if (n < 0) break;
            }
            answer++;
        }

        return answer;
    }
}
