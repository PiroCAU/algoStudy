import sys
from collections import deque


input = sys.stdin.read
data = input().strip().split("\n")

n, m = map(int, data[0].split())
maps = [list(map(int, data[1 + i].strip())) for i in range(n)]
visited = [[[0] * 2 for _ in range(m)] for _ in range(n)]
# [0][0] -> 첫 번째는 벽 안 부수고 도달한 거리, 두 번째는 벽 부수고 도달한 거리
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

que = deque()
# 시작 -> (0,0), 벽 안부숨
que.append((0, 0, 0))
visited[0][0][0] = 1

while que:
    cx, cy, is_broken = que.popleft()
    # 도착함! 먼저 도착하는게 가장 빠른 경로
    if cx == n - 1 and cy == m - 1:
        print(visited[cx][cy][is_broken])
        exit()

    for i in range(4):
        nx = cx + dx[i]
        ny = cy + dy[i]
        if 0 <= nx < n and 0 <= ny < m:
            # 벽 X, 방문한 적 없음 // 벽은 부쉈든 안부쉈든 상관 없으므로 받은 그대로 전달
            if maps[nx][ny] == 0 and visited[nx][ny][is_broken] == 0:
                # 지금 이동한 경로 + 1
                visited[nx][ny][is_broken] = visited[cx][cy][is_broken] + 1
                que.append((nx, ny, is_broken))
            # 벽 O, 부순 적 없음
            elif maps[nx][ny] == 1 and is_broken == 0:
                # 벽 부순 횟수 저장 칸에 + 1
                visited[nx][ny][1] = visited[cx][cy][0] + 1
                que.append((nx, ny, 1))
            # 이미 방문 / 벽인데 이미 벽 부순 경우
            else:
                continue
print(-1)
