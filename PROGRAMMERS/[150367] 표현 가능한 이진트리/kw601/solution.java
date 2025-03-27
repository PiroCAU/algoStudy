import java.util.*;

class Solution {
    
    // 1. 숫자를 이진수로 바꾸기
    private String toBinary(long n) {
        if (n == 0) return "0";
        if (n == 1) return "1";
        return toBinary(n / 2) + (n % 2);
    }

    // 포화 이진트리의 수 공식 2^n -1
    private String addPadding(String digit) {
        int nums = 1;
        int n = 1;

        // 지피티 친구가 알려준 더 효율적인 방법...
        // n = (int)Math.ceil(Math.log(digit.length() + 1) / Math.log(2));
        // int total_len = (int)Math.pow(2, n) - 1;

        while (digit.length() > nums) {
            n += 1;
            nums = (int)Math.pow(2, n) - 1;
        }

        // 앞에 0 채우기
        while (digit.length() < nums) {
            digit = "0" + digit;
        }

        return digit;
    }

    // 트리 유효성 검사
    private boolean isValid(String binary) {
        // 리프노드는 True
        if (binary.length() == 1) return true;

        // 중간 = 부모
        int mid = binary.length() / 2;
        char root = binary.charAt(mid);
        String left = binary.substring(0, mid);
        String right = binary.substring(mid + 1);

        // 완전이진트리 -> 부모가 0인데 자식이 1이면 False
        if (root == '0' && (left.contains("1") || right.contains("1"))) {
            return false;
        }

        return isValid(left) && isValid(right);
    }

    public int[] solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (long num : numbers) {
            // 1. numbers의 숫자들 이진수로 바꾸기
            String digit = toBinary(num);

            // 2. 포화 이진트리 길이에 맞게 패딩 붙이기
            digit = addPadding(digit);

            // 3. 유효성 체크
            answer.add(isValid(digit) ? 1 : 0);
        }

        // 리스트 -> 배열 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}