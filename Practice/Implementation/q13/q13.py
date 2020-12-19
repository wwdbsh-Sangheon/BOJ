import sys
sys.setrecursionlimit(10000)

def get_dist(h_x, h_y, c_x, c_y):
    return abs(h_x-c_x) + abs(h_y-c_y)

def get_chicken_dist(h):
    dist = 1e9
    for i in range(len(chicken)):
        if selected[i]:
            dist = min(dist, get_dist(h[0], h[1], chicken[i][0], chicken[i][1]))
    return dist

def get_total_dist():
    tot = 0
    for h in house:
        tot += get_chicken_dist(h)
    return tot

def dfs(dist, count, idx):
    if count == m:
        return min(dist, get_total_dist())
    for i in range(idx, len(chicken)):
        if not selected[i]:
            selected[i] = True
            dist = min(dist, dfs(dist, count+1, i))
            selected[i] = False
    return dist


n, m = map(int, input().split())
chicken, house, selected = [], [], []
for i in range(n):
    line = input().split()
    for j in range(n):
        if line[j] == '1':
            house.append((i, j))
        if line[j] == '2':
            chicken.append((i, j))
            selected.append(False)

print(dfs(1e9, 0, 0))