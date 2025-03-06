package PROGRAMMERS.[43165] 타겟 넘버.wldy4627;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] numbers = new int[n];

        System.out.println("배열 요소 입력: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.print("타겟 숫자 입력: ");
        int target = sc.nextInt();

        sc.close();

        Solution sol = new Solution();
        int answer = sol.solution(numbers, target);

        System.out.println(answer);
    }
}

class Solution {
    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);

        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {  // 만약 마지막 노드까지 탐색한 경우
            if (sum == target) {
                answer++;
            }
        } else {  // 아직 탐색할 노드가 남아있을 경우
            dfs(numbers, depth + 1, target, sum + numbers[depth]);  // 해당 노드 값 더하기
            dfs(numbers, depth + 1, target, sum - numbers[depth]);  // 해당 노드 값 빼기
        }

    }
}