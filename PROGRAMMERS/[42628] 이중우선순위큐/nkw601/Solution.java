import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQue = new PriorityQueue<>();

        for (String s : operations) {
            // s 분류
            String[] cmd = s.split(" ");
            char op = cmd[0].charAt(0);
            int num = Integer.parseInt(cmd[1]);
            // I: 삽입
            if (op == 'I') {
                maxQue.add(num);
                minQue.add(num);
            } else {
                // 삭제 : -1이면 최소 1이면 최대
                if (maxQue.isEmpty()) {
                    continue;
                } // 같은 원소 저장 -> 하나만 비교
                if (num == 1) {
                    int delNum = maxQue.poll();
                    minQue.remove(delNum);
                } else {
                    int delNum = minQue.poll();
                    maxQue.remove(delNum);
                }
            }
        }
        if (maxQue.isEmpty()) {
            return new int[] { 0, 0 };
        }

        return new int[] { maxQue.peek(), minQue.peek() };
    }
}