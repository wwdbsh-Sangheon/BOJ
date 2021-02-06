from collections import deque

n, m, k, x = map(int, input().split())
adj = [[] for _ in range(n+1)]
chk = [False for _ in range(n+1)]
ans = []
for _ in range(m):
    c1, c2 = map(int, input().split())
    adj[c1].append(c2)

def get_k_dist_city(start):
    queue = deque()
    queue.append((start, 0))
    chk[start] = True
    while len(queue) != 0:
        city = queue.popleft()
        if city[1] == k:
            ans.append(city[0])
        for c in adj[city[0]]:
            if chk[c] == False:
                queue.append((c, city[1]+1))
                chk[c] = True

get_k_dist_city(x)
if len(ans) == 0:
    print(-1)
else:
    ans.sort()
    for c in ans:
        print(c)