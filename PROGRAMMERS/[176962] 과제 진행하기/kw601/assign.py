def solution(plans):
    answer = []

    # 시간을 분 단위로 변환하는 함수
    def to_minutes(t):
        h, m = map(int, t.split(":"))
        return h * 60 + m

    # plans: [name, start, playtime] -> 분 단위로 바꿔주기
    plans = [
        [name, to_minutes(start), int(playtime)] for name, start, playtime in plans
    ]

    # 시작 순 정렬
    plans.sort(key=lambda x: x[1])

    stack = []
    for i in range(len(plans)):
        name, start, playtime = plans[i]

        # ?? 마지막 과제인 경우 next_start 시간을 엄청 크게 잡아서 인덱스 오류 방지
        next_start = plans[i + 1][1] if i + 1 < len(plans) else 10**9

        # 과제 끝내기 가능
        if start + playtime <= next_start:
            answer.append(name)
            remain = next_start - (start + playtime)

            # 남은 시간: 하다 만 과제 하기
            while stack and remain > 0:
                prev_name, prev_time = stack.pop()
                # 다 할 수 있으면
                if prev_time <= remain:
                    answer.append(prev_name)
                    remain -= prev_time
                else:
                    # 못하면 남은거 다시 넣기
                    stack.append([prev_name, prev_time - remain])
                    break
        else:
            # 시간 내에 과제 다 못하면 넣기
            stack.append([name, playtime - (next_start - start)])

    # 남은 과제들 하기
    while stack:
        answer.append(stack.pop()[0])

    return answer


"""
새 과제 시작 시간인데 하던 거 있으면 진행 중이던 거 멈추고 새로 시작

끝났는데 멈춘 거 있으면 멈춘 거 이어서
    -> 새로 시작 vs 멈춤: 새로 지삭
    -> 멈춘 과제 여러 개: 최근 멈춘 과제부터

스택? 

"""
