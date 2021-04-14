n = int(input())
seq = list(map(int, input().split()))
dp = [1]
for i in range(1, n):
    dp.append(1)
    for j in range(0, i):
        if seq[i] > seq[j]:
            dp[i] = max(dp[i], dp[j]+1)
print(max(dp))