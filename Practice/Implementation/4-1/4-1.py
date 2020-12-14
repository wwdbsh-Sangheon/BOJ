n = int(input())
plan = input().split()
move_types = {"D":0, "U":1, "R":2, "L":3}
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
x, y = 1, 1

for step in plan:
    nx = x + dx[move_types[step]]
    ny = y + dy[move_types[step]]
    if nx >= 1 and nx <= n and ny >= 1 and ny <= n:
        x, y = nx, ny
print("{} {}".format(x, y))
    


