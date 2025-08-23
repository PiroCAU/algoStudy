import heapq


def solution(k, n, reqs):
    answer = 0
    mentors = list([1] * k)

    request = [[] for _ in range(k)]

    # 유형 별 그룹핑
    for a, b, c in reqs:
        request[c - 1].append((a, b))

    for req in request:
        req.sort(key=lambda x: x[0])  # 상담 시작 시간 기준 sort

    wait_list = [dict() for _ in range(k)]

    def wait_time(u, m):
        # 미리 계산한 값 있다면 꺼내 쓰기(메모이제이션이래...)
        if m in wait_list[u]:
            return wait_list[u][m]

        # 해야 할 상담
        couns = request[u]
        L = len(couns)
        if L == 0 or m >= L:
            wait_list[u][m] = 0
            return 0

        free = [0] * m
        heapq.heapify(free)

        total_wait = 0
        for a, b in couns:
            t = heapq.heappop(free)
            if t > a:
                total_wait += t - a
                end = t + b
            else:
                end = a + b
            heapq.heappush(free, end)

        wait_list[u][m] = total_wait
        return total_wait

    remain = n - k
    cur_wait = [wait_time(u, 1) for u in range(k)]

    while remain > 0:
        best_gain = 0
        best_u = None

        for u in range(k):
            m = mentors[u]

            next_wait = wait_time(u, m + 1)
            gain = cur_wait[u] - next_wait
            if gain > best_gain:
                best_gain = gain
                best_u = u

        if best_u is None or best_gain == 0:
            break

        # 베스트 고정
        mentors[best_u] += 1
        remain -= 1

        # 대기 시간 갱신
        cur_wait[best_u] = wait_time(best_u, mentors[best_u])

    answer = sum(wait_time(u, mentors[u]) for u in range(k))
    return answer


""" 
k 상담 유형
n 멘토 수
reqs[][] 상담 요청
req in reqs: [a, b, c] -> c 유형 상담 원하는 참가자가 a분에 b분 동안의 상담 요청

기다린 시간의 최솟값 return

유형별 멘토 인원은 최소 한 명

일단 한 명씩 배정... -> 시간 가장 많이 줄어드는 한 명 고정

"""
