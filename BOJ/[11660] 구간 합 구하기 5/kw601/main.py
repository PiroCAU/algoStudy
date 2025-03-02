# 시간 초과~
n, m = map(int, input().split())
nums = []

# 표 입력받기
for i in range(n):
    rows = list(map(int, input().split()))
    nums.append(rows)

# 계산할 좌표들 입력받기
coordinates = []
for j in range(m):
    x1, y1, x2, y2 = map(int, input().split())
    coordinates.append((x1, y1, x2, y2))

# 굳이 안 넣어도 될듯 -> 위에랑 합쳐...
for x1, y1, x2, y2 in coordinates:
    # 시작점(아... 제가 이걸 0부터 시작하게 했어요)
    sx = x1 - 1
    # 끝점
    ex = x2 - 1

    sy = y1 - 1
    ey = y2 - 1
    s = 0

    for i in range(sx, ex + 1, 1):
        for j in range(sy, ey + 1, 1):
            s += nums[i][j]
    print(s)
