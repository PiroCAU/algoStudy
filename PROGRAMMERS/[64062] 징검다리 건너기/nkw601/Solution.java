class Solution {

    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200_000_000;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canCross(stones, k, mid)) {
                // mid명은 건널 수 있음
                // 더 많은 사람도 가능한지 확인
                left = mid + 1;
            } else {
                // mid명은 건널 수 없음
                // 사람 수를 줄여야 함
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean canCross(int[] stones, int k, int people) {
        int count = 0;

        for (int stone : stones) {
            if (stone < people) {
                count++;
            } else {
                count = 0;
            }

            if (count >= k) {
                return false;
            }
        }

        return true;
    }
}

// dp인가? 싶었는데 슬라이딩 윈도우래
// 저는 카카오 못하겠습니다....