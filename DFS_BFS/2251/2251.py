from collections import deque

def bfs(chk, A, B, C):
    global ans
    q = deque()
    q.append((0, 0, C))
    while len(q) != 0:
        a, b, c = q.popleft()
        if chk[a][b][c]: continue
        chk[a][b][c] = True
        if a == 0: ans.append(c)
        # A => B
        if a+b > B: q.append((a+b-B, B, c))
        else: q.append((0, a+b, c))
        # A => C
        if a+c > C: q.append((a+c-C, b, C))
        else: q.append((0, b, a+c))
        # B => A
        if b+a > A: q.append((A, b+a-A, c))
        else: q.append((b+a, 0, c))
        # B => C
        if b+c > C: q.append((a, b+c-C, C))
        else: q.append((a, 0, b+c))
        # C => A
        if c+a > A: q.append((A, b, c+a-A))
        else: q.append((c+a, b, 0))
        # C => B
        if c+b > B: q.append((a, B, c+b-B))
        else: q.append((a, c+b, 0))

A, B, C = map(int, input().split())
chk = [[[False for _ in range(201)] for _ in range(201)] for _ in range(201)]
ans = []
bfs(chk, A, B, C)
ans.sort()
print(" ".join(map(str, ans)))