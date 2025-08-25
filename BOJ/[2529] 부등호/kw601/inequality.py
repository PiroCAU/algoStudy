import sys

input = sys.stdin.readline

N = int(input().strip())
ine = input().split()

check = [False] * 10
order = []
result = ""


def possible(a, b, sign):
    return a < b if sign == "<" else a > b


def dfs(idx, digits):
    global result

    if result != "":
        return

    if idx == N + 1:
        result = "".join(map(str, digits))
        return

    for d in order:
        if check[d]:
            continue
        if idx == 0 or possible(digits[-1], d, ine[idx - 1]):
            check[d] = True
            digits.append(d)

            dfs(idx + 1, digits)

            if result != "":
                return

            # 백트래킹
            digits.pop()
            check[d] = False


order = list(range(9, -1, -1))
check = [False] * 10
result = ""
dfs(0, [])
max_value = result

order = list(range(10))
check = [False] * 10
result = ""
dfs(0, [])
min_value = result

print(max_value)
print(min_value)


"""
문제 이해
부등호 주면, 부등호 사이에 들어갈 수 있는 숫자 중 최대, 최소 찾아서 출력

DFS
dfs(i, digits): 0부터
check[i] = false
부등호 되는지 확인하고
dfs(i+1, digits) 
안되면 break;
check[i] = false

"""
