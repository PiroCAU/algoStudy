# 사고의 흐름
### 문제 요구사항
- 알고력 alp, 코딩력 cop
- alp, cop 상승
  - (1) 알고리즘/코딩 공부: 시간 1 소요, 능력 1 상승
  - (2) 문제 풀이: 같은 문제 여러번 풀이 가능
- 문제 problems: 2차원 int 배열
  - 요구알고력 alp_req
  - 요구코딩력 cop_req
  - 증가알고력 alp_rwd
  - 증가코딩력 cop_rwd
  - 요구시간 cost

Q. 주어진 모든 문제 풀 수 있는 
알고력, 코딩력을 얻는 최단시간?

### 생각하기

주어진 모든 문제를 풀 수 있는 알고력, 코딩력: 최대 alp_req, cop_req

현재 알고력, 코딩력과 req 비교하면 키워야 하는 수준 도출

problems 에 [0,0,1,0,1], [0,0,0,1,1] 추가하기

현재 수준에서 가장 높은 리워드를 얻을 수 있는 공부하기
알고리즘 개발

알고리즘
1. 시간 대비 높은 성장
2. 알고리즘 / 코딩 중 더 시급한 것 우선시

### 솔루션
- DP[alp][cop] : alp, cop 도달하는 데 걸리는 '최소 시간'


> 런타임 에러!

- 이미 모든 문제를 풀 수 있는 경우 추가

      if (alp >= maxAlpReq && cop >= maxCopReq) {
        return 0;
      }



# 어려운 점
### 아직도 모르겠다.
        int maxAlpReq = 0;
        int maxCopReq = 0;
> 런타임 에러로 테스트 6개정도 실패함

        int maxAlpReq = alp;
        int maxCopReq = cop;
> 모든 테스트 통과함

이유가 뭐지?

    // 이미 모든 문제를 풀 수 있는 경우
    if (alp >= maxAlpReq && cop >= maxCopReq) {
      return 0;
    }
여기에서 alp만 >= maxAlpReq 인 경우는 포함을 안 시켜서 오류가 날 수밖에 없다!

# 배운 점
문제를 보고 생각하는 흐름을 어떻게 가져가나? GPT
이렇게 사고하는 과정을 거침. 배워야겠다.

(1) 완전 탐색 (Brute Force): 단순하게 모든 경우의 수를 시뮬레이션
> 비효율적, 현실적으로 어렵다

(2) 그리디 (Greedy): “가장 효율적으로 성장할 수 있는 방법을 계속 선택하면 되지 않을까?”
> 현재 최선의 선택이 항상 전체적으로 최선이 된다고 보장할 수 없으므로 반례가 존재할 수 있다

(3) DP (다이나믹 프로그래밍): 현재 상태(알고력, 코딩력)에서 가능한 모든 선택을 고려하면서 “최적의 방법”을 쌓아가는 방식
> "각 (alp, cop) 상태에 도달하는 최소 시간", 중복 계산 줄이고 효율적!


# 알고리즘
    int[][] DP = new int[maxAlpReq + 1][maxCopReq + 1];
    for (int i = 0; i <= maxAlpReq; i++) {
    Arrays.fill(DP[i], Integer.MAX_VALUE);
    }
    DP[alp][cop] = 0; // 시작점

    for (int i = alp; i <= maxAlpReq; i++) {
        for (int j = cop; j <= maxCopReq; j++) {
            if (DP[i][j] == Integer.MAX_VALUE) continue;
            for (int[] problem : probList) {
                int alpReq = problem[0];
                int copReq = problem[1];
                int alpRwd = problem[2];
                int copRwd = problem[3];
                int cost = problem[4];

                if (i >= alpReq && j >= copReq) { // 문제를 풀 수 있으면
                    int newAlp = Math.min(i + alpRwd, maxAlpReq);
                    int newCop = Math.min(j + copRwd, maxCopReq);

                    if (DP[i][j] + cost < DP[newAlp][newCop]) {
                        DP[newAlp][newCop] = DP[i][j] + cost;
                    }
                    // 비교: 원래의 DP vs. 문제 풀고 시간이 늘어난 DP
                }
            }
        }
    }