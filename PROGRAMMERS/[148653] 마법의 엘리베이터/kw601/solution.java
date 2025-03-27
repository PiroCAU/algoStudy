class Solution {
    public int solution(int storey) {
        int answer = 0;

        // if _1~4 -> -1해서 0으로 만들기
        // elif _6~10 -> +1해서 10으로 만들기
        // elif _5 -> 
            // if _가 1~4 -> -1
            // elif _가 6~10 -> +1
            // elif~

        while (storey > 0) {
            // 1의 자리
            int n = storey % 10;

            if (n == 0) {
                storey /= 10;
                continue;
            } else if (n < 5) {
                answer += n;
            } else if (n > 5) {
                answer += (10 - n);
                storey += 10;
            } else { // n == 5
                int next_n = (storey / 10) % 10;
                if (next_n >= 5) {
                    storey += 10;
                }
                answer += 5;
            }

            storey /= 10;
        }

        return answer;
    }
}