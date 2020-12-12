n = int(input())
coins = list(map(int, input().split()))

coins.sort()

min_num = 1
for coin in coins:
    if min_num < coin: break
    min_num += coin
print(min_num)