direction = [(-1, -1), (0, 1), (0, -1), (-1, 0), (1, 0)]
dice = [0]*7; cur = 1; east = 3; west = 4; north = 2; south = 5
n, m, x, y, k = map(int, input().split())
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

for req in map(int, input().split()):
    next_ = None
    nx = x + direction[req][0]
    ny = y + direction[req][1]
    if nx >= 0 and nx < n and ny >= 0 and ny < m:
        if req == 1: # east
            next_ = east
            east = 7-cur
            west = cur
        elif req == 2: # west
            next_ = west
            west = 7-cur
            east = cur
        elif req == 3: # north
            next_ = north
            north = 7-cur
            south = cur
        else: # south
            next_ = south
            south = 7-cur
            north = cur
        print(dice[7-next_])
        if board[nx][ny] == 0:
            board[nx][ny] = dice[next_]
        else:
            dice[next_] = board[nx][ny]
            board[nx][ny] = 0
        x = nx; y = ny
        cur = next_