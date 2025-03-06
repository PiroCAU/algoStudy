package src.week3.DynamicPlanning;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    static int target;
    static ArrayList<Integer>[] cases;
    static boolean foundTarget = false;
    public int solution(int N, int number) {
        target = number;
        if (N == number) return 1;

        // 배열 만들어서 저장
        cases = new ArrayList[9];
        for (int i = 1; i <= 8; i++) {
            cases[i] = new ArrayList<>();
        }
//        경우의 수를 저장할 때 단계별로 할 수 있을 것.
//        1. 1개로 만드는 경우: N
        cases[1].add(N);

//        2. 2개~8개로 만드는 경우 계산
        for (int index = 2; index <= 8; index++) {
            HashSet<Integer> total = new HashSet<>();

            int a = Integer.parseInt(String.valueOf(N).repeat(index));
            if(a == target) return index;
            total.add(a);

            for (int i = 1; i <= index / 2; i++) {
//              사칙연산 시행 후 결과 저장
                HashSet<Integer> result;
                result = operate(i, index - i);
//                이 때, number 나오면 즉시 중단 (시간 효율)
                if (foundTarget) return index;
                total.addAll(result);
            }
            cases[index].addAll(total);
        }
        return -1;

    }

    public static HashSet<Integer> operate(int n1, int n2) {
        HashSet<Integer> result = new HashSet<>();
        for (int num1 : cases[n1]) {
            for (int num2 : cases[n2]) {
                if(CheckAndAdd(num1 + num2, result)) return result;
                if(CheckAndAdd(num1 - num2, result)) return result;
                if(CheckAndAdd(num2 - num1, result)) return result;
                if(CheckAndAdd(num1 * num2, result)) return result;
                if (num2 != 0 && num1 != 0) {
                    if(CheckAndAdd(num1 / num2, result)) return result;
                    if(CheckAndAdd(num2 / num1, result)) return result;
                }
            }
        }
        return result;
    }

    public static boolean CheckAndAdd(int num, HashSet<Integer> set) {
        if (num == target) {
            foundTarget = true;
            return true;
        }
        set.add(num);
        return false;
    }
}

