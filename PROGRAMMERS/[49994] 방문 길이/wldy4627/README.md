### 문제 이해
- 게임 캐릭터를 움직이게 하는 4가지 명령어
  - U: 위쪽으로 한 칸 이동
  - D: 아래쪽으로 한 칸 이동
  - R: 오른쪽으로 한 칸 이동
  - L: 왼쪽으로 한 칸 이동
- 캐릭터는 (0,0)에서 이동 -> 경계는 (-5,5), (-5,-5), (5,5), (5,-5)
- 명령어가 주어졌을 때 캐릭터가 처음 걸어본 길의 길이를 구하고자 함
#### input & output
- input: 명령어 dirs
- output: 게임 캐릭터가 처음 걸어본 길의 길이
---
### 고안 방식
- 각 점을 기준으로 (currentX, currentY) -> (nextX, nextY)를 중복없이 count
#### 최종 방식
- 각 경로를 중복없이 저장하기 위해 HashSet 사용
- (currentX)(currentY)(nextX)(nextY)과 (nextX)(nextY)(currentX)(currentY) 저장
  - 둘은 동일한 경로라고 간주하기 위함
- HashSet의 길이의 1/2 return