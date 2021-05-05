from collections import deque

n, m = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input())))
visited = [[[0]*2 for _ in range(m)] for _ in range(n)]
direction = [(1, 0), (0, 1), (-1, 0), (0, -1)]

def bfs():
    global visited
    q = deque()
    q.append((0, 0, 1))
    visited[0][0][1] = 1
    while len(q) != 0:
        x, y, z = q.popleft()
        if x == n-1 and y == m-1:
            return visited[x][y][z]
        for d in direction:
            nx = x + d[0]
            ny = y + d[1]
            if nx >= 0 and nx < n and ny >= 0 and ny < m:
                if board[nx][ny] == 1 and z == 1:
                    visited[nx][ny][0] = visited[x][y][1]+1
                    q.append((nx, ny, 0))
                elif board[nx][ny] == 0 and visited[nx][ny][z] == 0:
                    visited[nx][ny][z] = visited[x][y][z]+1
                    q.append((nx, ny, z))
    return -1

if n == 1 and m == 1:
    print(1)
else:
    print(bfs())
