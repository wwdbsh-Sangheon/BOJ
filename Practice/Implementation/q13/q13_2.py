from itertools import combinations

def get_dist(h, c):
    return abs(h[0]-c[0]) + abs(h[1]-c[1])

def get_chicken_dist(candidate):
    c_dist = 0
    for h in house:
        dist = 1e9
        for c in candidate:
            dist = min(dist, get_dist(h, c))
        c_dist += dist
    return c_dist

n, m = map(int, input().split())
chicken, house, = [], []
for i in range(n):
    line = input().split()
    for j in range(n):
        if line[j] == '1':
            house.append((i, j))
        if line[j] == '2':
            chicken.append((i, j))

ans = 1e9
candidates = list(combinations(chicken, m))
for candidate in candidates:
    ans = min(ans, get_chicken_dist(candidate))
print(ans)