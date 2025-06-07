## 문제 이해

n \* m 보드
시작: R
도착: G
벽: D

목표 위치에 도달하기 위한 최소 이동 횟수
도착 절대 못하면, -1 return

## 풀이 생각

최소 거리: BFS
cur 꺼내고
if 도착: return
이동 가능할 때까지 이동(D를 만나기 전, 보드 벗어나기 전)
if !visited[next] : que.append()
