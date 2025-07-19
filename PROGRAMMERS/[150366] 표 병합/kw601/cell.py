# 크기 50 * 50
# 문자열 값을 가지고, 병합 가능
# UPDATE r c value -> r,c = value
# UPDATE value1 value2 -> find value -> value2
# MERGE r1 c1 r2 c2 -> 병합...
# 한 셀이 가지고 있으면 그 값을 가짐
# 두 셀 모두 가지면 r1 c1 값 가짐
# 이후 어느 위치 선택하여도 병합한 셀로 접근
# UNMERGE r c -> 병합 해제 모든 셀은 프로그램 실행 초기로
# 병합 해제 전 값이 있으면 r c 위치가 보유
# PRINT r c -> 출력


def solution(commands):
    answer = []
    # (r, c) → idx = (r - 1) * 50 + (c - 1)
    parent = [i for i in range(2500)]
    values = [""] * 2500

    def find(x):
        if parent[x] != x:
            parent[x] = find(parent[x])
        return parent[x]

    def union(a, b):
        parent_a = find(a)
        parent_b = find(b)
        # 같으면 안함
        if parent_a == parent_b:
            return

        # a 비었으면 b 값 추가하기
        if values[parent_a] == "":
            values[parent_a] = values[parent_b]

        # a 기준으로 병합
        for i in range(2500):
            if find(i) == parent_b:
                parent[i] = parent_a

    for command in commands:
        cmd = command.split()
        if cmd[0] == "UPDATE":
            if len(cmd) == 4:
                r, c = map(int, cmd[1:3])
                val = cmd[3]
                idx = (r - 1) * 50 + (c - 1)
                root = find(idx)
                for i in range(2500):
                    if find(i) == root:
                        values[i] = val
            else:
                val1, val2 = cmd[1], cmd[2]
                for i in range(2500):
                    if values[find(i)] == val1:
                        values[find(i)] = val2

        elif cmd[0] == "MERGE":
            c1 = (int(cmd[1]) - 1) * 50 + (int(cmd[2]) - 1)
            c2 = (int(cmd[3]) - 1) * 50 + (int(cmd[4]) - 1)
            union(c1, c2)

        elif cmd[0] == "UNMERGE":
            idx = (int(cmd[1]) - 1) * 50 + (int(cmd[2]) - 1)
            root = find(idx)
            val = values[root]
            for i in range(2500):
                if find(i) == root:
                    parent[i] = i
                    values[i] = ""
            values[idx] = val

        elif cmd[0] == "PRINT":
            idx = (int(cmd[1]) - 1) * 50 + (int(cmd[2]) - 1)
            val = values[find(idx)]
            answer.append(val if val else "EMPTY")

    return answer
