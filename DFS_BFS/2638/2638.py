n, m = map(int, input().split())
board = []
visited = [[False for _ in range(m)] for _ in range(n)]
for _ in range(n):
    board.append(list(map(int, input().split())))
direction = [(1, 0), (-1, 0), (0, 1), (0, -1)]

def check(x, y):
    c = 0
    for d in direction:
        nx = x + d[0]
        ny = y + d[1]
        if board[nx][ny] == 0:
            c += 1
        if c == 2:
            return True
    return False

def dfs(x, y):
    for d in direction:
        nx = x + d[0]
        ny = y + d[1]
        if (board[nx][ny] == 1 or board[nx][ny] == 2) and not visited[nx][ny]:
            visited[nx][ny] = True
            if check(nx, ny):
                board[nx][ny] = 2
            dfs(nx, ny)
            visited[nx][ny] = False

def melt():
    global board
    for i in range(n):
        for j in range(m):
            if board[i][j] == 2:
                board[i][j] = 0

def print_board():
    rt = ""
    for i in range(n):
        for j in range(m):
            rt += str(board[i][j]) + " "
        rt += "\n"
    return rt

t = 0
for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            visited[i][j] = True
            if check(i, j):
                board[i][j] = 2
            dfs(i, j)
            visited[i][j] = False
            melt()
            t += 1
            print(print_board())
print(t)

