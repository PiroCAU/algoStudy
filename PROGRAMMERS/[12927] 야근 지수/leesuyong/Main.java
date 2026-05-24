package PRO_12927_야근지수;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
}

class Solution {
    public long solution(int n, int[] works) {

        int size = works.length;

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < size; i++) {

            que.offer(works[i]);
        }

        for (int i = 0; i < n; i++) {
            if (que.isEmpty()) return 0;
            int poll = que.poll();
            poll--;
            if (poll != 0) {
                que.add(poll);
            }

        }

        int result = 0;
        while(!que.isEmpty()) {
            int poll = que.poll();
            result += poll * poll;
        }
        return result;
    }
}
