t = int(input())
while t > 0:
    n, m = map(int, input().split())
    dp = [[0 for _ in range(m)] for _ in range(n)]
    for i in range(m):
        dp[0][i] = i+1
    for i in range(1, n):
        for j in range(m):
            if i == j:
                dp[i][j] = 1
            else:
                dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
    print(dp[n-1][m-1])
    t -= 1