from collections import deque

def mul(a):
    return str(int(a)*2)

def add(a):
    return a+"1"

def bfs(A):
    global ans
    q = deque()
    q.append((A, 0))
    while len(q) != 0:
        now = q.popleft()
        if now[0] == B:
            ans = min(ans, now[1]+1)
            return
        if int(now[0]) > int(B):
            continue
        for f in func:
            new_a = f(now[0])
            q.append((new_a, now[1]+1))
    ans = -1

func = [mul, add]
ans = 1e9
A, B = input().split()
bfs(A)
print(ans)




