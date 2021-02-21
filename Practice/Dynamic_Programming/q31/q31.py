t = int(input())
while t > 0:
    n, m = map(int, input().split())
    gold = list(map(int, input().split()))
    dp = []
    index = 0
    for i in range(n+2):
        if i == 0 or i == n+1:
            dp.append([0]*m)
            continue
        dp.append(gold[index:index+m])
        index += m
    for col in range(1, m):
        for row in range(1, n+1):
            dp[row][col] = max(dp[row-1][col], dp[row-1][col-1]+dp[row][col], dp[row][col-1]+dp[row][col], dp[row+1][col-1]+dp[row][col])
    t -= 1
    print(dp[n][m-1])