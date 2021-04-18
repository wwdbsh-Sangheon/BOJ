import sys
input = sys.stdin.readline

n, m = map(int, input().split())
INF = int(1e9)
graph = [[INF for _ in range(n+1)] for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1

for mid in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            if a == b: graph[a][b] = 0
            graph[a][b] = min(graph[a][b], graph[a][mid]+graph[mid][b])
ans = 0
for student in range(1, n+1):
    tot = 0
    for i in range(1, n+1):
        if student == i: continue
        if graph[student][i] != INF:
            tot += 1
        if graph[i][student] != INF:
            tot += 1
    if tot == n-1: ans += 1
print(ans)