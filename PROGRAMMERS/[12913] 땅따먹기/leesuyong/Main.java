class Solution_12913 {
    int solution(int[][] land) {
        int answer = 0;

        int N = land.length;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;

                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        max = Math.max(max, land[i-1][k]);
                    }
                }

                land[i][j] += max;
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(land[N-1][i], answer);
        }
        return answer;
    }
}
