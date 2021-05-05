import sys
sys.setrecursionlimit(10000)

r, c = map(int, input().split())
board = []
for _ in range(r):
    board.append(list(input()))
direction = [(1, 0), (0, 1), (-1, 0), (0, -1)]
alpha = [False for _ in range(26)]
ans = 0

def dfs(x, y, cnt):
    global ans
    for d in direction:
        nx = x + d[0]
        ny = y + d[1]
        if nx >= 0 and nx < r and ny >= 0 and ny < c:
            if not alpha[ord(board[nx][ny])-65]:
                alpha[ord(board[nx][ny])-65] = True
                dfs(nx, ny, cnt+1)
                alpha[ord(board[nx][ny])-65] = False
    ans = max(ans, cnt)

alpha[ord(board[0][0])-65] = True
dfs(0, 0, 1)
print(ans)