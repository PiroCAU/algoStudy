def dfs(idx, remain, arrows):
    global best, best_sco

    if idx == 11:
        # 남은 화살은 최저점에
        if remain != 0:
            arrows[10] += remain

        sco = score(apeach, arrows)
        if sco > best_sco:
            best_sco = sco
            best = arrows[:]

        elif sco == best_sco:
            # 낮은 점수 비교
            for i in range(10, -1, -1):
                if arrows[i] > best[i]:
                    best = arrows[:]
                    break
                elif arrows[i] < best[i]:
                    break
        else:
            pass

        if remain != 0:
            arrows[10] -= remain

        return

    # 어피치 이기기

    needed = apeach[idx] + 1
    if remain >= needed:
        arrows[idx] = needed
        dfs(idx + 1, remain - needed, arrows)
        arrows[idx] = 0

    # 안 이기기
    dfs(idx + 1, remain, arrows)

    return


def score(apeach, ryan):
    sco_apeach = 0
    sco_ryan = 0
    for i in range(11):
        if apeach[i] == 0 and ryan[i] == 0:
            continue
        if ryan[i] > apeach[i]:
            sco_ryan += 10 - i
        else:
            sco_apeach += 10 - i

    return sco_ryan - sco_apeach


def solution(n, info):
    global apeach
    global best, best_sco
    best_sco = 0
    best = [0] * 11

    apeach = info
    answer = dfs(0, n, [0] * 11)
    return best if best_sco > 0 else [-1]
