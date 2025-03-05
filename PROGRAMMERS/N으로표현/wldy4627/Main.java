package PROGRAMMERS.N으로표현.wldy4627;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N 입력: ");
        int N = sc.nextInt();

        System.out.print("목표 숫자 입력: ");
        int number = sc.nextInt();

        sc.close();

        Solution sol = new Solution();
        int answer = sol.solution(N, number);

        System.out.println(answer);
    }
}

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        List<Set<Integer>> dpList = new ArrayList<>();
        dpList.add(new HashSet<Integer>());

        for (int i = 0; i <= 8; i++) {
            dpList.add(new HashSet<>());
        }

        dpList.get(1).add(N);
        int num = N;

        for (int i = 2; i <= 8; i++) {
            num = num * 10 + N;
            dpList.get(i).add(num);

            for (int j = 1; j < i; j++) {
                for (int setNum1 : dpList.get(j)) {
                    for (int setNum2 : dpList.get(i - j)) {
                        dpList.get(i).add(setNum1 + setNum2);
                        dpList.get(i).add(setNum1 - setNum2);
                        dpList.get(i).add(setNum1 * setNum2);
                        if (setNum2 != 0) {
                            dpList.get(i).add(setNum1 / setNum2);
                        }
                    }
                }
            }
            if (dpList.get(i).contains(number)) {
                return i;
            }
        }
        return -1;
    }
}