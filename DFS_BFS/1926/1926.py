import sys
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())
direction = [(0, 1), (1, 0), (-1, 0), (0, -1)]

board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

def get_area(x, y):
    area = 1
    board[x][y] = 0
    for d in direction:
        nx = x + d[0]
        ny = y + d[1]
        if nx >= 0 and nx < n and ny >= 0 and ny < m and board[nx][ny] == 1:
            board[nx][ny] = 0
            area += get_area(nx, ny)
    return area

count = 0
max_area = 0

for i in range(n):
    for j in range(m):
        if board[i][j] == 1:
            count += 1
            max_area = max(max_area, get_area(i, j))
print(count)
print(max_area)