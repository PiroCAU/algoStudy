# 오른쪽 , 왼쪽으로 각 칸에 적혀있는 수만큼 이동
# 0,0 -> n-1, n-1로 가는 경로의 개수
import sys

input = sys.stdin.read

data = input().strip().split("\n")
n = int(data[0])

board = [list(map(int, line.split())) for line in data[1:]]

# DP 초기화
dp = [[0] * n for _ in range(n)]

# 시작!
dp[0][0] = 1

# DP / 오른쪽, 아래쪽으로 감
# 점화식: dp[i][j + move] += dp[i][j], dp[i + move][j] += dp[i][j]
for i in range(n):
    for j in range(n):
        if i == n - 1 and j == n - 1:
            continue

        move = board[i][j]
        if move > 0:
            # 오른쪽 점프
            if j + move < n:
                dp[i][j + move] += dp[i][j]
            # 아래쪽 점프
            if i + move < n:
                dp[i + move][j] += dp[i][j]

print(dp[n - 1][n - 1])
