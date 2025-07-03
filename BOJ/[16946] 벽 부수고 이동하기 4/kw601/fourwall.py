import sys
from collections import deque


def bfs(x, y):
    cnt = 0
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    maps[x][y] = area_id
    cnt += 1

    while q:
        cx, cy = q.popleft()
        for dir in range(4):
            nx, ny = cx + dx[dir], cy + dy[dir]
            if 0 <= nx < n and 0 <= ny < m:
                if not visited[nx][ny] and board[nx][ny] == "0":
                    visited[nx][ny] = True
                    maps[nx][ny] = area_id
                    cnt += 1
                    q.append((nx, ny))
    return cnt


data = sys.stdin.read().splitlines()
# data = ["4 5", "11001", "00111", "01010", "10101"]

n, m = map(int, data[0].split())

board = [list(data[i + 1]) for i in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

maps = [[-1] * m for _ in range(n)]
visited = [[False] * m for _ in range(n)]
area_size = {}
area_id = 1

# 그룹화
for i in range(n):
    for j in range(m):
        if not visited[i][j] and board[i][j] == "0":
            size = bfs(i, j)
            area_size[area_id] = size
            area_id += 1

# 출력
result = [[0] * m for _ in range(n)]
for i in range(n):
    for j in range(m):
        if board[i][j] == "1":
            near = set()
            total = 1

            for idx in range(4):
                ni = i + dx[idx]
                nj = j + dy[idx]
                if 0 <= ni < n and 0 <= nj < m:
                    aid = maps[ni][nj]
                    if aid != -1:
                        near.add(aid)

            for ids in near:
                total += area_size[ids]
            result[i][j] = total % 10
        else:
            result[i][j] = 0

for i in range(n):
    print("".join(map(str, result[i])))
