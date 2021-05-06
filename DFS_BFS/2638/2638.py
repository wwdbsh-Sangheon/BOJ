import sys
sys.setrecursionlimit(10000)

n, m = map(int, input().split())
board = []
visited = [[False]*m for _ in range(n)]
cheese_count = 0
for _ in range(n):
    line = []
    for i in list(map(int, input().split())):
        if i == 1:
            cheese_count += 1
        line.append(i)
    board.append(line)
direction = [(1, 0), (-1, 0), (0, 1), (0, -1)]

def dfs(x, y):
    for d in direction:
        nx = x + d[0]
        ny = y + d[1]
        if nx >= 0 and nx < n and ny >= 0 and ny < m:
            if board[nx][ny] != 0:
                board[nx][ny] += 1
            if not visited[nx][ny] and board[nx][ny] == 0:
                visited[nx][ny] = True
                dfs(nx, ny)

def melt():
    global cheese_count, board
    for i in range(n):
        for j in range(m):
            if board[i][j] > 2:
                board[i][j] = 0
                cheese_count -= 1
            elif board[i][j] == 2:
                board[i][j] = 1

t = 0
while cheese_count != 0:
    visited[0][0] = True
    dfs(0, 0)
    visited = [[False]*m for _ in range(n)]
    melt()
    t += 1
print(t)