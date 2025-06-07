def solution(targets):
    targets.sort(key=lambda x: x[1])
    print(targets)
    answer = 0
    end = 0

    # 시작 >= end: 겹치는 부분 없음 -> 새로운 요격 필요
    for t in targets:
        if t[0] >= end:
            answer += 1
            end = t[1]

    return answer
