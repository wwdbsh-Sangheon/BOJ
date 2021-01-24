from collections import deque

n, m = map(int, input().split())
direction = [(0, 1), (1, 0), (0, -1), (-1, 0)]
board = []
for _ in range(n):
    board.append(list(input()))

def bfs():
    queue = deque()
    queue.append((0, 0, 1))
    board[0][0] = "0"
    while len(queue) != 0:
        cur = queue.popleft()
        if cur[0] == n-1 and cur[1] == m-1:
            return cur[2]
        for i in range(4):
            nx = cur[0] + direction[i][0]
            ny = cur[1] + direction[i][1]
            if nx >= 0 and nx < n and ny >= 0 and ny < m and board[nx][ny] == "1":
                queue.append((nx, ny, cur[2]+1))
                board[nx][ny] = "0"
    return -1

print(bfs())