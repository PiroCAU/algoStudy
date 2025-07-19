class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                answer[i]++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
        }

        return answer;
    }
}