# 알고리즘

    // (new) shwnahn 매트릭스 만들기 : 1-indexed 로 생성 (코드 섹시하게 만들기 위해!)
    // matrix[0][0] == sumMatrix[1][1] 인 셈이다.. 였는데 그냥 둘다 통일하기로...
    int[][] sumMatrix = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            sumMatrix[i][j] = matrix[i][j]
                    + sumMatrix[i - 1][j]
                    + sumMatrix[i][j - 1]
                    - sumMatrix[i - 1][j - 1];
        }
    }

# 어려운 점

시간 복잡도를 생각하지 못함. shwnahn.. 을 썼어야 했다.

블로그 참고해서 해결했음.
[참고 블로그](https://chanhuiseok.github.io/posts/baek-19/)