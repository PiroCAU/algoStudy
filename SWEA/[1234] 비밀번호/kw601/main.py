T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    # 입력 받고
    length, password = map(str, input().split())
    # 스택 만들고
    stack = []

    for s in password:
        # 빈 스택이 아니고 peek == s이면
        if stack and stack[-1] == s:
            stack.pop()
        else:
            stack.append(s)

    result = "".join(stack)
    print(f"#{test_case} {result}")
