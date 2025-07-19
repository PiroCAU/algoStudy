from collections import deque


# 상 하 좌 우로 이동하며 식량을 먹음
# 완전탐색? bfs
def solution(maps):
    # def를 밖에 뒀더니 오류나서 안으로 넣었습니다...
    def bfs(x, y):
        que = deque()
        que.append((x, y))
        visited[x][y] = True
        food = int(maps[x][y])

        while que:
            cx, cy = que.popleft()
            for dir in range(4):
                nx = cx + dx[dir]
                ny = cy + dy[dir]

                if 0 <= nx < n and 0 <= ny < m:
                    if not visited[nx][ny] and maps[nx][ny] != "X":
                        visited[nx][ny] = True
                        food += int(maps[nx][ny])
                        que.append((nx, ny))
        return food

    answer = []
    n = len(maps)
    m = len(maps[0])
    visited = [[False] * m for _ in range(n)]

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(n):
        for j in range(m):
            if not visited[i][j] and maps[i][j] != "X":
                answer.append(bfs(i, j))
    answer.sort()
    return answer if answer else [-1]
