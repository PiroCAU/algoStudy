import heapq


def solution(n, k, enemy):
    answer = 0
    maxheap = []
    # 게임 라운드보다 무적권의 수가 많을 경우
    if len(enemy) < k:
        return len(enemy)

    for i in range(len(enemy)):
        heapq.heappush(maxheap, -enemy[i])

        # 질 경우
        if n < enemy[i]:
            if k == 0:
                return i
            max_enemy = -heapq.heappop(maxheap)
            k -= 1
            n += max_enemy

        n -= enemy[i]
        # 졌음
        if n < 0:
            return i

    return len(enemy)
