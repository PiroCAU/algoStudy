class Solution_12913 {
    int solution(int[][] land) {
        int answer = 0;

        int N = land.length;

        for (int i = 1; i < N; i++) {       //현재 행를 증가시킨다.
            for (int j = 0; j < 4; j++) {   //현재 계산할 열
                int max = 0;

                for (int k = 0; k < 4; k++) {       //이전 행에서 각 열을 순회하면서 값을 불러온다
                    if (k != j) {           //연속하여 같은 열의 것을 선택할 수는 없으므로 패스
                        max = Math.max(max, land[i-1][k]);
                    }
                }

                land[i][j] += max;          //이전행에서 선택할 수 있는 가장 좋은 값
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(land[N-1][i], answer);
        }
        return answer;
    }
}
