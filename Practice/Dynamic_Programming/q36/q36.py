A = input()
B = input()
n = len(A)
m = len(B)
dp = [[0]*(m+1) for _ in range(n+1)]
for row in range(n+1):
    for col in range(m+1):
        if row == 0 and col == 0:
            continue
        if row == 0:
            dp[row][col] = col
            continue
        if col == 0:
            dp[row][col] = row
            continue
        if A[row-1] == B[col-1]:
            dp[row][col] = dp[row-1][col-1]
        else:
            dp[row][col] = 1 + min(dp[row-1][col-1], dp[row-1][col], dp[row][col-1])
print(dp[n][m])