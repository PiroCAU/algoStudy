# 연결된 길끼리 사이클 만들고, 사이클 수로
def find_root(x, y):
    if root[x][y] != (x, y):
        px, py = root[x][y]
        root[x][y] = find_root(px, py)
    return root[x][y]


def set_union(a, b):
    ar = find_root(*a)
    br = find_root(*b)
    if ar != br:
        root[br[0]][br[1]] = ar


import sys

sys.setrecursionlimit(10000)

data = sys.stdin.read().splitlines()
# data = ["3 4", "DLLL", "DRLU", "RRRU"]
n, m = map(int, data[0].split())

maps = [list(row) for row in data[1:]]

# 자기 자신이 root인 리스트 생성
root = [[(i, j) for j in range(m)] for i in range(n)]

dx = {"U": -1, "D": 1, "L": 0, "R": 0}
dy = {"U": 0, "D": 0, "L": -1, "R": 1}

for i in range(n):
    for j in range(m):
        nx = i + dx[maps[i][j]]
        ny = j + dy[maps[i][j]]
        set_union((i, j), (nx, ny))

# 개수 세기
roots = set()
for i in range(n):
    for j in range(m):
        roots.add(find_root(i, j))

print(len(roots))
