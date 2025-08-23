def solution(user_id, banned_id):
    answer = set()

    def is_matched(user, banned):
        if len(user) != len(banned):
            return False

        # b가 *이 아니고, u랑 b가 다르면 불량 아님
        for u, b in zip(user, banned):
            if b != "*" and u != b:
                return False
        return True

    def dfs(idx, visited):
        # 끝까지 다 왔음
        if idx == len(banned_id):
            # 중복 방지 -> set으로 만들어서 넣어주기
            # set은 안되고 frozenset이라고 해야한대요...
            answer.add(frozenset(visited))
            return

        for user in user_id:
            # 방문 확인
            if user in visited:
                continue
            # 불량 사용자 잡히는지 확인
            if not is_matched(user, banned_id[idx]):
                continue

            visited.append(user)
            dfs(idx + 1, visited)
            visited.pop()

    dfs(0, [])

    return len(answer)
