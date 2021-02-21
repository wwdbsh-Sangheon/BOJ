n = int(input())
dp = []
for _ in range(n):
    dp.append(list(map(int, input().split())))
for row in range(n-2, -1, -1):
    for col in range(row+1):
        dp[row][col] = max(dp[row][col]+dp[row+1][col], dp[row][col]+dp[row+1][col+1])
print(dp[0][0])