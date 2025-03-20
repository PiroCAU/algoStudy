### 문제 이해
- 알고력, 코딩력은 모두 0 이상의 정수
- 나의 알고력, 코딩력이 문제의 알고력, 코딩력보다 높아야지 문제 해결 가능
- 알고리즘 공부 1의 시간 => 알고력 + 1
- 코딩 공부 1의 시간 => 코딩력 + 1
- 모든 문제를 풀 수 있는 알고력, 코딩력을 얻는 최단 시간
- 정확성 테스트 케이스 제한사항
  1. 0 <= alp, cop <= 20
  2. 1 <= problems의 길이 <= 6
     - 0 <= alp_req, cop_req <= 20
     - 0 <= alp_rwd, cop_rwd <= 5
     - 1 <= cost <= 10
#### input
- 알고력 `alp`
- 코딩력 `cop`
- 문제의 정보가 담긴 2차원 배열 `problems`
  - `problems[alp_req, cop_req, alp_rwd, cop_rwd, cost]`
  - alp_req: 문제를 푸는데 필요한 알고력
  - cop_req: 문제를 푸는데 필요한 코딩력
  - alp_rwd: 문제를 풀었을 때 증가하는 알고력
  - cop_rwd: 문제를 풀었을 때 증가하는 코딩력
  - cost: 문제를 푸는데 드는 시간
---
### 문제 고안 방식
- 최소 비용으로 목표 능력치에 도달하는 최적의 방법을 찾아야 하는 최단 경로 문제 -> DP 사용
  - dp는 2차원 배열로, 각각의 인덱스는 알고력과 코딩력
  - `dp[i][j]`는 `alp = i, cop = j`까지 도달하는 최소 비용
- 알고력과 코딩력을 올릴 수 있는 방법
  - 알고리즘 공부 => alp + 1, cost = 1
  - 코딩 공부 => cop + 1, cost = 1
  - 문제 풀기 => alp + alp_rwd, cop + cop_rwd, cost
- DP 갱신 과정
  - `dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 1)`
  - `dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + 1)`
  - `dp[newAlp][newCop] = min(dp[newAlp][newCop], dp[i][j] + cost)`
  - 최종 목표 지점인 `dp[maxAlp][newCop]` 값 반환