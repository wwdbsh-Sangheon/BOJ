from collections import deque

def get_dist(a, b):
    return abs(a[0]-b[0]) + abs(a[1]-b[1])

def bfs():
    q = deque()
    chk[0] = True
    q.append(0)
    while len(q) != 0:
        now = q.popleft()
        for next in graph[now]:
            if chk[next] is False:
                chk[next] = True
                q.append(next)

t = int(input())
while t > 0:
    n = int(input())
    place = []
    for _ in range(n+2):
        place.append(list(map(int, input().split())))
    chk = [False for _ in range(n+2)]
    graph = [[] for _ in range(n+2)]
    for i in range(n+2):
        for j in range(i+1, n+2):
            if get_dist(place[i], place[j]) <= 1000:
                graph[i].append(j)
                graph[j].append(i)
    bfs()
    print("happy") if chk[n+1] else print("sad")
    t -= 1