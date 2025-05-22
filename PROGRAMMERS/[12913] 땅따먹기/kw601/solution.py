def solution(land):
    answer = 0

    dp = [[0] * 4 for _ in range(len(land))]

    # 첫 줄은 land[0]과 동일
    dp[0] = land[0]

    # dp 돌리기
    for i in range(1, len(land)):
        for j in range(4):
            # 같은 열 제외, 윗 줄에서 가장 큰 값 찾기
            max_val = max([dp[i - 1][idx] for idx in range(4) if idx != j])

            dp[i][j] = land[i][j] + max_val

    return max(dp[-1])
