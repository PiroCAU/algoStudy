# ~아~~ 실패
import sys

input = sys.stdin.read
data = input().strip().split("\n")

N = int(data[0])
board = [list(map(int, line.split())) for line in data[1:]]
# 초기값 최소: inf
diff = float("inf")

# 가능한 모든 (x, y, d1, d2) 조합 탐색... 아니 이거 맞음?
for x in range(N):
    for y in range(N):
        # d1, d2는 1 이상
        for d1 in range(1, N):
            for d2 in range(1, N):
                if x + d1 + d2 >= N or y - d1 < 0 or y + d2 >= N:
                    continue  # range 밖이면 pass

                # 5번 구역 경계선 표시
                boundary = [[0] * N for _ in range(N)]

                for i in range(d1 + 1):
                    boundary[x + i][y - i] = 5  # 왼쪽 아래 /
                    boundary[x + d2 + i][y + d2 - i] = 5  # 오른쪽 위 /

                for i in range(d2 + 1):
                    boundary[x + i][y + i] = 5  # 오른쪽 아래 \
                    boundary[x + d1 + i][y - d1 + i] = 5  # 왼쪽 위 \

                # 5번 구역 내부 채우기
                for i in range(x + 1, x + d1 + d2):
                    inside = False
                    for j in range(N):
                        if boundary[i][j] == 5:
                            inside = not inside  # 경계 만나면 안쪽 / 바깥 구분
                        if inside:
                            boundary[i][j] = 5

                # 1~4번 구역
                people = [0] * 5

                for i in range(N):
                    for j in range(N):
                        if boundary[i][j] == 5:
                            people[4] += board[i][j]  # 5번 구역
                        elif 0 <= i < x + d1 and 0 <= j <= y:
                            people[0] += board[i][j]  # 1번 구역
                        elif 0 <= i <= x + d2 and y < j < N:
                            people[1] += board[i][j]  # 2번 구역
                        elif x + d1 <= i < N and 0 <= j < y - d1 + d2:
                            people[2] += board[i][j]  # 3번 구역
                        elif x + d2 < i < N and y - d1 + d2 <= j < N:
                            people[3] += board[i][j]  # 4번 구역

                # 최소-최대 인구 차이 계산
                diff = min(diff, max(people) - min(people))

# 출력
print(diff)
