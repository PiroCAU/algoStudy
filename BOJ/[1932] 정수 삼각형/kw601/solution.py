import sys

inputs = sys.stdin.read().splitlines()

n = int(inputs[0])
triangle = [list(map(int, l.split())) for l in inputs[1:]]

# dp 행렬 초기화
dp = [row[:] for row in triangle]

for i in range(len(triangle) - 2, -1, -1):
    for j in range(len(triangle[i])):
        try:
            dp[i][j] = triangle[i][j] + max(dp[i + 1][j], dp[i + 1][j + 1])
        except:
            continue
print(dp[0][0])
