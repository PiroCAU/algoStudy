def solution(cap, n, deliveries, pickups):
    answer = 0
    # 그리디 알고리즘, 먼 곳부터 가고, 가는 김에 가까운 집 처리
    for i in range(n - 1, -1, -1):
        # i 번째 집에 갈 필요가 있는 한
        while deliveries[i] > 0 or pickups[i] > 0:
            cur_deliver = cap
            cur_pickup = cap

            for j in range(i, -1, -1):
                if cur_deliver <= 0 and cur_pickup <= 0:
                    break
                # 배달
                deliver = min(deliveries[j], cur_deliver)
                deliveries[j] -= deliver
                cur_deliver -= deliver

                # 수거
                pickup = min(pickups[j], cur_pickup)
                pickups[j] -= pickup
                cur_pickup -= pickup
            answer += (i + 1) * 2

    return answer
