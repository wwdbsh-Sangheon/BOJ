n = int(input())
dp = [[0 for _ in range(n)] for _ in range(10)]
col_sum = 10
for col in range(n):
    for row in range(10):
        if col == 0:
            dp[row][col] = 1
            continue
        if row == 0:
            dp[row][col] = col_sum%10007
            continue
        dp[row][col] = (dp[row-1][col] - dp[row-1][col-1])%10007
        col_sum += dp[row][col]
print(col_sum%10007)