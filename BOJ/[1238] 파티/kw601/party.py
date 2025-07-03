import heapq
import sys


def dijkstra(start, graph):
    dist = [float("inf")] * (n + 1)
    dist[start] = 0
    hq = [(0, start)]

    while hq:
        cost, now = heapq.heappop(hq)

        if cost > dist[now]:
            continue

        for next, weight in graph[now]:
            if dist[next] > cost + weight:
                dist[next] = cost + weight
                heapq.heappush(hq, (dist[next], next))

    return dist


data = sys.stdin.read().splitlines()
n, m, x = map(int, data[0].split())


graph = [[] for _ in range(n + 1)]  # 갔다가
rev_graph = [[] for _ in range(n + 1)]  # 옴

for line in data[1:]:
    a, b, t = map(int, line.split())
    graph[a].append((b, t))
    rev_graph[b].append((a, t))

go = dijkstra(x, graph)
back = dijkstra(x, rev_graph)

max_time = 0
for i in range(1, n + 1):
    total = go[i] + back[i]
    if total < float("inf"):
        max_time = max(max_time, total)

print(max_time)
