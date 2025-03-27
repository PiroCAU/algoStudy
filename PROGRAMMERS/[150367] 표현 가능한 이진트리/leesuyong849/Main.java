public class Main {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String bin = Long.toBinaryString(numbers[i]);       // long 타입 정수를 이진수 문자열로 변환해주는 메서드

            // 포화 이진트리 크기 맞추기 (앞에 0 추가)
            int treeSize = getFullBinaryTreeLength(bin.length());
            while (bin.length() < treeSize) {
                bin = "0" + bin;
            }

            // 트리 구조로 유효한지 검사
            if (isValid(bin)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    // 포화 이진트리 크기 계산
    private int getFullBinaryTreeLength(int length) {
        int k = 0;
        while ((1 << k) - 1 < length) {     //1<<K의 의미: 1을 왼쪽으로 k만큼 이동. 즉, 2^k
            k++;
        }
        return (1 << k) - 1; // 2^k - 1 -> 포화트리는 항상 이 숫자만큼 있다.
    }

    // 트리가 유효한지 검사 (재귀)
    private boolean isValid(String bin) {
        return isValidSubtree(bin);
    }

    private boolean isValidSubtree(String bin) {
        if (bin.length() == 1) return true;     //

        int mid = bin.length() / 2;
        char root = bin.charAt(mid);        //가운데에 있는 것이 중심이 된다.
        String left = bin.substring(0, mid);
        String right = bin.substring(mid + 1);

        char leftRoot = left.charAt(left.length() / 2);     //왼쪽에 달린 노드들 중에서 가장 높은 위치에 있는 것. 즉, 자신에게 직접 달린 것
        char rightRoot = right.charAt(right.length() / 2);

        // 자식이 둘 다 1이 아닌데 부모가 1인 경우 → 유효하지 않음
        if (root == '0' && (leftRoot == '1' || rightRoot == '1')) {
            return false;
        }

        return isValidSubtree(left) && isValidSubtree(right);
    }
}
