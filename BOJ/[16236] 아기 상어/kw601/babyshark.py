import sys
from collections import deque


def bfs(start, shark_size=2):
    que = deque()
    que.append((start[0], start[1], 0))
    visited = [[False] * n for _ in range(n)]

    visited[start[0]][start[1]] = True
    fish_list = []
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while que:
        x, y, distance = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                fish = maps[nx][ny]

                # 물고기가 상어보다 작으면 먹을 수 있음, 0, 같으면 이동 가능
                if fish <= shark_size:
                    visited[nx][ny] = True
                    que.append((nx, ny, distance + 1))

                    # 먹을 수 있음
                    if 0 < fish < shark_size:
                        fish_list.append((distance + 1, nx, ny))

    return fish_list


data = sys.stdin.read().splitlines()
# data = list(map(str, sys.stdin.readlines()))
global n

n = int(data[0])
maps = [list(map(int, line.split())) for line in data[1:]]
survive_time = 0
eat_cnt = 0
shark_size = 2

# 아기 상어 위치 찾기
for i in range(n):
    for j in range(n):
        if maps[i][j] == 9:
            baby_shark = (i, j)
            maps[i][j] = 0

while True:
    fish_list = bfs(baby_shark, shark_size)

    if not fish_list:
        break

    fish_list.sort()
    distance, x, y = fish_list[0]

    # 상어 이동, 먹기
    baby_shark = (x, y)
    maps[x][y] = 0
    survive_time += distance
    eat_cnt += 1

    if eat_cnt == shark_size:
        shark_size += 1
        eat_cnt = 0

print(survive_time)
