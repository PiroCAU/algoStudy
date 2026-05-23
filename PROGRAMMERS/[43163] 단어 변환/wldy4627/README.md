### 문제 이해
- 두 개의 단어 begin, target과 단어의 집합 words
- 아래의 규칙을 이용해서 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾고자 함
  1. 한 번에 한 개의 알파벳만 바꿀 수 있음
  2. words에 있는 단어로만 변환할 수 있음
- 최소 몇 단계의 과정을 거쳐 begin에서 target으로 변환할 수 있는지
#### input & output
- input: begin, target, words
- output: 최소 몇 단계의 과정을 거쳐 begin에서 target으로 변환할 수 있는지 (반환할 수 없다면 0)
---
### 고안 방식
- BFS
#### 최종 방식
- Queue에 후보를 넣으면서 계산
