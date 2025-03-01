# dfs 완전탐색 max_depth=4 ... ㅗ 이건?
def dfs(x, y, cnt, val):
    global max_val
    if cnt == 4:
        max_val = max(max_val, val)
        return

    for i in range(4):
        cx, cy = x + dx[i], y + dy[i]
        if 0 <= cx < n and 0 <= cy < m and not visited[cx][cy]:
            visited[cx][cy] = True
            dfs(cx, cy, cnt + 1, val + number_list[cx][cy])
            visited[cx][cy] = False  # 다른 모양 탐색할 때 또 봐야함(밑에서)


# ㅜ
def dfs_u(x, y):
    global max_val
    shape = [
        [(0, 0), (0, 1), (0, 2), (1, 1)],  # ㅗ
        [(0, 1), (1, 0), (1, 1), (2, 1)],  # ㅓ
        [(1, 0), (1, 1), (1, 2), (0, 1)],  # ㅜ
        [(0, 0), (1, 0), (2, 0), (1, 1)],  # ㅏ
    ]
    for s in shape:
        temp = 0
        valid = True
        for dx, dy in s:
            nx, ny = x + dx, y + dy
            if not (0 <= nx < n and 0 <= ny < m):
                valid = False
                break
            temp += number_list[nx][ny]

        if valid:
            max_val = max(max_val, temp)


global max_val
max_val = -1
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
n, m = map(int, input().split())
number_list = []

for i in range(n):
    row = map(int, input().split())
    number_list.append(list(row))

visited = [[False] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i, j, 1, number_list[i][j])
        visited[i][j] = False
        dfs_u(i, j)

print(max_val)
