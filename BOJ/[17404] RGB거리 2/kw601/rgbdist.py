import sys

data = sys.stdin.read().splitlines()
# data = "3\n26 40 83\n49 60 57\n13 89 99\n"
n = int(data[0])
maps = [list(map(int, row.split())) for row in data[1:]]

INF = int(1e9)
answer = INF

# 0 빨 1 초 2 파
for first_color in range(3):
    dp = [[INF] * 3 for _ in range(n)]
    dp[0][first_color] = maps[0][first_color]

    for i in range(1, n):
        dp[i][0] = maps[i][0] + min(dp[i - 1][1], dp[i - 1][2])
        dp[i][1] = maps[i][1] + min(dp[i - 1][0], dp[i - 1][2])
        dp[i][2] = maps[i][2] + min(dp[i - 1][0], dp[i - 1][1])

    # 마지막 -> 첫 번째랑 다른 색
    for last_color in range(3):
        if last_color != first_color:
            answer = min(answer, dp[n - 1][last_color])

print(answer)
