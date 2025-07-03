import sys

data = sys.stdin.read().splitlines()

n = int(data[0])

wine = [0] + list(map(int, data[1:]))  # wine[1]부터 와인 양 시작

dp = [0] * (n + 1)

if n >= 1:
    dp[1] = wine[1]
if n >= 2:
    dp[2] = wine[1] + wine[2]

for i in range(3, n + 1):
    # dp[i]: 마시지 않음 / 지금 전 마심 / 지금만 마심
    dp[i] = max(dp[i - 1], wine[i] + wine[i - 1] + dp[i - 3], wine[i] + dp[i - 2])

print(max(dp))
