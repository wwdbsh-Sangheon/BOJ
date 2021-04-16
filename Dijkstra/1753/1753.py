import heapq
import sys
input = sys.stdin.readline

INF = int(1e9)
v, e = map(int, input().split())
k = int(input())
graph = [[] for _ in range(v+1)]
dist = [INF for _ in range(v+1)]
for _ in range(e):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

def dijkstra():
    pq = []
    heapq.heappush(pq, (0, k))
    dist[k] = 0
    while pq:
        d, now = heapq.heappop(pq)
        if d > dist[now]: continue
        for i in graph[now]:
            cost = d + i[1]
            if cost < dist[i[0]]:
                dist[i[0]] = cost
                heapq.heappush(pq, (cost, i[0]))

dijkstra()
for d in dist[1:]:
    print(d if d != INF else "INF")
