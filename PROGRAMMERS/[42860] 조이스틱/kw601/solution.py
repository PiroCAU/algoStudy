def solution(name):
    answer = 0
    # 1. 각 자리의 알파벳 만들기
    # ord() : 유니코드 변환
    for c in name:
        cnt = min(ord(c) - ord("A"), ord("Z") - ord(c) + 1)
        answer += cnt
    # 2. 좌우 이동
    # 방문해야하는 칸: A가 아닌 칸
    min_move = len(name) - 1

    for i in range(len(name)):
        next = i + 1
        while next < len(name) and name[next] == "A":
            next += 1
        # 1) 만나면 되돌아가서 거꾸로
        move_left = 2 * i + (len(name) - next)
        # 2) A 덩어리 지나치기
        move_right = (len(name) - next) * 2 + i

        min_move = min(min_move, move_left, move_right)

    return min_move + answer
