# 10 * 10 종이
# 1은 모두 색종이로 덮임, 0은 색종이 X
import sys

input = sys.stdin.read

data = input().strip().split("\n")
board = [list(map(int, line.split())) for line in data]

paper_cnt = [5] * 6  # size 1 ~ 5 5장씩 사용 가능
min_cnt = 26  # 최대 색종이 25개 사용 가능


# 1을 만나면, 가장 큰 사이즈부터 붙여보기
def dfs(x, y, used_papers):
    global min_cnt

    # 25장 다 썼으면 실패
    if used_papers >= min_cnt:
        return

    # 10 * 10 행렬이므로
    if y >= 10:
        dfs(x + 1, 0, used_papers)
        return

    if x >= 10:
        min_cnt = min(min_cnt, used_papers)
        return

    # 현재 위치가 1이면 색종이 덮기
    if board[x][y] == 1:
        # 큰 색종이부터 붙여보기(5 -> 1)
        for size in range(5, 0, -1):
            # 삐져나가면 안됨
            if x + size > 10 or y + size > 10:
                continue

            # 덮인 부분 모두 1이어야 함
            placed = True
            for i in range(size):
                for j in range(size):
                    if board[x + i][y + j] == 0:
                        placed = False
                        break
                if not placed:
                    break

            # 색종이 붙이기
            if placed and paper_cnt[size] > 0:
                for i in range(size):
                    for j in range(size):
                        board[x + i][
                            y + j
                        ] = 0  # 색종이 붙임! -> 0으로 처리하기 // 여러번 붙이는거 방지

                paper_cnt[size] -= 1  # n*n 종이 한 장 씀
                dfs(x, y + 1, used_papers + 1)  # 다음 칸 탐색

                # 색종이 떼기(백트래킹...)
                for i in range(size):
                    for j in range(size):
                        board[x + i][y + j] = 1  # 색종이 제거

                paper_cnt[size] += 1
        return

    # 다음 칸으로 이동
    dfs(x, y + 1, used_papers)


# DFS 탐색 시작
dfs(0, 0, 0)

# 출력
print(min_cnt if min_cnt < 25 else -1)
