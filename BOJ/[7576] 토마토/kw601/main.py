import sys
from collections import deque

input = sys.stdin.read
data = input().strip().split("\n")

m, n = map(int, data[0].split())
nums = [list(map(int, data[i + 1].split())) for i in range(n)]
que = deque()

# 토마토가 있으면 주변에 영향 -> 전부 행렬에 넣음
for i in range(n):
    for j in range(m):
        if nums[i][j] == 1:
            que.append((i, j))

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

while que:
    # 하나 꺼내서
    cx, cy = que.popleft()
    for d in range(4):
        nx, ny = cx + dx[d], cy + dy[d]
        # 옆에 토마토 있고 안 익었으면
        if 0 <= nx < n and 0 <= ny < m and nums[nx][ny] == 0:
            # 토마토 익음!
            nums[nx][ny] = nums[cx][cy] + 1  # 익으려면 지금보다 하루 더 걸림
            # 이제 다음 차례엔 얘도 영향을 줆
            que.append((nx, ny))

days = -1
for i in range(n):
    for j in range(m):
        if nums[i][j] == 0:
            print(-1)
            exit()
        days = max(days, nums[i][j])

print(days - 1)  # 처음부터 익어있던 토마토가 1
