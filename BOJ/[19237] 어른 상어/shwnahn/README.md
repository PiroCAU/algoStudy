# 사고의 흐름
### 문제 요구사항
- N x N 크기의 격자
- M 마리의 상어
  - 상어마다 1~M 번호
  - 1번 상어가 가장 강력
- 위치마다 냄새 남김
  - k번 이동 시 냄새 사라짐
- 상어 이동 알고리즘
  - 1초마다 인접한 칸으로 이동
  - if(냄새 없는 칸이 하나면), 그리로 이동
  - else, 특정 우선순위 따름
    - 상어마다 우선순위 다름
- 이동 후 한 칸에 여러 마리가 있으면,가장 작은 숫자 상어 제외 모두 쫓겨남 
### 생각하기
이건 스프링부트 프로젝트 아닌가..? 알고리즘?
그냥 실제로 시뮬레이션을 돌려야 하나?

입력: N, M, k, 상어위치, 상어방향, 우선순위표

### 솔루션
그냥 그대로 구현하고, while문으로 알고리즘 반복하기
- 상어마다 현재 좌표 저장하기
- 좌표마다 냄새(상어번호, 잔여기간) 저장하기
- 이동하기
- 겹치면 삭제하기

# 어려운 점
- 너무 헷갈린다.
- 100% 머리로 생각하고 들어가야하는데, 코드없이 생각하기가 어렵다. 훈련 필요할 듯

# 배운 점
- 분할 정복

# 알고리즘

    // 1. 이동하기 - 각 상어마다 순회
    for (int index = 1; index <= M; index++) {
    if (!isAlive[index]) continue;

      int currentRow = sharks[index][0];
      int currentCol = sharks[index][1];
      int currentDir = sharks[index][2];

      boolean moved = false;
      // a. 냄새 없는 곳 먼저 가기
      for (int priority = 1; priority <= 4; priority++) {
          int nextDir = movePriority[index][currentDir][priority];
          int nextRow = currentRow + dr[nextDir];
          int nextCol = currentCol + dc[nextDir];

          if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
              continue;
          }

          if (smell[nextRow][nextCol][1] == 0) {
              sharks[index][0] = nextRow;
              sharks[index][1] = nextCol;
              sharks[index][2] = nextDir;
              moved = true;
              break;
          }
      }
      // b. 자신 냄새가 있는 장소로 가기
      if (!moved) {
          for (int priority = 1; priority <= 4; priority++) {
              int nextDir = movePriority[index][currentDir][priority];
              int nextRow = currentRow + dr[nextDir];
              int nextCol = currentCol + dc[nextDir];

              if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && smell[nextRow][nextCol][0] == index) {
                  sharks[index][0] = nextRow;
                  sharks[index][1] = nextCol;
                  sharks[index][2] = nextDir;
                  break;
              }
          }
      }
  }