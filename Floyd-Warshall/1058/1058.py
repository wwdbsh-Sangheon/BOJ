n = int(input())
INF = int(1e9)
graph = []
for _ in range(n):
    graph.append([1 if c == 'Y' else INF for c in input()])

for mid in range(n):
    for a in range(n):
        for b in range(n):
            graph[a][b] = min(graph[a][b], graph[a][mid]+graph[mid][b])

dist = 0
temp = 0
for a in range(n):
    for b in range(n):
        if a != b:
            if graph[a][b] <= 2:
                temp += 1
    dist = max(dist, temp)
    temp = 0
print(dist)