## 문제 이해

카드 100장

2 <= n <= 100
카드 <= n
상자 <= 카드

상자에 카드 한 장씩, 무작위, 일렬로 나열
1번부터 번호

임의의 상자 선택, 숫자 카드 확인
-> 카드에 해당하는 상자 -> 숫자 카드
-> ... -> 이미 열린 상자
=> 1번 상자 그룹
다시 반복
=> 2번 상자 그룹

1번 상자 X 2번 상자: 게임 점수

최고 점수 return

cards[i]: i+1번 상자에 담긴 카드

## 풀이 생각

visited[100]
if not visited[current]:
visited = True
set.add(current)
dfs(next)
if visited: return len(set)

테스트 2, 14에서 런타임에러나...
-> 그룹 개수 1개일 경우 0 반환이었다...
