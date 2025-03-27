package pro.p150367.wldy4627;

import java.util.Arrays;

public class Main {
    public static int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        String[] binaryNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {  // 10진수 -> 2진수
            binaryNumbers[i] = Long.toBinaryString(numbers[i]);
            binaryNumbers[i] = toFullBT(binaryNumbers[i]);  // 포화 이진트리로 변경
            answer[i] = isBinaryTree(binaryNumbers[i]);  // 이진트리로 표현할 수 있는지의 여부
        }

        return answer;
    }

    private static String toFullBT(String binaryNumber) {
        int length = binaryNumber.length();
        int nodeCnt = 1;  // 포화 이진트리를 만들 수 있을 만큼의 노드 개수
        int level = 1;  // 트리의 높이

        while (length > nodeCnt) {
            level *= 2;
            nodeCnt += level;
        }

        int offset = nodeCnt - length;  // 부족한 자릿수는 0으로 채움
        return "0".repeat(offset) + binaryNumber;
    }

    private static int isBinaryTree(String binaryNumber) {
        int length = binaryNumber.length();

        if (length == 1) {
            return 1;
        }

        int mid = length / 2;
        char root = binaryNumber.charAt(mid);

        String left = binaryNumber.substring(0, mid);
        String right = binaryNumber.substring(mid + 1);

        if (root == '0') {
            if (left.contains("1") || right.contains("1")) {
                return 0;
            }
        }

        if (isBinaryTree(left) == 0 || isBinaryTree(right) == 0) {
            return 0;
        }

        return 1;
    }

    public static void main(String[] args) {
        long[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] result = solution(numbers);
        System.out.println(Arrays.toString(result));
    }
}