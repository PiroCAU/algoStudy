### 문제 이해
- 게임은 크기가 10*10이고, 총 100개의 칸으로 나누어져 있는 보드판에서 진행됨
  - 보드판의 각 칸은 1부터 100까지 수가 하나씩 순서대로 적혀있음
- 플레이어는 주사위를 굴려 나온 수만큼 이동해야 함
  - 만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없음
  - 도착한 칸이 사다리라면, 사다리를 타고 위로 올라감
  - 뱀이 있는 칸이라면, 뱀을 따라서 내려감
- 게임의 목표는 1번 캍에서 시작해서 100번 칸에 도착하는 것
- 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값
#### input & output
- input
    - 사다리의 수 N, 뱀의 수 M
    - N개의 줄 => 사다리의 정보를 의미하는 x, y
      - x번 칸에 도착하면, y번 칸으로 이동
    - M개의 줄 => 뱀의 정보를 의미하는 u, v
      - u번 칸에 도착하면, v번 칸으로 이동
- output: 100번 칸에 도착하기 위해 주사위를 최소 몇 번 굴려야 하는지
---
### 고안 방식
- 해당 게임판에서 내가 갈 수 있는 최적의 수단을 찾아내야 함
  => 주사위를 최대한 적게 굴릴 수 있는 방안
  => BFS를 이용해보자!
#### 최종 방식
- 사다리/뱀에 대한 정보 map에 저장
- bfs 진행
  - queue에 현재 위치와 이때까지 움직인 횟수를 저장하고 있는 정수 배열 저장
  - 만약 현재 위치가 최종 목적지라면 움직인 횟수 반환
  - 아니라면 다음 위치로 이동
    - 방문하지 않은 곳이라면 이동하면서 visited true로 변경 & queue에 넣어줌