def solution(picks, minerals):

    total_pick = min(sum(picks) * 5, len(minerals))
    answer = 0

    # 다이아몬드 0 철 1 돌 2
    mine = []
    temp = [0, 0, 0]
    # 광물 5개씩 끊어서 temp에 넣기
    for i in range(total_pick):
        if minerals[i] == "diamond":
            temp[0] += 1
        elif minerals[i] == "iron":
            temp[1] += 1
        else:
            temp[2] += 1

        if (i + 1) % 5 == 0 or i == (total_pick - 1):
            if temp != [0, 0, 0]:
                mine.append(temp)
                temp = [0, 0, 0]

    mine.sort(key=lambda x: (x[0], x[1], x[2]), reverse=True)

    for m in mine:
        if picks[0] > 0:
            picks[0] -= 1
            answer += m[0] * 1 + m[1] * 1 + m[2] * 1
        elif picks[1] > 0:
            picks[1] -= 1
            answer += m[0] * 5 + m[1] * 1 + m[2] * 1

        elif picks[2] > 0:
            picks[2] -= 1
            answer += m[0] * 25 + m[1] * 5 + m[2] * 1

        # 이제 곡괭이 없으면
        else:
            return answer
    return answer
