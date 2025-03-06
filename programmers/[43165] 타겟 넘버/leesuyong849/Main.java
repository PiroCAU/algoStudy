import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        for(int i : numbers) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                int next = queue.poll();
                queue.add(next + i);
                queue.add(next - i);
            }
        }
        
        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                answer++;
            }
        }
        return answer;
    }
}