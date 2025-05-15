import heapq
import sys

heap = []

data = sys.stdin.read().splitlines()
n = int(data[0])

for i in map(int, data[1:]):
    if i == 0:
        if not heap:
            print(0)
        else:
            print(-heapq.heappop(heap))
    else:
        heapq.heappush(heap, -i)
