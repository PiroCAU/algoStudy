### 문제 이해
- 택배 상자는 번호 순서대로 전달됨
- 택배가 나오는 컨테이너 벨트는 한 방향으로만 진행이 가능하여 벨트에 놓인 순서대로 내릴 수 있음
- 택배를 잠시 보관하는 컨테이너 벨트는 가장 마지막에 보관한 순서대로 꺼낼 수 있음
- 택배 기사가 알려준 순서대로 택배를 실어야 함
- 영재는 몇개의 상자를 실을 수 있는가?
#### input
- order 배열

---
### 문제 고안 방식
- 택배를 보관하는 컨테이너 벨트는 후입 선출이므로 stack으로 구현
- 1 ~ n 번의 택배 상자를 하나씩 확인하면서 진행
  - 순서에 맞는지 확인은 `order[truckBoxCnt]`로 진행
- 만약 컨테이너 벨트에서 나온 택배를 트럭에 실을 수 있다면 트럭에 싣고 `truckBoxCnt++`, 다음 택배 확인
- 트럭에 실을 수 없다면 보관용 컨테이너 벨트 (stack)에 push
- while문을 통해 stack에서 꺼낸 택배를 트럭에 실을 수 있다면 트럭에 싣고 `truckBoxCnt++` 과정을 반복
- 트럭에 실은 택배의 수인 `truckBoxCnt` 반환