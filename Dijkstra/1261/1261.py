import heapq
import sys
input = sys.stdin.readline

INF = int(1e9)
m, n = map(int, input().split())
dist = [[INF for _ in range(m)] for _ in range(n)]
direction = [(1, 0), (0, 1), (-1, 0), (0, -1)]
board = []
for i in range(n):
    board.append([int(c) for c in input()[:-1]])
    
def dijkstra():
    pq = []
    heapq.heappush(pq, (0, 0, 0))
    dist[0][0] = 0
    while pq:
        c, x, y = heapq.heappop(pq)
        if c > dist[x][y]:
            continue
        for d in direction:
            nx = x + d[0]
            ny = y + d[1]
            if nx >= 0 and nx < n and ny >= 0 and ny < m and board[nx][ny] != -1:
                cost = c + 1 if board[nx][ny] == 1 else c
                if cost < dist[nx][ny]:
                    dist[nx][ny] = cost
                    heapq.heappush(pq, (cost, nx, ny))
                    board[nx][ny] = -1
                    
dijkstra()
print(dist[n-1][m-1])