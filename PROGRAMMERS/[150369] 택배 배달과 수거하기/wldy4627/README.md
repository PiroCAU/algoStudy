### 문제 이해
- n개의 집에 택배를 배달하려고 함. 배달을 다니면서 빈 재활용 택배 상자들을 수거하려 함
- 배달할 택배들은 모두 재활용 택배 상자에 담겨서 물류창고에 보관되어 있음.
  - i번째 집은 물류창고에서 i만큼 떨어져 있음
  - i번째 집은 j번째 집과 거리 j-1만큼 떨어져 있음
- 트럭에는 재활용 택배 상자를 최대 cap개 실을 수 있음
- 각 집마다 배달할 재활용 택배 상자의 개수와 수거할 빈 재활용 택배 상자의 개수를 알고 있을 때, 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리
  - 각 집에 배달 및 수거할 때 원하는 개수만큼 택배를 배달 및 수거할 수 있음
#### input & output
- input:
  - 트럭에 실을 수 있는 재활용 택배 상자의 최대 개수 cap
  - 배달할 집의 개수 n
  - i+1번째 집에 배달할 재활용 택배 상자의 개수 deliveries
  - i+1번째 집에서 수거할 빈 재활용 택배 상자의 개수 pickups
- output: 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리
---
### 고안 방식
- 가장 멀리 있는 것부터 처리 -> 그리디...?
#### 최종 방식
- 가장 먼 집부터 역순으로 순회
- 현재 집에 배달 or 수거할 게 있으면 트럭 여러번 보내서 다 처리
- 한 번 갈때마다 (i+1)*2만큼 추가