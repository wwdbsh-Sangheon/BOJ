n, m = map(int, input().split())
x, y, head = map(int, input().split())
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
map_ = []
for i in range(n):
    map_.append(list(map(int, input().split())))

def move(x, y, h, count):
    if x < 0 or x > n-1 or y < 0 or y > m-1 or map_[x][y] == 1:
        return count
    
    for i in range(4):
        h = 3 if h-1 < 0 else h-1
        nx = x + dx[h]
        ny = y + dy[h]
        if nx >= 0 and nx < n and ny >= 0 and ny < m:
            if map_[nx][ny] == 0:
                map_[nx][ny] = 2
                return move(nx, ny, h, count+1)
    return move(x+dx[h], y+dx[h], h, count)

map_[x][y] = 2
print(move(x, y, head, 1))



