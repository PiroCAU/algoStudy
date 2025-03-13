import sys

input = sys.stdin.read
data = input().strip().split("\n")

for line in data:
    r1x1, r1y1, r1x2, r1y2, r2x1, r2y1, r2x2, r2y2 = map(int, line.split())

    # 1. "d" (공통 영역 없음)
    if r1x2 < r2x1 or r2x2 < r1x1 or r1y2 < r2y1 or r2y2 < r1y1:
        print("d")

    # 2. "c" (점)
    elif (
        (r1x2 == r2x1 and r1y2 == r2y1)
        or (r1x1 == r2x2 and r1y2 == r2y1)
        or (r1x2 == r2x1 and r1y1 == r2y2)
        or (r1x1 == r2x2 and r1y1 == r2y2)
    ):
        print("c")

    # 3. "b" (선분)
    elif (r1x2 == r2x1 or r1x1 == r2x2) and (r1y1 < r2y2 and r1y2 > r2y1):  # 세로
        print("b")
    elif (r1y2 == r2y1 or r1y1 == r2y2) and (r1x1 < r2x2 and r1x2 > r2x1):  # 가로
        print("b")

    # 4. "a" (직사각형)
    else:
        print("a")
