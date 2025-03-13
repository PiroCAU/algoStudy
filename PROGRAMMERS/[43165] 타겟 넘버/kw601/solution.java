import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        // 각 숫자를 더하기/빼기 가능
        // 더한 거 큐에 넣고 뺀 거 큐에 넣고
        // 다 하고 큐에 남은 숫자랑 target 비교
        // 아 이러면 순서를 못 세네
        
        // 합, idx 함께 넣기
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});

        while(!que.isEmpty()){
            int cur[] = que.poll();
            int s = cur[0];
            int idx = cur[1];
            
            // 끝까지 계산 끝난 애면
            if (idx == numbers.length){
                if( s == target){
                    answer++;
                }
            } else {
                que.offer(new int[]{s + numbers[idx], idx + 1});
                que.offer(new int[]{s - numbers[idx], idx + 1});
            }
        }
        
        return answer;
    }
}