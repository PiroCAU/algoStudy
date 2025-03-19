package src.week5.택배상자;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int solution(int[] order) {
        Stack<Integer> belt = new Stack<Integer>();
        int cnt = 0;

        for (int i = 1; i <= order.length; i++) {
            // (1) to Belt
            belt.push(i);
//            System.out.println(i + "push 완료");

            // (2) Belt to Truck 루프
            while (true) {
                if (belt.isEmpty()) {
//                    System.out.println("소진, 순회 종료\n");
                    break;
                }
                else if (belt.peek() == order[cnt]) {
//                    System.out.println("일치 발견.. " + belt.peek());
                    belt.pop();
                    cnt++;
                } else {
//                    System.out.println("불일치, 순회 종료\n");
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] order = {3, 2, 1, 4, 5};
        int result = sol.solution(order); // 예상 result: 80
        System.out.println(Arrays.toString(order));
        System.out.println("결과: " + result);
    }
}