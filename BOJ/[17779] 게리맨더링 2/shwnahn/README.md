# 사고의 흐름
### 문제 요구사항
- 공평하게 선거구 정하기
- N x N 개의 구역
- 5개의 선거구
  - 선거구에는 최소 1개의 구역
  - 선거구에 포함된 구역은 연결됨
- 선거구 나누기
  - (x,y), d1, d2 로 경계선
  - 경계 구역 기준으로 4구간 나누기
  - 나눈 구역에 따른 인구 더하기
### 생각하기
N = 7, x = 2, y = 4, d1 = 2, d2 = 2 의 케이스를 보자.
1번 경계선: (2,4), (3,3), (4,2)
1번 선거구: 1 <= row < 4, 1 <= col <= 4

경계 포인트 꼭지점으로 잡고 풀면 조금 쉬울 것 같은데?
ex1)
좌 (2,4), 상 (4,2), 우 (6,4), 하 (4,6)
y경계선: 1&3 - 3, 2&4 - 4
x경계선: 1&2 - 4, 3&4 - 3

ex2)
좌 2,5 상 5,2 우 7,4 하 4,7
x경계선 1&3 - 4, 2&4 - x
y경계선 1&2 - 5, 3&4 - x

### 솔루션
경계선을 grid로 새로 만들어서 풀기

해결책 감이 안와서 블로그 참고해서 풀이.
막상 해보니까 엄청 복잡하지는 않다.

# 어려운 점
- 수학적 사고의 부재
# 배운 점
- Arrays.sort

# 알고리즘
    // 1. 경계선 지정
    boolean[][] border = new boolean[N][N];
    
    // 경계선 4개 설정
    for (int i = 0; i <= d1; i++) {
        border[x + i][y - i] = true; // 1번 경계선
        border[x + d2 + i][y + d2 - i] = true; // 4번 경계선
    }
    for (int i = 0; i <= d2; i++) {
        border[x + i][y + i] = true; // 2번 경계선
        border[x + d1 + i][y - d1 + i] = true; // 3번 경계선
    }
    
    // 2. 경계선 마주칠때까지 인구 더하기
    int[] peopleSum = new int[5];
    // 1구역
    for (int r = 0; r < x + d1; r++) {
        for (int c = 0; c <= y; c++) {
            if (border[r][c]) break;
            peopleSum[0] += grid[r][c];
        }
    }
    
    // 2구역
    for (int r = 0; r <= x + d2; r++) {
        for (int c = N - 1; c > y; c--) {
            if (border[r][c]) break;
            peopleSum[1] += grid[r][c];
        }
    }
    
    // 3구역
    for (int r = x + d1; r < N; r++) {
        for (int c = 0; c < y - d1 + d2; c++) {
            if (border[r][c]) break;
            peopleSum[2] += grid[r][c];
        }
    }
    // 4구역
    for (int r = x + d2 + 1; r < N; r++) {
        for (int c = N - 1; c >= y - d1 + d2; c--) {
            if (border[r][c]) break;
            peopleSum[3] += grid[r][c];
        }
    }
    
    // 5구역
    peopleSum[4] = totalPeople;
    for (int i = 0; i < 4; i++) {
        peopleSum[4] -= peopleSum[i];
    }
    
    // 최소값 비교하기
    Arrays.sort(peopleSum);
    min = Math.min(min, peopleSum[4] - peopleSum[0]);