def dfs(cur_idx, group, visited, cards):
    if not visited[cur_idx]:
        visited[cur_idx] = True
        group.add(cur_idx)
        return dfs(cards[cur_idx] - 1, group, visited, cards)
    else:
        return len(group)


def solution(cards):
    answer = []

    global visited
    visited = [False] * len(cards)

    for i in range(0, len(cards)):
        if not visited[i]:
            answer.append(dfs(i, set(), visited, cards))

    if len(answer) < 2:
        return 0
    else:
        answer.sort(reverse=True)
        return answer[0] * answer[1]
