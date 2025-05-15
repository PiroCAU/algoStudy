import sys
from collections import deque


def D(n):
    return (2 * n) % 10000


def S(n):
    return (n + 10000 - 1) % 10000


def L(n):
    return (n % 1000) * 10 + n // 1000


def R(n):
    return (n % 10) * 1000 + n // 10
    # 이렇게 문자열로 돌릴 수도 있음
    # s = str(n).zfill(4)
    # sR = s[-1] + s[:-1]
    # return int(sR)


# 이랬더니 시간초과
def DSLR(cmd, n):
    if cmd == "D":
        return D(n)
    elif cmd == "S":
        return S(n)
    elif cmd == "L":
        return L(n)
    else:
        return R(n)


def bfs(start, target):
    que = deque()
    visited = [False] * 10000

    que.append((start, ""))
    visited[start] = True
    cmd_li = ["D", "S", "L", "R"]

    while que:
        cur, cmd = que.popleft()

        if cur == target:
            print(cmd)
            return

        # DSLR 계산 해보기
        for c in cmd_li:
            next = DSLR(c, cur)
            if not visited[next]:
                visited[next] = True
                que.append((next, cmd + c))

        # for op, func in zip("DSLR", [D, S, L, R]):
        #     nxt = func(cur)
        #     if not visited[nxt]:
        #         visited[nxt] = True
        #         que.append((nxt, cmd + op))
    return -1


data = sys.stdin.read().splitlines()
# data = ["3", "1234 3412", "1000 1", "1 16"]

n = int(data[0])

for line in data[1:]:
    num, target = map(int, line.split())
    bfs(num, target)
