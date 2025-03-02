T = int(input())
# 아니 이거 크루스칼이라고...? 나 왜 기억이 안나지

# 1 - 2 - 3 연결
# parent[3] = 2, parent[2] = 1, parent[1] = 1
# find(parent배열, 3)
# parent[3] -> 2 != 3
# parent[3] = find(parent배열, 2)
# -> find(3, 1)
# parent[1] = 1이므로, parent[3] = 1, return 1
# 다음에 find(parent배열, 3)을 실행
# parent[3] = 1이므로, 바로 Return 1


def find(parent, x):
    if parent[x] != x:
        parent[x] = find(parent, parent[x])
    return parent[x]


def union(parent, a, b):
    # a랑 아는 사이 타고 타고 올라가기
    rootA = find(parent, a)
    # b랑 아는 사이 타고 타고 올라가기
    rootB = find(parent, b)
    # 만약 둘이 다르면
    if rootA != rootB:
        # b의 parent를 a로 지정
        parent[rootB] = rootA


# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    n, m = map(int, input().split())

    # 1 ~ n까지 자기 자신을 대표로하는 그룹을 가짐
    parent = list(range(n + 1))

    for i in range(m):
        a, b = map(int, input().split())
        # a와 b를 묶음
        union(parent, a, b)

    roots = set()
    for i in range(1, n + 1):
        roots.add(find(parent, i))

    print(f"#{test_case} {len(roots)}")
