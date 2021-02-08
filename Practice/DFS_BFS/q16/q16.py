import sys
sys.setrecursionlimit(10000)
from collections import deque

n, m = map(int, input().split())
direction = [(0, 1), (1, 0), (-1, 0), (0, -1)]
board = []
copy_board = [[0]*m for _ in range(n)]
for _ in range(n):
    board.append(list(map(int, input().split())))

def get_safe_area():
    area = 0
    for i in range(n):
        for j in range(m):
            if copy_board[i][j] == 0:
                area += 1
    return area

# def virus(x, y):
#     for i in range(4):
#         nx = x + direction[i][0]
#         ny = y + direction[i][1]
#         if nx >= 0 and nx < n and ny >= 0 and ny < m and copy_board[nx][ny] == 0:
#             copy_board[nx][ny] = 2
#             virus(nx, ny)

def virus(x, y):
    queue = deque()
    queue.append((x, y))
    while len(queue) != 0:
        pos = queue.popleft()
        for i in range(4):
            nx = pos[0] + direction[i][0]
            ny = pos[1] + direction[i][1]
            if nx >= 0 and nx < n and ny >= 0 and ny < m and copy_board[nx][ny] == 0:
                copy_board[nx][ny] = 2
                queue.append((nx, ny))

def copy_():
    for i in range(n):
        for j in range(m):
            copy_board[i][j] = board[i][j]

def build(count):
    safe_area = 0
    if count == 3:
        copy_()
        for i in range(n):
            for j in range(m):
                if copy_board[i][j] == 2:
                    virus(i, j)
        return get_safe_area()

    for i in range(n):
        for j in range(m):
            if board[i][j] == 0:
                board[i][j] = 1
                safe_area = max(safe_area, build(count+1))
                board[i][j] = 0
    return safe_area

print(build(0))