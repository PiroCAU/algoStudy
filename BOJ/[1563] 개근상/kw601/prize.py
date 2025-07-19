import sys

# 지각 두 번 이상
# 결석 세 번 연속 -> 개근상 X
# O 출석 L 지각 A 결석
input = sys.stdin.readline

n = int(input())

# dp[날짜][지각][결석]
dp = [[[0] * 3 for _ in range(2)] for _ in range(n + 1)]
dp[0][0][0] = 1

# 오늘이 day일 때
for day in range(n):
    # 지각이 지금까지 late번, 최대 1
    for late in range(2):
        # 연속 결석이 absent번, 최대 2
        for absent in range(3):
            # 지금까지 오는 경우의 수
            cur = dp[day][late][absent]

            # 출석
            dp[day + 1][late][0] += cur % 1000000
            # 지각
            if late + 1 < 2:
                dp[day + 1][late + 1][0] += cur % 1000000
            # 결석
            if absent + 1 < 3:
                dp[day + 1][late][absent + 1] += cur % 1000000


result = 0
for late in range(2):
    for absent in range(3):
        result += dp[n][late][absent]
print((result % 1000000))
