import sys
sys.setrecursionlimit(10000)

n, m = map(int, input().split())
direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
board = []
for _ in range(n):
    board.append(list(input()))


def dfs(x, y):
    for i in range(4):
        nx = x + direction[i][0]
        ny = y + direction[i][1]
        if nx >= 0 and nx < n and ny >= 0 and ny < m and board[nx][ny] == "0":
            board[nx][ny] = "1"
            dfs(nx, ny)

count = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == "0":
            board[i][j] = "1"
            count += 1
            dfs(i, j)
print(count)
