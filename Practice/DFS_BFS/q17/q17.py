import sys
sys.setrecursionlimit(10000)

def spread_virus(xx, yy, t):
    for d in direction:
        nx = xx + d[0]
        ny = yy + d[1]
        if nx >= 0 and nx < n and ny >= 0 and ny < n and board[nx][ny] == 0:
            board[nx][ny] = t
            virus[t].append((nx, ny))
            if nx == x-1 and ny == y-1:
                return True
    return False

def for_sec(sec):
    if sec == s:
        return
    for v in range(1, k+1):
        v_spot = virus[v].copy()
        for vv in v_spot:
            if len(virus[v]) != 0: virus[v].remove(vv)
            if spread_virus(vv[0], vv[1], v):
                return
    for_sec(sec+1)

n, k = map(int, input().split())
virus = dict((t, []) for t in range(1, k+1))
direction = [(1, 0), (-1, 0), (0, 1), (0, -1)]
board = [[0]*n for _ in range(n)]
for i in range(n):
    line = list(map(int, input().split()))
    for j in range(n):
        t = line[j]
        if t != 0:
            virus[t].append((i, j))
            board[i][j] = t
s, x, y = map(int, input().split())
for_sec(0)
print(board[x-1][y-1])