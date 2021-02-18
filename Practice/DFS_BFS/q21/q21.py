from collections import deque

n, l, r = map(int, input().split())
board = []
direction = [(-1, 0), (0, 1), (0, -1), (1, 0)]
chk = [[False for _ in range(n)] for _ in range(n)] 
for _ in range(n):
    board.append(list(map(int, input().split())))

def check_union(p1, p2):
    diff = abs(p1-p2)
    return diff >= l and diff <= r

def bfs(x, y):
    total = 0
    union = []
    queue = deque()
    queue.append((x, y))
    chk[x][y] = True
    while len(queue) != 0:
        c = queue.popleft()
        union.append(c)
        total += board[c[0]][c[1]]
        for d in direction:
            nx = c[0] + d[0]
            ny = c[1] + d[1]
            if nx >= 0 and nx < n and ny >= 0 and ny < n and not chk[nx][ny] and check_union(board[c[0]][c[1]], board[nx][ny]):
                queue.append((nx, ny))
                chk[nx][ny] = True
    total //= len(union)
    for c in union:
        board[c[0]][c[1]] = total
    return 1 if len(union) != 1 else 0

def set_union():
    global chk
    union_count = 0
    for i in range(n):
        for j in range(n):
            if chk[i][j] == False:
                union_count += bfs(i, j)
    chk = [[False for _ in range(n)] for _ in range(n)] 
    return union_count

ans = 0
while set_union() != 0:
    ans += 1

print(ans)