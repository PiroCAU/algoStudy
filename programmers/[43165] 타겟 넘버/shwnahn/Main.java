package src.week3.DFS;

public class Main {
    public static void main(String[] args) {
        class Solution {
            public int solution(int[] numbers, int target) {
                int answer = dfs(0, 0, numbers, target);

                return answer;
            }

            // count 수 반환하는 dfs
            public static int dfs(int index, int sum, int[] numbers, int target){
                // 리프노드까지 오면 타겟과 비교, 맞으면 +1, 아니면 0
                if(index == numbers.length){
                    return sum == target ? 1 : 0;
                }
                int count = 0;

                // 더하는 경우와 빼는 경우 모두 고려
                count += dfs(index + 1, sum + numbers[index], numbers, target);
                count += dfs(index + 1, sum - numbers[index], numbers, target);

                return count;
            }
        }
    }
}
