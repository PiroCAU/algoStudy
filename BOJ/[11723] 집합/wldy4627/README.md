### 문제 이해
- 공집합 S가 주어졌을 때 다음 연산 수행하기
  - add x: S에 x 추가. S에 x가 있는 경우 무시
  - remove x: S에서 x 제거. S에 x가 없는 경우 연산 무시
  - check x: S에 x가 있으면 1을, 없으면 0을 출력
  - toggle x: S에 x가 있으면 x를 제거, 없으면 추가
  - all: S를 {1, 2, ..., 20}으로 바꿈
  - empty: S를 공집합으로 바꿈
#### input & output
- input: 연산의 수 M, 수행해야 하는 연산
- output: check 연산이 주어질 때마다 결과 출력
---
### 알고리즘 분류
- 자료 구조 선택 & 구현
#### 최종 방식
- 자료구조 중 어떤 걸 쓸까? -> Set
- 시간 초과 방지를 위해 BufferedReader, StringBuilder 사용