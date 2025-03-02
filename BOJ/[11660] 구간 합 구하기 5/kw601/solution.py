import sys

input = sys.stdin.read

data = input().strip().split("\n")

n, m = map(int, data[0].split())
nums = [list(map(int, data[i + 1].split())) for i in range(n)]

# +1한 이유: n-1 안하고 n으로 인덱스에 접근하기 위함
prefix = [[0] * (n + 1) for _ in range(n + 1)]

for i in range(n):
    for j in range(n):
        prefix[i + 1][j + 1] = (
            nums[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j]
        )

result = []

# prefix: nums[나] + prefix[내위] + prefix[내 왼쪽] - prefix[대각선] -> 내 위 + 내 왼쪽 하면 대각선 부분이 두 번 더해짐
for i in range(m):
    x1, y1, x2, y2 = map(int, data[n + 1 + i].split())
    sum_value = (
        prefix[x2][y2]
        - prefix[x1 - 1][y2]
        - prefix[x2][y1 - 1]
        + prefix[x1 - 1][y1 - 1]
    )
    result.append(sum_value)

print("\n".join(map(str, result)))
