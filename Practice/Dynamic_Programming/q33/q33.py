n = int(input())
t = []
p = []
dp = [0]*(n+1)
for i in range(n):
    ti, pi = map(int, input().split())
    t.append(ti)
    p.append(pi)
max_v = 0
for i in range(n-1, -1, -1):
    time = t[i] + i
    if time <= n:
        dp[i] = max(p[i]+dp[time], max_v)
        max_v = dp[i]
    else:
        dp[i] = max_v
print(max_v)