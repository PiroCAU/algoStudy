import sys

# 입력
# 테스트 케이스 수
# N
# 부모 자식

# 등장한 노드들 모으기
# parent 확인
# 없으면 -> 부모

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    n = int(input())
    parent = dict()

    # n - 1개의 줄에 간선
    for _ in range(n - 1):
        p, c = map(int, input().split())
        parent[c] = p

    # 공통 조상 찾을 노드
    n1, n2 = map(int, input().split())

    # 방문 여부 확인
    visited = set()

    # n1의 조상들 찾기
    while n1 in parent:
        visited.add(n1)
        n1 = parent[n1]
    visited.add(n1)

    # n2의 조상들 찾기 -> 공통 조상 겹치기 전까지
    while n2 not in visited:
        n2 = parent[n2]

    print(n2)
