T = int(input())

# import sys


# input = sys.stdin.read
# data = input().strip().split("\n")
def dfs(cur):
    for neighborIDX in linked[cur]:
        if not visited[neighborIDX]:
            visited[neighborIDX] = True
            dfs(neighborIDX)


# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, m = map(int, input().split())

    # n+1 -> 1부터 시작하기
    linked = [[] for _ in range(n + 1)]
    visited = [False] * (n + 1)
    for i in range(m):
        # 아는 사람들 입력 -> linkedList
        a, b = map(int, input().split())
        linked[a].append(b)
        linked[b].append(a)

    # 건너 건너 아는 사람이면 같은 무리 -> DFS
    cnt = 0
    for i in range(1, n + 1):
        if not visited[i]:
            visited[i] = True
            cnt += 1
            dfs(i)

    print(f"#{test_case} {cnt}")
