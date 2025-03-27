package src.week6.표현가능한이진트리;

import java.util.Arrays;

public class Solution {
    public int[] solution(long[] numbers) {
        int[] results = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
//        1. 숫자를 이진수로 변환
//           - 필요하다면 0 패딩
//           - 포화 이진 트리는 노드 개수가 2^h - 1인 트리만 가능
            String binNum = Long.toBinaryString(numbers[i]);
            int height = (int) Math.ceil(Math.log(binNum.length() + 1) / Math.log(2));
            int treeSize = (int) Math.pow(2, height) - 1;
            binNum = String.format("%" + treeSize + "s", binNum).replace(' ', '0');
            // treeSize가 될 때까지 앞에 0 추가: ("%7s", 10001) -> 0010001

            int answer = isValid(binNum) ? 1 : 0;
            results[i] = answer;
        }
        return results;
    }

    public boolean isValid(String binNum) {
//        System.out.println("binNum: " + binNum);
        if (binNum.length() <= 1) {
//            System.out.println("length = 1, return true");
            return true;
        }

//        2. n/2 번째 숫자가 가운데 노드
        int midIndex = (binNum.length()/2);
        char midNode = binNum.charAt(midIndex);

//        4. 가운데 노드가 0이면 하위 노드 값 확인 T/F
        if (midNode == '0') {
            // 하위노드 확인
//            System.out.println("First: " + binNum.charAt(midIndex / 2));
//            System.out.println("Second: " + binNum.charAt(midIndex + (midIndex / 2) + 1));
            if (binNum.charAt(midIndex / 2) == '1' || binNum.charAt(midIndex + (midIndex / 2) + 1) == '1') {
                // 하위노드가 1이면 false
                return false;
            }
        }

        return isValid(binNum.substring(0, midIndex)) &&
                isValid(binNum.substring(midIndex + 1));

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long[] numbers = {7L, 63L, 95L};
        int[] result = sol.solution(numbers);
        System.out.println("결과: " + Arrays.toString(result));
    }
}