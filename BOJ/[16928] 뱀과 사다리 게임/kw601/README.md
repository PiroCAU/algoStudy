### 생각

주사위의 최소... 얘도 dp일까...?
최단거리면 bfs인가
가중치 없으니까 bfs

### 입력

사다리 수(n) 뱀 수(m)
n줄: 사다리 정보 (x,y) : x->y
m줄: 뱀 정보(u, v): u->v

### 로직

1번 시작, 100번으로
(cur, cnt) que에 저장

주사위는 1~6까지 나오니까, 1~6까지 반복

1. 사다리나 뱀 체크하고
2. 방문했는지 확인하고
3. que.append()

   다음 = cur + 주사위
   if !visited
   if 사다리|| 뱀:
   move
   visited = True
   que.append((다음, cnt++))
