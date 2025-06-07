from collections import deque


def solution(board):
    starts = (-1, -1)
    n = len(board)
    m = len(board[0])
    visited = [[False] * m for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if board[i][j] == "R":
                starts = (i, j)

    que = deque()
    moves = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    que.append((starts[0], starts[1], 0))
    visited[starts[0]][starts[1]] = True

    while que:
        cx, cy, cnt = que.popleft()
        if board[cx][cy] == "G":
            return cnt

        for dx, dy in moves:
            nx, ny = cx, cy
            while True:
                tx = nx + dx
                ty = ny + dy
                if 0 <= tx < n and 0 <= ty < m and board[tx][ty] != "D":
                    nx, ny = tx, ty
                else:
                    break
            if not visited[nx][ny]:
                visited[nx][ny] = True
                que.append((nx, ny, cnt + 1))

    return -1
