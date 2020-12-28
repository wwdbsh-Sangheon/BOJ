import sys
sys.setrecursionlimit(10000)

def watch(x, y, d):
    while True:
        nx, ny = x + d[0], y + d[1]
        if nx < 0 or nx >= n or ny < 0 or ny >= n or board[nx][ny] == 'O':
            break
        if board[nx][ny] == 'S':
            return True
        x, y = nx, ny
    return False

def surveillance():
    for i in range(n):
        for j in range(n):
            if board[i][j] == 'T':
                for d in direction:
                    if watch(i, j, d):
                        return True
    return False

def build(x, count):
    if count == 3:
        if not surveillance():
            global ans
            ans = "YES"
        return
    for i in range(x, n):
        for j in range(n):
            if board[i][j] == 'X':
                board[i][j] = 'O'
                build(i, count+1)
                board[i][j] = 'X'

n = int(input())
board = []
for _ in range(n):
    board.append(list(input().split()))
direction = [(1, 0), (-1, 0), (0, 1), (0, -1)]
ans = "NO"
build(0, 0)
print(ans)
